package org.mildempeach.web;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.mildempeach.entity.*;
import org.mildempeach.entity.Record;
import org.mildempeach.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;

    @Autowired
    BillService billService;

    @Autowired
    RecordService recordService;

    @Autowired
    InstrumentService instrumentService;

    @Autowired
    ReviewService reviewService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        User user = userService.getUserByName(username);
        if (user == null) {
            return "unknownUser";
        } else if (!user.getPassword().equals(password)){
            return "wrongPassword";
        } else {
            httpSession.setAttribute("user", user);
            return "redirect:/instruments";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        cartService.deleteFromCart(user.getId());
        httpSession.removeAttribute("user");
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(HttpServletRequest httpServletRequest) {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        userService.insertUser(username, password);
        return "index";
    }

    @GetMapping("/instruments")
    public String instruments(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("instruments", instrumentService.displayInstruments());
        model.addAttribute("user", user);
        return "instruments";
    }

    @GetMapping("/instruments/{id}")
    public String instrument(@PathVariable int id, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        Instrument instrument = instrumentService.getInstrumentById(id);
        model.addAttribute("instrument", instrument);
        return "instrument";
    }

    @PostMapping("/instruments/{id}")
    public String doInstrument(HttpServletRequest httpServletRequest, @PathVariable int id, HttpSession session) {
        int number = Integer.parseInt(httpServletRequest.getParameter("number"));
        Instrument instrument = instrumentService.getInstrumentById(id);
        User user = (User) session.getAttribute("user");
        cartService.addToCart(user.getId(), instrument.getId(), instrument.getName(), number, instrument.getPrice(), instrument.getWeight());
        return "redirect:/instruments";
    }

    @GetMapping("/cart/{id}")
    public String cart(@PathVariable("id") int userid, Model model) {
        User user = userService.getUserById(userid);
        model.addAttribute("user", user);
        List<Cart> carts = cartService.getCartByUserId(userid);
        if (carts == null || carts.isEmpty()) {
            return "emptyCart";
        }
        model.addAttribute("carts", carts);
        double amount = 0;
        double weight = 0;
        for (Cart cart : carts) {
            amount += cart.getPrice() * cart.getNumber();
            weight += cart.getWeight() * cart.getNumber();
        }
        model.addAttribute("amount", amount);
        model.addAttribute("weight", weight);
        return "cart";
    }

    @GetMapping("/deletecart/{userid}/{instrumentid}")
    public String deleteCartById(@PathVariable int userid, @PathVariable int instrumentid) {
        cartService.deleteFromCart(userid, instrumentid);
        return "redirect:/cart/" + userid;
    }

    @GetMapping("/emptycart/{userid}")
    public String emptyCart(@PathVariable int userid) {
        cartService.deleteFromCart(userid);
        return "redirect:/cart/" + userid;
    }

    @GetMapping("/makebills/{userid}")
    public String makeBill(@PathVariable int userid) {
        List<Cart> carts = cartService.getCartByUserId(userid);
        if (carts == null || carts.isEmpty()) {
            return "emptyCart";
        }
        double amount = 0;
        double weight = 0;
        for (Cart cart : carts) {
            amount += cart.getPrice() * cart.getNumber();
            weight += cart.getWeight() * cart.getNumber();
        }
        Bill bill = new Bill(userid, amount, weight);
        billService.InsertBill(bill);
        long billId = bill.getId();
        for (Cart cart : carts) {
            Record record = new Record(billId, userid, cart.getInstrumentid(), cart.getInstrumentname(), cart.getNumber());
            recordService.InsertRecord(record);
        }
        cartService.deleteFromCart(userid);
        return "successBuy";
    }

    @GetMapping("/history/{userid}")
    public String history(@PathVariable int userid, Model model) {
        User user = userService.getUserById(userid);
        List<Bill> bills = billService.getAllBillsByUserId(userid);
        if (bills == null || bills.isEmpty()) {
            return "emptyBill";
        }
        model.addAttribute("bills", bills);
        model.addAttribute("user", user);
        return "historybills";
    }

    @GetMapping("/history/{userid}/{billid}")
    public String historyBills(@PathVariable int userid, @PathVariable int billid, Model model) {
        User user = userService.getUserById(userid);
        List<Record> records = recordService.getRecordByBillId(billid);
        model.addAttribute("records", records);
        model.addAttribute("user", user);
        model.addAttribute("billid", billid);
        return "historyrecords";
    }

    @GetMapping("/review/{userid}/{instrumentid}")
    public String review(@PathVariable int userid, @PathVariable int instrumentid, Model model) {
        model.addAttribute("user", userService.getUserById(userid));
        model.addAttribute("instrument", instrumentService.getInstrumentById(instrumentid));
        Review review = reviewService.getReviewById(instrumentid, userid);
        if (review != null) {
            String comment = review.getComment();
            model.addAttribute("comment", comment);
            return "errorComment";
        }
        return "review";
    }

    @PostMapping("/review/{userid}/{instrumentid}")
    public String doReview(@PathVariable int userid, @PathVariable int instrumentid, HttpServletRequest httpServletRequest) {
        String comment = httpServletRequest.getParameter("comment");
        Review review = new Review(instrumentid, userid, comment);
        reviewService.insertReview(review);
        return "redirect:/history/" + userid;
    }

    @GetMapping("/review/{instrumenid}")
    public String getReviews(@PathVariable int instrumenid, Model model) {
        List<Review> reviews = reviewService.getReviewByInstrumentid(instrumenid);
        if (reviews == null || reviews.isEmpty()) {
            return "emptyReview";
        }
        model.addAttribute("reviews", reviews);
        model.addAttribute("instrumenid", instrumenid);
        return "checkReviews";
    }

}

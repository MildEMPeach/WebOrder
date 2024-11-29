package org.mildempeach.service;

import org.mildempeach.entity.Cart;
import org.mildempeach.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartService {
    @Autowired
    CartMapper cartMapper;

    public List<Cart> getCartByUserId(long id) {
        return cartMapper.getCartsByUserid(id);
    }

    public void addToCart(long userid, long instrumentid, String instrumentname, int number, double price, double weight) {
        cartMapper.insertCart(userid, instrumentid, instrumentname, number, price, weight);
    }

    public void deleteFromCart(long userid, long instrumentid) {
        cartMapper.deleteCartByUseridAndInstrumentId(userid, instrumentid);
    }

    public void deleteFromCart(long userid) {
        cartMapper.deleteCartByUserid(userid);
    }

}

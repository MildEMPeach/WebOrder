package org.mildempeach.service;

import org.mildempeach.entity.Bill;
import org.mildempeach.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BillService {
    @Autowired
    BillMapper billMapper;

    public void InsertBill(Bill bill) {
        billMapper.insertBill(bill);
    }

    public List<Bill> getAllBillsByUserId(int userId) {
        return billMapper.selectBillsByCustomerId(userId);
    }
}

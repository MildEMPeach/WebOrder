package org.mildempeach.service;

import org.mildempeach.entity.Cart;
import org.mildempeach.entity.Instrument;
import org.mildempeach.mapper.CartMapper;
import org.mildempeach.mapper.InstrumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InstrumentService {
    @Autowired
    InstrumentMapper instrumentMapper;

    public List<Instrument> displayInstruments() {
        return instrumentMapper.selectAllInstruments();
    }

    public Instrument getInstrumentById(int id) {
        return instrumentMapper.selectInstrumentById(id);
    }



}

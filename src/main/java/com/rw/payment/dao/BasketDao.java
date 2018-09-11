package com.rw.payment.dao;

import com.rw.payment.dto.basket.BasketOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class BasketDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<BasketOrder> getBasketOrders(String basketId) {
        return new ArrayList<>();
    }
}

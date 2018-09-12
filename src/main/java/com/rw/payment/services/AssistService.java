package com.rw.payment.services;

import com.rw.payment.dto.ps.assist.Order;
import com.rw.payment.dto.ps.assist.PushPaymentResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class AssistService {
    public PushPaymentResult payment(Order order) {
        return new PushPaymentResult();
    }
}

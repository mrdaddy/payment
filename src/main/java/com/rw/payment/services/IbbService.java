package com.rw.payment.services;

import com.rw.payment.dto.ps.ibb.TicketPaymentRequest;
import com.rw.payment.dto.ps.ibb.TicketPaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class IbbService {
    public TicketPaymentResponse payment(TicketPaymentRequest request) {
        return new TicketPaymentResponse();
    }

}

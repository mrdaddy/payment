package com.rw.payment.services;

import com.rw.payment.dto.basket.BasketOrder;
import com.rw.payment.security.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class FreePaymentService {
    public List<BasketOrder> offerBasketWithNoPrice(@Valid @Size(max = 20) String basketId, @Valid @NotNull User user) {
        return new ArrayList<>();
    }
}

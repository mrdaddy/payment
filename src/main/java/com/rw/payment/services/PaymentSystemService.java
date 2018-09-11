package com.rw.payment.services;

import com.rw.payment.dao.PaymentSystemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Service
@Validated
public class PaymentSystemService {
    @Autowired
    PaymentSystemDao paymentSystemDao;

    public List<String> getAvailablePS(@Valid @Size(min = 1, max = 20) String basketId) {
        return paymentSystemDao.getAvailablePS();
    }

    public String selectPS(@Valid @Size(min = 1, max = 20) String basketId, @Valid @Size(min = 4, max = 5) String psId) {
        if(psId.equals("ERIP")) {
            return "12345";
        } else {
            return null;
        }
    }
}

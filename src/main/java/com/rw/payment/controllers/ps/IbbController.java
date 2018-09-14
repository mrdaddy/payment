package com.rw.payment.controllers.ps;

import com.rw.payment.dto.ps.ibb.TicketPaymentRequest;
import com.rw.payment.dto.ps.ibb.TicketPaymentResponse;
import com.rw.payment.services.IbbService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_XML_VALUE, path = "/${service.version}/payment/ps/ibb")
@ApiIgnore
public class IbbController {

    @Autowired
    IbbService ibbService;

    @RequestMapping(method = RequestMethod.POST, path = "/payment")
    @ResponseBody
    public TicketPaymentResponse payment(@RequestParam TicketPaymentRequest request) {
        return ibbService.payment(request);
    }

}

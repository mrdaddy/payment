package com.rw.payment.controllers.ps;

import com.rw.payment.controllers.PaymentSystemController;
import com.rw.payment.dto.ErrorMessage;
import com.rw.payment.dto.ps.assist.Order;
import com.rw.payment.dto.ps.assist.PushPaymentResult;
import com.rw.payment.services.AssistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_XML_VALUE, path = "/${service.version}/payment/ps/assist")
@ApiIgnore
public class AssistController {
    @Autowired
    AssistService assistService;

    @RequestMapping(method = RequestMethod.POST, path = "/payment")
    @ResponseBody
    public PushPaymentResult payment(@RequestParam Order order) {
        return assistService.payment(order);
    }

}

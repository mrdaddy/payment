package com.rw.payment.controllers.ps;

import com.rw.payment.dto.ps.erip.*;
import com.rw.payment.services.EripService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_XML_VALUE, path = "/${service.version}/payment/ps/erip")
@ApiIgnore
public class EripController {

    @Autowired
    EripService eripService;

    @RequestMapping(method = RequestMethod.POST, path = "/info")
    @ResponseBody
    public ServiceInfoResponse info(@RequestParam ServiceInfoRequest request) {
        return eripService.info(request);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/transactionstart")
    @ResponseBody
    public TransactionStartResponse transactionStart(@RequestParam TransactionStartRequest request) {
        return eripService.transactionStart(request);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/transactionresult")
    @ResponseBody
    public TransactionResultResponse transactionResult(@RequestParam TransactionResultRequest request) {
        return eripService.transactionResult(request);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/stornstart")
    @ResponseBody
    public StornStartResponse stornStart(@RequestParam StornStartRequest request) {
        return eripService.stornStart(request);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/stornresult")
    @ResponseBody
    public StornResultResponse stornResultResult(@RequestParam StornResultRequest request) {
        return eripService.stornResult(request);
    }
}

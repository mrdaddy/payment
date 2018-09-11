package com.rw.payment.controllers;

import com.rw.payment.services.PaymentSystemService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.net.HttpURLConnection;
import java.util.List;

@RestController
@Api(value="payment/ps", description="Сервис работы с платёжными системами для оплаты корзины заказов", tags = "Получение информации о платёжных системах", basePath="/payment/ps")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/${service.version}/payment/ps")

public class PaymentSystemController extends BaseController{
    @Autowired
    PaymentSystemService paymentSystemService;

    @RequestMapping(method = RequestMethod.GET, path = "/{basketId}")
    @ApiOperation(value = "Получение списка доступных платёжных систем для оплаты картины заказов. Сервис возвращает список идентификаторов доступных платёжных систем", authorizations = @Authorization("jwt-auth"))
    @ResponseStatus( HttpStatus.OK)
    public List<String> getAvailablePS(@PathVariable(value = "basketId") @Valid @Size(max = 20) @ApiParam(value="Уникальный идентификатор корзины заказов, полученный при создании первого закака", example = "74835926988082", required = true) String basketId) {
        return paymentSystemService.getAvailablePS(basketId);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{basketId}")
    @ApiOperation(value = "Выбор платёжной системы для оплаты корзины заказов. Сервис возвращает номер платежа для системы ЕРИП, если выбрана другая платёжная система - пусто", authorizations = @Authorization("jwt-auth"))
    @ResponseStatus( HttpStatus.ACCEPTED)
    public
    String selectPS(@PathVariable(value = "basketId") @Valid @Size(max = 20) @ApiParam(value="Уникальный идентификатор корзины заказов, полученный при создании первого закака", example = "74835926988082", required = true) String basketId,
                    @RequestParam(value = "psId") @ApiParam(value="Уникальный идентификатор платёжной системы", example = "ERIP", required = true) String psId) {
        return paymentSystemService.selectPS(basketId, psId);
    }

}

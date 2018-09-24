package com.rw.payment.controllers;

import com.rw.payment.dto.basket.BasketOrder;
import com.rw.payment.dto.ErrorMessage;
import com.rw.payment.security.User;
import com.rw.payment.services.BasketService;
import com.rw.payment.services.FreePaymentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@Api(value="payment/basket", description="Сервис получения состояния оплаты корзины заказов (заказа)", tags = "Получение состояния оплаты корзины заказов", basePath="/payment/basket")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/${service.version}/payment/basket")

public class BasketController extends BaseController{
    @Autowired
    BasketService basketService;

    @RequestMapping(method = RequestMethod.GET, path = "/{basketId}")
    @ApiOperation(value = "Получение состояния оплаты корзины заказов (заказа)", authorizations = @Authorization("jwt-auth"))
    @ResponseStatus( HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK",
                    responseHeaders = {
                            @ResponseHeader(name = "ETag", response = String.class, description = "Хеш для кэширования")}),
            @ApiResponse(code = 304, message = "Not Modified")
    })
    public List<BasketOrder> getOrders(@PathVariable(value = "basketId", required = false) @ApiParam(value="Уникальный идентификатор корзины заказов, полученный при создании первого заказа. Необязательный: если не передаётся, то возвращается информация об активной карзине, если она есть", example = "74835926988082", required = false) String basketId,
                                       @RequestHeader(name="IF-NONE-MATCH", required = false) @ApiParam(name="IF-NONE-MATCH", value = "ETag из предыдущего закэшированного запроса") String inm,
                                       @RequestAttribute(value = "user", required = false) @ApiIgnore User user) {
        return basketService.getBasketOrders(basketId, user);
    }

}


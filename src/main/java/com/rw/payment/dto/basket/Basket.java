package com.rw.payment.dto.basket;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "Информация о корзине заказов")
public class Basket {
    public enum BASKET_STATUS {ACTIVE, IN_PAYMENT, PAID, EXPIRED}

    @ApiModelProperty(example = "74835926988082", required = true, value = "Уникальный идентификатор корзины заказов", dataType = "String")
    private String basketId;

    @ApiModelProperty(example = "ACTIVE", required = true, value = "Статус корзины заказов", dataType = "String")
    private BASKET_STATUS status;

    private List<BasketOrder> basketOrders;
}

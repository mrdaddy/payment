package com.rw.payment.dto.basket;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@ApiModel(description = "Информация о корзине заказов")
@AllArgsConstructor
@NoArgsConstructor
public class BasketOrder {
    public enum ORDER_STATUS {B, I, P}
    public enum ORDER_TYPE {NUMBERED, UNNUMBERED}

    @ApiModelProperty(example = "1", required = true, value = "Уникальный идентификатор записи заказа в таблице", dataType = "long")
    private long orderId;

    @ApiModelProperty(example = "74835926988082", required = true, value = "Уникальный номер заказа из АСУ Экспресс или ЭПД", dataType = "String")
    private String orderNum;

    @ApiModelProperty(example = "NUMBERED", required = true, value = "Тип заказа. Значения: NUMBERED - заказы с нумерованными местами, UNNUMBERED - заказы с ненумерованными местами", dataType = "String")
    private ORDER_TYPE orderType;

    @ApiModelProperty(example = "B", required = true, value = "Статус заказа. Значения: B - куплен в АСУ Экспресс, I - в оплате, P - оплачен", dataType = "String")
    private ORDER_STATUS status;

    @ApiModelProperty(required = true, value = "Дата и время начала оплаты", dataType = "Datetime")
    private Date paymentStartTime;

    @ApiModelProperty(required = true, value = "Дата и время, когда заказ должен быть оплачен", dataType = "Datetime")
    private Date paymentEndTime;
}

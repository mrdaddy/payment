package com.rw.payment.dto.basket;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@ApiModel(description = "Дополнительная информация для оплаты для платёжной системы")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {
    public enum PAYMENT_SYSTEM {BB_IB, ERIP, BB_IA}

    @ApiModelProperty(example = "BB_IB", required = true, value = "Идентификатор платёжной системы. BB_IB - Интернет-банкинг Беларусбанка, ERIP - Ерип, BB_IA - Ассист", dataType = "String")
    private PAYMENT_SYSTEM paymentSystem;

    @ApiModelProperty(required = true, value = "Дата и время создания корзины", dataType = "Datetime")
    private Date basketCreateDate;

    @ApiModelProperty(example = "12.12", required = true, value = "Полная стоимость корзины", dataType = "double")
    private double cost;

    @ApiModelProperty(example = "BYN", required = true, value = "Валюта. Всегда BYN (обязательный параметр для Ассист)", dataType = "String")
    private String currency;

    @ApiModelProperty(example = "kFDKLwxoYLp%2BZ1NDCSuCrQ%3D%3D", required = true, value = "Уникальный идентификатор для платежной системы. " +
            "Для каждой платёжной системы этот параметр имеет разное значение, для BB_IB и BB_IA: зашифрованный номер корзины. Для ERIP - уникальный в рамках какого-то небольшого периода пятизначный код для оплаты.", dataType = "String")
    private String offerId;

    @ApiModelProperty(example = "EC941A3541C0A09FF8D170306BC30B31", required = false, value = "Подписанные данные для проверки (заполняется только для Ассист)", dataType = "String")
    private String checkSum;

    @ApiModelProperty(example = "kFDKLwxoYLp%2BZ1NDCSuCrQ%3D%3D", required = false, value = "Уникальный идентификатор клиента для упрощённой оплаты One-Click (заполняется только для Ассист)", dataType = "String")
    private String customerNumber;

}

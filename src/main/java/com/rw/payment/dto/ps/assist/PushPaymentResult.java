package com.rw.payment.dto.ps.assist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pushpaymentresult")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PushPaymentResult {
    private int firstcode;
    private int secondcode;
    private ShortOrder order;
}

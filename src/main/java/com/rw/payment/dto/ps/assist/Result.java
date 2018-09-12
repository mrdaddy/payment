package com.rw.payment.dto.ps.assist;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Result {
    private List<Order> orders;

}

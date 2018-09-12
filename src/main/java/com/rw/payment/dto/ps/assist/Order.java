package com.rw.payment.dto.ps.assist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String ordernumber;
    private String billnumber;
    private int testmode;
    private String ordercomment;
    private double orderamount;
    private String ordercurrency;
    private String firstname;
    private String lastname;
    private String middlename;
    private String email;
    private String orderdate;
    private String orderstate;

    private String fraud_state;
    private String fraud_reason;
    private String packetdate;
    private String signature;
    private String checkvalue;

    private List<Operation> operations;
}

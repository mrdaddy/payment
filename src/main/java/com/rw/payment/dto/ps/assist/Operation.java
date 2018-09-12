package com.rw.payment.dto.ps.assist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    private String billnumber;
    private String operationtype;
    private String operationstate;
    private String amount;
    private String currency;
    private String clientip;
    private String ipaddress;
    private String meantype_id;
    private String meantypename;
    private String meansubtype;
    private String meannumber;
    private String cardholder;
    private String issuebank;
    private String bankcountry;
    private String responsecode;
    private String message;
    private String customermessage;
    private String recommendation;
    private String approvalcode;
    private String protocoltypename;
    private String processingname;
    private String operationdate;
    private String authresult;
    private String authrequired;
    private String transaction_id;
    private String slipno;
}
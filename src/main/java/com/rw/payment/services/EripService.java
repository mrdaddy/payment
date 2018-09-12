package com.rw.payment.services;

import com.rw.payment.dto.ps.erip.*;
import org.springframework.stereotype.Service;

@Service
public class EripService {
    public ServiceInfoResponse info(ServiceInfoRequest request) {
        return new ServiceInfoResponse();
    }

    public TransactionStartResponse transactionStart(TransactionStartRequest request) {
        return new TransactionStartResponse();
    }

    public TransactionResultResponse transactionResult(TransactionResultRequest request) {
        return new TransactionResultResponse();
    }

    public StornStartResponse stornStart(StornStartRequest request) {
        return new StornStartResponse();
    }

    public StornResultResponse stornResult(StornResultRequest request) {
        return new StornResultResponse();
    }
}

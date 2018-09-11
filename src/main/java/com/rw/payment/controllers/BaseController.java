package com.rw.payment.controllers;

import com.rw.payment.dto.ErrorMessage;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Bad request", response = ErrorMessage.class, responseContainer = "List"),
        @ApiResponse(code = 503, message = "Service Unavailable"),
        @ApiResponse(code = 504, message = "Gateway Timeout")
})
@PreAuthorize("hasRole('U')")
public class BaseController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleInvalidRequest(MethodArgumentNotValidException e, WebRequest request) {
        List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
        if(e.getBindingResult().hasErrors()) {
            for(ObjectError oe: e.getBindingResult().getAllErrors()) {
                ErrorMessage errorMessage = new ErrorMessage(oe.getCodes()[0],oe.getDefaultMessage());
                errors.add(errorMessage);
            }
        }
        return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
    }
}

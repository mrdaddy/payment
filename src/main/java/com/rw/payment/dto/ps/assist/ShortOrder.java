package com.rw.payment.dto.ps.assist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortOrder {
    private String billnumber;
    private String packetdate;
}

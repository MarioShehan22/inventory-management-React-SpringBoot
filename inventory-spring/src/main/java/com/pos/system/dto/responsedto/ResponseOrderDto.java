package com.pos.system.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDto {
    private String email;
    private String name;

    private LocalDateTime issuedDate;
    private double totalCost;
}

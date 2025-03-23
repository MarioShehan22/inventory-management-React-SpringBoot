package com.pos.system.dto.responsedto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ResponseCustomerDto {
    private String id;
    private String email;
    private String name;
    private String contact;
    private double salary;
}

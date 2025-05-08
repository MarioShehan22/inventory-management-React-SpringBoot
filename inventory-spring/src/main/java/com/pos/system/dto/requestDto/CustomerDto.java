package com.pos.system.dto.requestDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private String email;
    private String name;
    private String contact;
    private double salary;
}

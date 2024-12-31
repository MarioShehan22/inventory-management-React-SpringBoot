package com.pos.system.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerDto {
    private long id;
    private String email;
    private String name;
    private String contact;
    private double salary;
}

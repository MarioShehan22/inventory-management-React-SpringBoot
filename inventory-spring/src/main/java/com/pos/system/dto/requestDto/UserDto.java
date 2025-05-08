package com.pos.system.dto.requestDto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String email;
    private String password;
}

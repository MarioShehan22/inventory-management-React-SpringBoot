package com.pos.system.dto.responsedto;

import java.time.LocalDateTime;

public interface OrderDetailInterface {
    String getEmail();
    String getName();
    LocalDateTime getIssuedDate();
    Double getTotalCost();
}

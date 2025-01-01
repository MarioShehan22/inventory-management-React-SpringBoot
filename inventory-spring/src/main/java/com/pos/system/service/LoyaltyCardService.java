package com.pos.system.service;

import com.pos.system.dto.LoyaltyCardDto;
import java.sql.SQLException;

public interface LoyaltyCardService {
    public void saveLoyaltyData(LoyaltyCardDto dto) throws SQLException, ClassNotFoundException;
}

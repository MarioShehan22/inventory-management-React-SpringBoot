package com.pos.system.service.impl;

import com.pos.system.dto.LoyaltyCardDto;
import com.pos.system.entity.LoyaltyCard;
import com.pos.system.repo.CustomerRepo;
import com.pos.system.repo.LoyaltyCardRepo;
import com.pos.system.service.LoyaltyCardService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class LoyaltyCardServiceImpl implements LoyaltyCardService {

    private final LoyaltyCardRepo loyaltyCardRepo;

    @Autowired
    public LoyaltyCardServiceImpl(LoyaltyCardRepo loyaltyCardRepo) {
        this.loyaltyCardRepo = loyaltyCardRepo;
    }

    @Override
    public void saveLoyaltyData(LoyaltyCardDto dto) {
        UUID uuid = UUID.randomUUID();
        long id = uuid.getMostSignificantBits();

        LoyaltyCard loyaltyCard = new LoyaltyCard();
        loyaltyCard.setCode((int) id);
        loyaltyCard.setCardType(dto.getCardType());
        loyaltyCard.setBarcode(dto.getBarcode());
        loyaltyCard.setEmail(dto.getEmail());
        loyaltyCardRepo.save(loyaltyCard);
    }
}

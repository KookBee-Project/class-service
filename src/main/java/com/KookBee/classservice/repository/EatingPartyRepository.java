package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.EatingParty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EatingPartyRepository extends JpaRepository<EatingParty, Long> {
    Optional<EatingParty> findByUserId(Long userId);

    Integer countById(Long eatingPartyId);
}

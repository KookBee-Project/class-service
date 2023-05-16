package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.request.EatingPartyRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class EatingParty {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eating_party_id")
    private Long id;
    private Long userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eating_together_id")
    private EatingTogether eatingTogether;

    public EatingParty(EatingPartyRequest request) {
        this.eatingTogether = new EatingTogether(request.getEatingTogetherId());
    }
}

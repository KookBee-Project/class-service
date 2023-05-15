package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.request.EatingPartyRequest;
import com.KookBee.classservice.domain.request.EatingTogetherRequest;
import jakarta.persistence.*;
import jakarta.ws.rs.DefaultValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class EatingTogether {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eating_together_id")
    private Long id;
    private Long bootcampId;
    private String postTitle;
    private String postContents;
    private Long userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_info_id")
    private RestaurantInfo restaurantInfo;
    private LocalDate appointmentDate;
    private Integer personnel;

    @OneToMany(mappedBy = "eatingTogether")
    private List<EatingParty> eatingParty;

    public EatingTogether(EatingTogetherRequest request) {
        this.bootcampId = request.getBootcampId();
        this.postTitle = request.getPostTitle();
        this.postContents = request.getPostContents();
        this.userId = request.getUserId();
        this.restaurantInfo = new RestaurantInfo(request.getRestaurantInfoId());
        this.appointmentDate = LocalDate.now();
        this.personnel = request.getPersonnel();
    }

    public EatingTogether(Long id){
        this.id = id;
    }
}

package com.KookBee.classservice.service;

import com.KookBee.classservice.client.UserServiceClient;
import com.KookBee.classservice.domain.entity.EatingParty;
import com.KookBee.classservice.domain.entity.EatingTogether;
import com.KookBee.classservice.domain.entity.RestaurantInfo;
import com.KookBee.classservice.domain.request.EatingTogetherRequest;
import com.KookBee.classservice.domain.request.EatingPartyRequest;
import com.KookBee.classservice.domain.request.PostRestaurantInfoRequest;
import com.KookBee.classservice.domain.response.EatingTogetherResponse;
import com.KookBee.classservice.domain.response.RestaurantResponse;
import com.KookBee.classservice.exception.ParticipateException;
import com.KookBee.classservice.exception.RestaurantCheckException;
import com.KookBee.classservice.repository.EatingPartyRepository;
import com.KookBee.classservice.repository.EatingTogetherRepository;
import com.KookBee.classservice.repository.RestaurantInfoRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EatingTogetherService {
    private final RestaurantInfoRepository restaurantInfoRepository;
    private final EatingTogetherRepository eatingTogetherRepository;
    private final EatingPartyRepository eatingPartyRepository;
    private final JwtService jwtService;
    private final UserServiceClient userServiceClient;

    public String postRestaurant(PostRestaurantInfoRequest request) throws RestaurantCheckException {
        Optional<RestaurantInfo> restaurant = restaurantInfoRepository.findByRestaurantPositionLaAndRestaurantPositionMa(request.getRestaurantPositionLa(), request.getRestaurantPositionMa());
        System.out.println(restaurant);
        if(restaurant.isPresent()) {
            throw new RestaurantCheckException();
        }
        RestaurantInfo restaurantInfo = new RestaurantInfo(request);
        restaurantInfoRepository.save(restaurantInfo);
        return "등록이 완료되었습니다.";
    }

    public List<RestaurantResponse> getRestaurant(){
        List<RestaurantInfo> all = restaurantInfoRepository.findAll();
        List<RestaurantResponse> collect = all.stream().map(RestaurantResponse::new).collect(Collectors.toList());
        return collect;
    }

    public String postWrite(EatingTogetherRequest request){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        EatingTogether eatingTogether = new EatingTogether(request);
        eatingTogether.setUserId(userId);
        eatingTogetherRepository.save(eatingTogether);
        EatingParty eatingParty = new EatingParty();
        eatingParty.setEatingTogether(eatingTogether);
        eatingParty.setUserId(userId);
        eatingPartyRepository.save(eatingParty);
        return "등록에 성공하였습니다.";
    }

    public List<EatingTogetherResponse> getPost(Long bootcampId){
        List<EatingTogether> postList = eatingTogetherRepository.findByBootcampId(bootcampId);
        List<EatingTogetherResponse> responses = postList.stream().map(el->{
            Integer size = el.getEatingParty().size();
            String userName = userServiceClient.getUserById(el.getUserId()).getUserName();
            return new EatingTogetherResponse(el, userName, el.getRestaurantInfo(), size);
        }).toList();
        return responses;
    }

    public String participate(EatingPartyRequest request) throws ParticipateException {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        Optional<EatingParty> party = eatingPartyRepository.findByUserId(userId);
        if(party.isEmpty()){
            EatingParty eatingParty = new EatingParty(request);
            eatingParty.setUserId(userId);
            eatingPartyRepository.save(eatingParty);
        return "등록이 완료되었습니다.";
        }
        throw new ParticipateException();
    }
}

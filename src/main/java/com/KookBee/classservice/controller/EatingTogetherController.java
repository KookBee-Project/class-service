package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.request.EatingTogetherRequest;
import com.KookBee.classservice.domain.request.EatingPartyRequest;
import com.KookBee.classservice.domain.request.PostRestaurantInfoRequest;
import com.KookBee.classservice.domain.response.EatingTogetherResponse;
import com.KookBee.classservice.domain.response.RestaurantResponse;
import com.KookBee.classservice.exception.RestaurantCheckException;
import com.KookBee.classservice.service.EatingTogetherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/class/eatingtogether")
public class EatingTogetherController {
    private final EatingTogetherService eatingTogetherService;

    @PostMapping("/postrestaurant")
    public String postRestaurant(@RequestBody PostRestaurantInfoRequest request) throws RestaurantCheckException {
        return eatingTogetherService.postRestaurant(request);
    }

    @GetMapping("/getrestaurant")
    public List<RestaurantResponse> getRestaurant(){
        return eatingTogetherService.getRestaurant();
    }

    @PostMapping
    public String postWrite(@RequestBody EatingTogetherRequest request){
        System.out.println(request);
        return eatingTogetherService.postWrite(request);
    }

    @GetMapping("/{bootcampId}")
    public List<EatingTogetherResponse> getPost(@PathVariable Long bootcampId){
        return eatingTogetherService.getPost(bootcampId);
    }

    @PostMapping("/participate")
    public String participate(@RequestBody EatingPartyRequest request){
        return eatingTogetherService.participate(request);
    }
}

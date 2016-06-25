package com.raymond.mongo;

import com.raymond.mongo.dto.RestaurantDto;
import com.raymond.mongo.entity.Restaurant;
import com.raymond.mongo.repository.RestaurantRepository;
import com.raymond.mongo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Raymond Kwong on 6/24/2016.
 */
@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping("/mongo")
    public @ResponseBody List<RestaurantDto> mongo() {
        List<RestaurantDto> restaurantList = restaurantService.findByBorough("Queens2");
        return restaurantList;
    }
}

package com.raymond.mongo;

import com.raymond.mongo.entity.Restaurant;
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

    /*@Autowired
    private RestaurantService restaurantService;

    @RequestMapping("/findUsingMatchOperation")
    public @ResponseBody List<Restaurant> findUsingMatchOperation() {
        List<Restaurant> addresses = restaurantService.findUsingMatchOperation();
        return addresses;
    }

    @RequestMapping("/findUsingAggregationOperation")
    public @ResponseBody List<Restaurant> findUsingAggregationOperation() {
        List<Restaurant> addresses = restaurantService.findUsingAggregationOperation();
        return addresses;
    }*/
}

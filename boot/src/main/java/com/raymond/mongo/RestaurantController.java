package com.raymond.mongo;

import com.raymond.mongo.dto.RestaurantDto;
import com.raymond.mongo.entity.Address;
import com.raymond.mongo.entity.Restaurant;
import com.raymond.mongo.repository.RestaurantRepository;
import com.raymond.mongo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raymond Kwong on 6/24/2016.
 */
@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @RequestMapping("/mongo")
    public @ResponseBody Restaurant mongo() {
        Address address = new Address();
        address.setBuilding("97-22");
        List<String> coor = new ArrayList<>();
        coor.add("-73.8601152");
        coor.add("40.7311739");
        address.setCoord(coor);
        address.setStreet("63 Road");
        address.setZipcode("11374");
        Restaurant restaurant = restaurantRepository.findByAddress(address);
        return restaurant;
    }

    @RequestMapping("/findByBorough")
    public @ResponseBody List<RestaurantDto> findByBorough() {
        List<RestaurantDto> restaurant = restaurantService.findByBorough("Brooklyn");
        return restaurant;
    }

    @RequestMapping("/findByAddressStreet")
    public @ResponseBody List<Restaurant> findByAddressStreet() {
        List<Restaurant> restaurant = restaurantRepository.findByAddressStreet("63 Road", "Brooklyn");
        return restaurant;
    }

    @RequestMapping("/findByBoroughReturnAddress")
    public @ResponseBody List<Restaurant> findByBoroughReturnAddress() {
        List<Restaurant> addresses = restaurantRepository.findByBoroughReturnAddress("Brooklyn");
        return addresses;
    }

    @RequestMapping("/findUsingMatchOperation")
    public @ResponseBody List<Restaurant> findUsingMatchOperation() {
        List<Restaurant> addresses = restaurantService.findUsingMatchOperation();
        return addresses;
    }

    @RequestMapping("/findUsingAggregationOperation")
    public @ResponseBody List<Restaurant> findUsingAggregationOperation() {
        List<Restaurant> addresses = restaurantService.findUsingAggregationOperation();
        return addresses;
    }
}

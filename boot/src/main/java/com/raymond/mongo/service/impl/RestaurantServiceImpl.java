package com.raymond.mongo.service.impl;

import com.raymond.mongo.dto.RestaurantDto;
import com.raymond.mongo.entity.Restaurant;
import com.raymond.mongo.mapstruct.RestaurantMapstruct;
import com.raymond.mongo.repository.RestaurantRepository;
import com.raymond.mongo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Raymond Kwong on 6/24/2016.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantMapstruct restaurantMapstruct;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantDto> findByBorough(String borough) {
        List<Restaurant> restaurantDtoList = restaurantRepository.findByBorough(borough);
        return restaurantMapstruct.restaurantsToDtos(restaurantDtoList);
    }

    @Override
    public List<RestaurantDto> findByCuisine(String cuisine) {
        List<Restaurant> restaurantDtoList = restaurantRepository.findByCuisine(cuisine);
        return restaurantMapstruct.restaurantsToDtos(restaurantDtoList);
    }

    @Override
    public List<RestaurantDto> findAll() {
        List<Restaurant> restaurantDtoList = restaurantRepository.findAll();
        return restaurantMapstruct.restaurantsToDtos(restaurantDtoList);
    }
}

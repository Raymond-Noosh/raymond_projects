package com.raymond.mongo.service;

import com.raymond.mongo.dto.RestaurantDto;
import com.raymond.mongo.entity.Restaurant;

import java.util.List;

/**
 * Created by Raymond Kwong on 6/24/2016.
 */
public interface RestaurantService {
    public List<RestaurantDto> findByBorough(String borough);

    public List<RestaurantDto> findByCuisine(String cuisine);

    List<RestaurantDto> findAll();
}

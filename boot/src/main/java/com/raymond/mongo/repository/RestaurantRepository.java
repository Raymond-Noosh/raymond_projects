package com.raymond.mongo.repository;

import com.raymond.mongo.entity.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Raymond Kwong on 6/24/2016.
 */
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

    public List<Restaurant> findByBorough(String borough);

    public List<Restaurant> findByCuisine(String cuisine);

    List<Restaurant> findAll();
}

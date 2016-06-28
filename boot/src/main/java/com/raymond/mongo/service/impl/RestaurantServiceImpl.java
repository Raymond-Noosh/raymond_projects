package com.raymond.mongo.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.raymond.mongo.dto.RestaurantDto;
import com.raymond.mongo.entity.Restaurant;
import com.raymond.mongo.mapstruct.RestaurantMapstruct;
import com.raymond.mongo.repository.RestaurantRepository;
import com.raymond.mongo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    @Autowired
    private MongoTemplate mongoTemplate;

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

    public List<Restaurant> findUsingMatchOperation() {
        BasicQuery query = new BasicQuery("{'address.building':'97-22'}");
        List<Restaurant> restaurants = mongoTemplate.find(query, Restaurant.class);
        return restaurants;
    }

    public List<Restaurant> findUsingAggregationOperation() {
        AggregationOperation matchOperation = new MatchOperation(Criteria.where("borough").is("Queens"));
        AggregationResults aggregationResults = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), "restaurants", Restaurant.class);
        List<Restaurant> restaurants = aggregationResults.getMappedResults();
        return restaurants;
    }
}

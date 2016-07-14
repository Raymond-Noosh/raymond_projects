package com.raymond.mongo.service.impl;

import com.raymond.mongo.dto.RestaurantDto;
import com.raymond.mongo.entity.Restaurant;
import com.raymond.mongo.mapstruct.RestaurantMapstruct;
import com.raymond.mongo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.MongoRegexCreator;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Raymond Kwong on 6/24/2016.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantMapstruct restaurantMapstruct;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Restaurant> findUsingMatchOperation() {
        BasicQuery query = new BasicQuery("{'address.building':'97-22'}");
        List<Restaurant> restaurants = mongoTemplate.find(query, Restaurant.class);
        return restaurants;
    }

    public List<Restaurant> findUsingAggregationOperation() {
        AggregationOperation matchOperation = new MatchOperation(Criteria.where("borough").is("Queens"));
        AggregationResults aggregationResults = mongoTemplate.aggregate(Aggregation.newAggregation(matchOperation), "restaurants", RestaurantDto.class);
        List<Restaurant> restaurants = aggregationResults.getMappedResults();
        return restaurants;
    }

    public List<Restaurant> findWithProjection() {
        //String regexExpression = MongoRegexCreator.INSTANCE.toRegularExpression("Q", Part.Type.STARTING_WITH);
        //AggregationOperation matchOperation = new MatchOperation(Criteria.where("borough").regex(regexExpression));

        AggregationOperation projectionOperation = new ProjectionOperation(Fields.fields().and("borough", "borough")
                .and("cuisine", "cuisine").and("name", "name").and("address","address").and("restaurant_id", "restaurant_id"));
        List<AggregationOperation> aggregations = new LinkedList<>();
        aggregations.add(projectionOperation);

        AggregationResults aggregationResults = mongoTemplate.aggregate(Aggregation.newAggregation(aggregations), "restaurants", RestaurantDto.class);
        List<Restaurant> restaurants = aggregationResults.getMappedResults();
        return restaurants;
    }

    public List<Restaurant> findWithMatchRegex() {
        String regexExpression = MongoRegexCreator.INSTANCE.toRegularExpression("Q", Part.Type.STARTING_WITH);
        AggregationOperation matchOperation = new MatchOperation(Criteria.where("borough").regex(regexExpression));

        AggregationOperation projectionOperation = new ProjectionOperation(Fields.fields().and("borough", "borough")
                .and("cuisine", "cuisine").and("name", "name").and("address","address").and("restaurant_id", "restaurant_id"));
        List<AggregationOperation> aggregations = new LinkedList<>();
        aggregations.add(projectionOperation);

        AggregationResults aggregationResults = mongoTemplate.aggregate(Aggregation.newAggregation(aggregations), "restaurants", RestaurantDto.class);
        List<Restaurant> restaurants = aggregationResults.getMappedResults();
        return restaurants;
    }
}

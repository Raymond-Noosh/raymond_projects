package com.raymond.mongo.repository;

import com.raymond.mongo.entity.Address;
import com.raymond.mongo.entity.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Raymond Kwong on 6/24/2016.
 */
public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, String> {

    @Query(value="{ 'borough' : ?0 }", fields="{ 'borough' : 1, 'cuisine' : 1}")
    public List<Restaurant> findByBorough(String borough);

    public List<Restaurant> findByCuisine(String cuisine);

    List<Restaurant> findAll();

    public Restaurant findByAddress(Address address);

    @Query(value="{ 'address.street' : ?0, 'borough' : ?1 }")
    public List<Restaurant> findByAddressStreet(String street, String borough);

    @Query(value="{ 'borough' : ?0 }", fields="{ 'address' : 1}")
    public List<Restaurant> findByBoroughReturnAddress(String borough);
}

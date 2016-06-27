package com.raymond.mongo.mapstruct;

import com.raymond.mongo.dto.AddressDto;
import com.raymond.mongo.dto.RestaurantDto;
import com.raymond.mongo.entity.Address;
import com.raymond.mongo.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Created by Raymond Kwong on 6/25/2016.
 */
@Mapper
public interface RestaurantMapstruct {
    RestaurantDto restaurantToDto(Restaurant restaurant);

    List<RestaurantDto> restaurantsToDtos(List<Restaurant> restaurants);

    AddressDto addressToDto(Address address);

    List<AddressDto> addressToDto(List<Address> address);
}

package com.marton.vamos.MyApplication.service;

import com.marton.vamos.MyApplication.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant getRestaurantById(int id);
    Restaurant saveRestaurant(Restaurant restaurant);
    List<Restaurant> getAllRestaurants();
}

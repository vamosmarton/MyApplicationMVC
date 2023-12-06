package com.marton.vamos.MyApplication.service;

import com.marton.vamos.MyApplication.entity.Restaurant;

public interface RestaurantService {
    Restaurant getRestaurantById(int id);
    Restaurant saveRestaurant(Restaurant restaurant);
}

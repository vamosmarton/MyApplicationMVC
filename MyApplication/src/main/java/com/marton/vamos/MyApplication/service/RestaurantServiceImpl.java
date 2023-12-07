package com.marton.vamos.MyApplication.service;

import com.marton.vamos.MyApplication.entity.Restaurant;
import com.marton.vamos.MyApplication.repository.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        Optional<Restaurant> foundRestaurant = restaurantRepository.findById(id);
        if (foundRestaurant.isEmpty()) {
            throw new EntityNotFoundException("Restaurant cannot found with id: " + id);
        }
        return foundRestaurant.get();
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurantToSave) {
        return restaurantRepository.save(restaurantToSave);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }
}

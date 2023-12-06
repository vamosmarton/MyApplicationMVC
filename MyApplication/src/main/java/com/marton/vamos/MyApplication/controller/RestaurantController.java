package com.marton.vamos.MyApplication.controller;

import com.marton.vamos.MyApplication.entity.Restaurant;
import com.marton.vamos.MyApplication.service.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;
    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int id) {
        try {
            Restaurant restaurant = restaurantService.getRestaurantById(id);
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        }
        catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Restaurant> postRestaurant(@RequestBody Restaurant restaurantToSave) {
        try {
            Restaurant saveRestaurant = restaurantService.saveRestaurant(restaurantToSave);
            return new ResponseEntity<>(saveRestaurant, HttpStatus.OK);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

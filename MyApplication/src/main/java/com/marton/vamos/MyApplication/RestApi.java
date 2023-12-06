package com.marton.vamos.MyApplication;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/restaurant")
public class RestApi {
    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable int id) {
        return new Restaurant(id, "Pizza Hut", "Lombard Street");
    }

    @PostMapping
    public void postRestaurant(@RequestBody Restaurant restaurant) {
        System.out.println("Received data: " + restaurant);
    }
}

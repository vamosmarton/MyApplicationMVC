package com.marton.vamos.MyApplication.repository;


import com.marton.vamos.MyApplication.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

}

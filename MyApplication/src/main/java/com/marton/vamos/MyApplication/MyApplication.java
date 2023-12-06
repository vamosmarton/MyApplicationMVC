package com.marton.vamos.MyApplication;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class MyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}


	// Felülírom a CommandLineRunner run metódusát
	@Override
	public void run(String... args) throws Exception {

		// ArrayList<> létrehozása
		ArrayList<Restaurant> restaurantArrayList = new ArrayList<>();

		// éttermek példányosítás és hozzáadása a listához
		Restaurant restaurant1 = new Restaurant(1, "Pizza Hut", "Lombard Street");
		Restaurant restaurant2 = new Restaurant(2, "McDonald's", "U.S. Route 66");
		Restaurant restaurant3 = new Restaurant(3, "KFC", "Beale Street");

		restaurantArrayList.add(restaurant1);
		restaurantArrayList.add(restaurant2);
		restaurantArrayList.add(restaurant3);

		// GSON felhasználásával String kimenet készítése és kiírása
		Gson gson = new Gson();
		String jsonString = gson.toJson(restaurantArrayList);

		System.out.println(jsonString);
	}
}

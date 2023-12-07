package com.marton.vamos.MyApplication.view;

import com.marton.vamos.MyApplication.entity.Restaurant;
import com.marton.vamos.MyApplication.service.RestaurantService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.List;

@Route("")
@PageTitle("Restaurants main view")
public class MainView extends HorizontalLayout {
    private final RestaurantService restaurantService;

    private final Button buttonAdd = new Button("Add");
    private final TextField textFieldName = new TextField("Restaurant name:");
    private final TextField textFieldAddress = new TextField("Address:");
    private final Grid<Restaurant> grid = new Grid<>(Restaurant.class);
    private final Span label = new Span("Restaurants:");

    public MainView(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;

        addClassName("main-view");
        setSizeFull();
        grid.setColumns("id", "name", "address");
        updateGrid();
        add(createForm(), createGrid());
    }

    private VerticalLayout createForm() {
        setSizeFull();
        buttonAdd.addClickListener(event -> {
            String name = textFieldName.getValue();
            String address = textFieldAddress.getValue();

            Restaurant newRestaurant = new Restaurant();
            newRestaurant.setName(name);
            newRestaurant.setAddress(address);

            restaurantService.saveRestaurant(newRestaurant);

            updateGrid();
        });
        buttonAdd.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        buttonAdd.addClickShortcut(Key.ENTER);

        return new VerticalLayout(textFieldName, textFieldAddress, buttonAdd);
    }

    private VerticalLayout createGrid() {
        setSizeFull();
        return new VerticalLayout(label, grid);
    }

    private void updateGrid() {
        List<Restaurant> allRestaurants = restaurantService.getAllRestaurants();
        grid.setItems(allRestaurants);
    }
}

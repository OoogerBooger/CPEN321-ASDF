package com.example.andre.qfinder;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Created by py344 on 2017-11-13.
 */

public class Restaurant {
    private ArrayList<String> tags = new ArrayList<>();
    private String restaurantName;
    /*private String yelpURL;
    private boolean price;
    private boolean fastFood;
    private boolean lunch;
    private boolean dinner;
    private boolean breakfast;
    private boolean western;
    private boolean middleEastern;
    private boolean asian;
    private boolean vegetarian;
    private boolean dessert;
    private boolean spicy;
    private boolean sitDown;*/


    public Restaurant() {
        restaurantName = "";
    }

    public Restaurant(String name){
        restaurantName = name;
    }
    public String getRestaurantName() {
        return restaurantName;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void addTags(String tag){
        tags.add(tag);
    }

    public boolean isTag(String tag){
        for (int i = 0; i < tags.size(); i ++){
            if (tags.get(i) == tag);
            return TRUE;
        }
        return FALSE;
    }
    /*public boolean isPrice() {
        return price;
    }

    public boolean isFastFood() {
        return fastFood;
    }

    public boolean isLunch() {
        return lunch;
    }

    public boolean isDinner() {
        return dinner;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public boolean isWestern() {
        return western;
    }

    public boolean isMiddleEastern() {
        return middleEastern;
    }

    public boolean isAsian() {
        return asian;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public boolean isDessert() {
        return dessert;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public boolean isSitDown() {
        return sitDown;
    }*/
}

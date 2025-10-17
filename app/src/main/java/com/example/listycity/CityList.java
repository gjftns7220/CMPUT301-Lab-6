package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {

    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks if the list has the given city in the list.
     * @param city
     * @return
     * Return the boolean whether the city List has the given city or not
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }

    /**
     * This deletes a city from the city list.
     * @param city
     */
    public void delete (City city){
        if (cities.contains(city)){
            cities.remove(city);
        }
        else {throw new IllegalArgumentException();}
    }


    /**
     * This counts the number of cities in the cities list.
     * @return
     * Return the number of cities in the list.
     */
    public int countCity (){
        return cities.size();
    }
}


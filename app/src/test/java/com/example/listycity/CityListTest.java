package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }


    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
        }


    @Test
    void testHasCity(){
        CityList cityList = mockCityList();
        City yelloKnife = new City("Yellowknife", "Northwest Territories");
        cityList.add(yelloKnife);
        assertTrue(cityList.hasCity(yelloKnife));
        City bingusLand = new City("Bingus", "Land");
        assertFalse(cityList.hasCity(bingusLand));
    }

    @Test
    void testDelete(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City regina = new City("Regina", "Saskatchewan");
        cityList.add(regina);
        assertEquals(2, cityList.getCities().size());
        cityList.delete(regina);
        assertEquals(1, cityList.getCities().size());
        assertFalse(cityList.hasCity(regina));
    }

    @Test
    void testDeleteExeption(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City bingusLand = new City("Bingus", "Land");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(bingusLand);
        });
    }

    @Test
    void testCountCity(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertEquals(2, cityList.countCity());

    }


    }


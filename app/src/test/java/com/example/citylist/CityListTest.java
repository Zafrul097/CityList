package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    @Test
    public void testdelete()
    {
        CityList cityList=new CityList();
        City city1=new City("Bogura", "RR");
        cityList.add(city1);
        City city2=new City("Natore","TR");
        cityList.add(city2);

        cityList.delete(city1);
        assertTrue(!cityList.getCities(1).contains(city1));

    }

    @Test
    public void testdeleteException()
    {
        CityList cityList=new CityList();
        City city1=new City("Bogura", "RR");
        City city2=new City("Natore","TR");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });

    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }

    @Test
    public void testcount()
    {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.count());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.count());
    }

    @Test
    public void testSort()
    {

        CityList cityList=new CityList();

        City city1=new City("Regina","AB");
        cityList.add(city1);



        City city2= new City("Charlottetown", "Prince Edward Island");
        cityList.add(city2);

        assertEquals(0, city1.compareTo(cityList.getCities(1).get(1)));
        assertEquals(0, city2.compareTo(cityList.getCities(1).get(0)));

    }



}

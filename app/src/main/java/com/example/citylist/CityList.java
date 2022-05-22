package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }



    /**
     * This returns a sorted list of cities by CityName or ProvinceName
     * @param para
     * if para==1 sort by CityName else sort by ProvinceName
     *
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities(int para) {
        List<City> cityList = cities;
        if(para==1)
        {
            Collections.sort(cityList);
        }
        else
        {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }


        return cityList;
    }


    /**
     * This deletes a city to the list if that city does exist
     * @param city
     *    This is the city to delete
     *
     */

    public void delete(City city)
    {
        if(!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This returns the no of the city in the list
     *
     * @return
     *  Return the no of cities
     *
     */

    public int count()
    {
        return cities.size();

    }

}

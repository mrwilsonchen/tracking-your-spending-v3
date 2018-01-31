package com.example.ankhleu.trackingyourspendingv3.tripdata;

import java.util.ArrayList;

/**
 * Created by ankhleu on 2018/1/31.
 */

public interface tripDAO {

    public boolean add(trip_constructor t);
    public ArrayList<trip_constructor> getList();
    public trip_constructor getTrip(int id);
    public boolean update(trip_constructor t);
    public boolean delete(int id);
}

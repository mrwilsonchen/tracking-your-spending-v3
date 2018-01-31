package com.example.ankhleu.trackingyourspendingv3.tripdata;

import java.util.ArrayList;

/**
 * Created by ankhleu on 2018/1/31.
 */

public interface tripDetailDAO {
    public boolean add(tripadd_constructor t);
    public ArrayList<tripadd_constructor> getList();
    public tripadd_constructor getTrip(int id);
    public boolean update(tripadd_constructor t);
    public boolean delete(int id);
}

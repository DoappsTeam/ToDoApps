package me.doapps.todoapps.models;

import java.util.ArrayList;

/**
 * Created by william on 21/03/2015.
 */
public class Values {

    ArrayList<String> values = new ArrayList<>();

    public void addValue(String value){
        values.add(value);
    }

    public String getValue(int pos){
        return values.get(pos);
    }

    public int getCount(){
        return values.size();
    }

}

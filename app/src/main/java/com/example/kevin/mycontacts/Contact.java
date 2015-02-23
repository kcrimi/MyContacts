package com.example.kevin.mycontacts;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kevin on 2/15/15.
 */
public class Contact implements Serializable{

    private String name;
    public ArrayList<String> emails;
    public ArrayList<String> phoneNumbers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

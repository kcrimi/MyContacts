package com.example.kevin.mycontacts;

import java.util.ArrayList;

/**
 * Created by kevin on 2/21/15.
 */
public class ContactList extends ArrayList<Contact> {
    private static ContactList mInstance = null;

    private ContactList(){}

    public static ContactList getInstance() {
        if(mInstance == null){
            mInstance = new ContactList();
        }

        return mInstance;
    }
}

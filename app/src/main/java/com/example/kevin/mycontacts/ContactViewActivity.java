package com.example.kevin.mycontacts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class ContactViewActivity extends ActionBarActivity {
    private static final String TAG = "ActionBarActivity";
    public static final String EXTRA = ContactViewFragment.EXTRA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);

        if(getFragmentManager().findFragmentById(R.id.view_fragment_container) == null){
            ContactViewFragment cvf = new ContactViewFragment();
            cvf.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction()
                    .add(R.id.view_fragment_container, cvf)
                    .commit();
        }
    }
}

package com.example.kevin.mycontacts;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ContactListActivity extends ActionBarActivity {

    private ContactList mContacts;
    private ContactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        mContacts = ContactList.getInstance();

        for (int i = 0; i < 45; i++){
            String name = "Jim Yang";
            if(i % 2 ==0){
                name = "Melissa Choi";
            }
            Contact contact = new Contact();
            contact.setName(name);
            contact.emails = new ArrayList<String>();
            contact.phoneNumbers = new ArrayList<String>();
            contact.emails.add("poopaloop@gmail.com");
            contact.emails.add("nef@gmail.com");
            contact.phoneNumbers.add("1800 999 9800");
            contact.phoneNumbers.add("39428402");
            contact.phoneNumbers.add("23333");
            mContacts.add(contact);
        }

        ListView listView = (ListView)findViewById(R.id.contact_list_view);
        mAdapter = new ContactAdapter(mContacts);
        listView.setAdapter(mAdapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            int previousFirstItem = 0;
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(firstVisibleItem > previousFirstItem) {
                    getSupportActionBar().hide();
                }else if (firstVisibleItem < previousFirstItem){
                    getSupportActionBar().show();
                }
                previousFirstItem = firstVisibleItem;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ContactListActivity.this, ContactViewActivity.class);
                i.putExtra(ContactViewActivity.EXTRA, position);
                startActivity(i);
            }
        });

    }

    private class ContactAdapter extends ArrayAdapter<Contact> {
        ContactAdapter(ArrayList<Contact> contacts){
            super(ContactListActivity.this, R.layout.contact_list_row, R.id.contact_row_name, contacts);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = super.getView(position, convertView, parent);

            Contact contact = getItem(position);
            TextView nameTextView = (TextView)convertView.findViewById(R.id.contact_row_name);
            nameTextView.setText(contact.getName());
            return convertView;
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

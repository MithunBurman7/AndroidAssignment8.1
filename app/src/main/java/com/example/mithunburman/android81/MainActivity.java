package com.example.mithunburman.android81;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    // Below declaring variables

    Button ascndBtn;
    Button dscndBtn;
    ListView lstViw;

    // creating array of month's name

    String[] monthName = {"January", "Feb", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        // Here by getting the widgets reference from XML layout
        lstViw = (ListView) findViewById( R.id.listView );

        /**
         * Using ArrayAdapter because the adapter converts an ArrayList of objects into
         * View items loaded into the ListView container.
         */

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, monthName );
        lstViw.setAdapter( adapter );
        // and in here getting the widgets reference from XML layout for assigning and designing button.
        ascndBtn = (Button) findViewById(R.id.ascndBtn);
        dscndBtn = (Button) findViewById( R.id.dscndBtn );
        // setting OnClickListener for assigning oder
        ascndBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort( monthName );
                adapter.notifyDataSetChanged();
                Toast.makeText( getApplicationContext(), "Showing Ascending Oder  ", Toast.LENGTH_SHORT ).show();

            }
        } );
        // setting OnClickListener for designing oder
        dscndBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(monthName,Collections.<String>reverseOrder());
                adapter.notifyDataSetChanged();
                Toast.makeText( getApplicationContext(), "Showing Descending Oder", Toast.LENGTH_SHORT ).show();
            }
        } );

    }

}
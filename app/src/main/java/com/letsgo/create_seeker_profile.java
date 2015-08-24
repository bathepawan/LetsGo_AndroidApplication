package com.letsgo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;


public class create_seeker_profile extends ActionBarActivity  {

    private static int DATE_DIALOG_ID=0;
    private int mYear;
    private int mMonth;
    private int mDay;
    TextView txtDOJ;
    Calendar c=null;
    final String months[]= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
    private static final String[] CITIES = new String[] {
            "Pune", "Mumbai", "Aurangabad", "Buldhana", "Kolhapur","Khamgaon","Malkapur","Nagpur","Satara","Ahamadnagar"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_seeker_profile);
        txtDOJ = (TextView) findViewById(R.id.textDOJ);
        c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        txtDOJ.setText("  " +String.valueOf(mDay)+" "+months[mMonth]+" "+String.valueOf(mYear));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, CITIES);

        AutoCompleteTextView textViewFrom = (AutoCompleteTextView)
                findViewById(R.id.textFrom);
        AutoCompleteTextView textViewTo = (AutoCompleteTextView)
                findViewById(R.id.textTo);

        textViewFrom.setAdapter(adapter);
        textViewTo.setAdapter(adapter);



        txtDOJ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });


    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();


                }
            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_seeker_profile, menu);
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

    private void updateDisplay() {

        txtDOJ.setText("  " +String.valueOf(mDay)+" "+months[mMonth]+" "+String.valueOf(mYear));

    }


}

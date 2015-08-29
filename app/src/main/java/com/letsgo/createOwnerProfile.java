package com.letsgo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Calendar;


public class createOwnerProfile extends ActionBarActivity implements View.OnClickListener {

    private static int DATE_DIALOG_ID=0;
    private SeekBar budget;
    private int global_progress;
    TextView txtDOJ,budget_amt;
    private int mYear;
    private int mMonth;
    private int mDay;
    private Button save,cancel;
    Calendar c=null;
    final String months[]= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
    private static final String[] CITIES = new String[] {
            "Pune", "Mumbai", "Aurangabad", "Buldhana", "Kolhapur","Khamgaon","Malkapur","Nagpur","Satara","Ahamadnagar"
    };
    private static final String[] RTO = new String[] {
        "MH-1","MH-2","MH-3","MH-4","MH-5","MH-6","MH-7","MH-8","MH9","MH-10",
            "MH-11","MH-12","MH-13","MH-14","MH-15","MH-16","MH-17","MH-18","MH19","MH-20",
            "MH-21","MH-22","MH-23","MH-24","MH-25","MH-26","MH-27","MH-28","MH29","MH-30",
            "MH-31","MH-32","MH-33","MH-34","MH-35","MH-36","MH-37","MH-38","MH39","MH-40",
            "MH-41","MH-42","MH-43","MH-44","MH-45","MH-46","MH-47","MH-48","MH49","MH-50",
            "MH-51","MH-52","MH-53","MH-54"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_owner_profile);

        budget=(SeekBar)findViewById(R.id.budget_seekbar);
        budget_amt=(TextView)findViewById(R.id.budget);
        txtDOJ=(TextView)findViewById(R.id.textDOJ);
        save=(Button)findViewById(R.id.save);
        cancel=(Button)findViewById(R.id.cancel);

        c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        AutoCompleteTextView textViewRTO = (AutoCompleteTextView)
                findViewById(R.id.rto);
        AutoCompleteTextView textViewFrom = (AutoCompleteTextView)
                findViewById(R.id.textFrom);
        AutoCompleteTextView textViewTo = (AutoCompleteTextView)
                findViewById(R.id.textTo);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,RTO);

        ArrayAdapter<String> adapter_cities = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, CITIES);


        textViewRTO.setAdapter(adapter);
        textViewFrom.setAdapter(adapter_cities);
        textViewTo.setAdapter(adapter_cities);

        save.setOnClickListener(this);
        cancel.setOnClickListener(this);

        txtDOJ.setText("  " + String.valueOf(mDay) + " " + months[mMonth]+" "+String.valueOf(mYear));

        try {

            budget.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                public void onStopTrackingTouch(SeekBar seekBar) {
                    //Logic
                }

                public void onStartTrackingTouch(SeekBar arg0) {
                    //Logic
                }


                public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
                    budget_amt.setText(String.valueOf(progress));
                    Log.d("DEBUG", "Progress is: " + progress);
//                    updateDisplay();
                }
            });
        }catch (Exception e)
        {
            budget_amt.setText("NULL");
            e.printStackTrace();
            System.out.println("EXCEPTION");
        }

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
        getMenuInflater().inflate(R.menu.menu_create_owner_profile, menu);
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

        txtDOJ.setText("  " + String.valueOf(mDay) + " " + months[mMonth] + " " + String.valueOf(mYear));

    }
    private void updateBudget() {
        budget_amt.setText(global_progress);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.save){
            Intent master=new Intent(this,master_activity.class);
            startActivity(master);
        }
        if(v.getId()==R.id.cancel){
            Intent master=new Intent(this,master_activity.class);
            startActivity(master);
        }
    }
}

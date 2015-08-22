package com.letsgo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class CreateProfile extends ActionBarActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        final Button btnSeeker = (Button)findViewById(R.id.seeker);
        final Button btnOwner = (Button)findViewById(R.id.owner);
        final Button btnAgency = (Button) findViewById(R.id.agency);

        btnSeeker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent= new Intent(CreateProfile.this,Signup.class);
                String Message= " Planning to travel.";
                signupIntent.putExtra("Message",Message);
                startActivity(signupIntent);
            }
        });

        btnOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent= new Intent(CreateProfile.this,Signup.class);
                String Message= " Looking for travel mate.";
                signupIntent.putExtra("Message",Message);
                startActivity(signupIntent);
            }
        });

        btnAgency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent= new Intent(CreateProfile.this,Signup.class);
                String Message= "Looking for passengers. ";
                signupIntent.putExtra("Message",Message);
                startActivity(signupIntent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_profile, menu);
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

package com.billassociates.mtrack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import edu.cuny.ccny.csc221.finalproject.R;

public class MainActivityOld extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_old);
    }


    public void addMetroCardBtnClick(View v)
    {
        Context c = getApplicationContext();
        CharSequence text = "Hi I pressed the button.";
        int duration = Toast.LENGTH_SHORT;

        Toast t = Toast.makeText(c,text,duration);

        t.show();
        goToEditActivity(v);
    }

    public void goToEditActivity(View view) {
        Intent intent = new Intent(this, MetrocardEditActivity.class);
        startActivity(intent);
    }
}
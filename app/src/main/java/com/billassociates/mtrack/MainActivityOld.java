package com.billassociates.mtrack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

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



        // Toast Test
        CharSequence text = "Hi I pressed the button.";
        int duration = Toast.LENGTH_SHORT;

        Toast t = Toast.makeText(c,text,duration);

        t.show();


        // Populate ListView Test
        ListView lv = (ListView) findViewById(R.id.McardList);
        MetroCardController mc = new MetroCardController();
        mc.ReadToArrayList(c);
        ArrayList<MetrocardData> arrayList = mc.getArrayList();
        arrayList.add(new MetrocardData("Test",232));
        ArrayAdapter<MetrocardData> arrayAdapter = new ArrayAdapter<MetrocardData>
                (this, android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(arrayAdapter);


        goToEditActivity(v);
    }

    public void populateList()
    {

    }

    public void goToEditActivity(View view) {
        Intent intent = new Intent(this, MetrocardEditActivity.class);
        startActivity(intent);
    }

    public void goToViewActivity(View view) {
        Intent intent = new Intent(this, MetrocardCalculateActivity.class);
        startActivity(intent);
    }
}
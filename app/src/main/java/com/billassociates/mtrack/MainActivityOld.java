package com.billassociates.mtrack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import edu.cuny.ccny.csc221.finalproject.R;

public class MainActivityOld extends Activity {

    private static MetroCardController mcontroller = new MetroCardController();
    ArrayList<MetrocardData> arrayList = new ArrayList<>();
    ArrayAdapter<MetrocardData> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_old);
        try
        {
            updatearraylist(mcontroller);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void updatearraylist(MetroCardController mcontroller) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        mcontroller.ReadToArrayList(getApplicationContext());
        arrayList = mcontroller.getArrayList();
        arrayAdapter = new ArrayAdapter<MetrocardData>(this, android.R.layout.simple_list_item_1, arrayList);
        ListView lstView = (ListView) findViewById(R.id.McardList);
        lstView.setAdapter(arrayAdapter);
    }


    public void addMetroCardBtnClick(View v)
    {
        Context c = getApplicationContext();



        // Toast Test
        CharSequence text = "Hi I pressed the button.";
        int duration = Toast.LENGTH_SHORT;

        Toast t = Toast.makeText(c,text,duration);

        t.show();

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
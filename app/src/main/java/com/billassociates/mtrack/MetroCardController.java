package com.billassociates.mtrack;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MetroCardController {
    static private ArrayList<MetrocardData> arrayList = new ArrayList<>();
    static private MetrocardData current_mcard_ptr;

    //public statistics
    public static final int FARE = 275;


    public ArrayList<MetrocardData> getArrayList() {
        return arrayList;
    }

    public void ReadToArrayList(Context c) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        try
        {
            FileInputStream fis = c.openFileInput("metrocard.bin");
            ObjectInputStream os = new ObjectInputStream(fis);
            arrayList = (ArrayList<MetrocardData>) os.readObject();

        }
        catch (Exception e)
        {
            String errormsg = "uh oh.";
            System.err.println(errormsg);
            Toast t = Toast.makeText(c,errormsg,Toast.LENGTH_SHORT);
            t.show();
            e.printStackTrace();
            throw e;
        }


    }

    public void SaveFromArrayList(Context c) throws IOException
    {
        FileOutputStream fos = c.openFileOutput("metrocard.bin", Context.MODE_PRIVATE);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(arrayList);
        os.close();
    }



}

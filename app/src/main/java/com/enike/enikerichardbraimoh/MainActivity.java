package com.enike.enikerichardbraimoh;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class MainActivity extends AppCompatActivity  {

    Spinner datefrom,dateto,gender,country,color;
    Button filter;
    Workbook workbook;
    List<String> first_name,last_name,email,acountry,car_model,car_model_year,car_color,agender,job_title,bio;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datefrom = findViewById(R.id.daterangefrom);
        dateto = findViewById(R.id.daterangeto);
        gender = findViewById(R.id.gender);
        country = findViewById(R.id.country);
        color = findViewById(R.id.color);
        filter = findViewById(R.id.filter);

        // define the arrays
        first_name = new ArrayList<>();
        last_name = new ArrayList<>();
        email = new ArrayList<>();
        acountry = new ArrayList<>();
        car_model = new ArrayList<>();
        car_model_year = new ArrayList<>();
        car_color = new ArrayList<>();
        agender = new ArrayList<>();
        job_title = new ArrayList<>();
        bio = new ArrayList<>();



        // date from
        ArrayAdapter<CharSequence> AdapterMain = ArrayAdapter.createFromResource(this,R.array.rang_from,android.R.layout.simple_spinner_item);
        AdapterMain.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        datefrom.setAdapter(AdapterMain);

        // date to
       ArrayAdapter<CharSequence> AdapterMain2 = ArrayAdapter.createFromResource(this,R.array.rang_to,android.R.layout.simple_spinner_item);
      AdapterMain2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dateto.setAdapter(AdapterMain2);

        // for gender
        ArrayAdapter<CharSequence> Adaptegender = ArrayAdapter.createFromResource(this,R.array.gender,android.R.layout.simple_spinner_item);
        Adaptegender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(Adaptegender);

        // for country
        ArrayAdapter<CharSequence> Adaptercountry = ArrayAdapter.createFromResource(this,R.array.country,android.R.layout.simple_spinner_item);
        Adaptercountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(Adaptercountry);

        // for color
        ArrayAdapter<CharSequence> Adaptercolor = ArrayAdapter.createFromResource(this,R.array.color,android.R.layout.simple_spinner_item);
        Adaptercolor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color.setAdapter(Adaptercolor);



        datefrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("Bitcoin", "Nothing selected");
            }
        });

        dateto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });



        /////////////////////

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File("/storage/emulated/0/ehealth/car_ownsers_data.csv");
                file.mkdirs();


                if(!file.exists()){
                    Toast.makeText(MainActivity.this, "file not found", Toast.LENGTH_SHORT).show();
                }
                else{
                  //  Toast.makeText(MainActivity.this, "yaay i found the file", Toast.LENGTH_SHORT).show();

                    WorkbookSettings ws = new WorkbookSettings();
                    ws.setGCDisabled(true);
                    if(file!= null){

                        try {
                            workbook = workbook.getWorkbook(file);

                           Sheet sheet = workbook.getSheet(0);

                           for (int i= 0; i < sheet.getRows(); i++){

                               Cell[] row = sheet.getRow(i);
                               first_name.add(row[0].getContents());
                               last_name.add(row[1].getContents());
                               email.add(row[2].getContents());
                               acountry.add(row[3].getContents());


                           }




                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (BiffException e) {
                            e.printStackTrace();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "file is empty", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });



    }

}
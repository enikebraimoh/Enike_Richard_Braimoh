package com.enike.enikerichardbraimoh;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    int Requestcode = 1234;
    int Requestcode2 = 12345;

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
                String path = "/storage/emulated/0/ehealth/car_ownsers_data.csv";
                String line;

                try {
                    BufferedReader br = new BufferedReader(new FileReader(path));
                    while ((line = br.readLine()) != null){

                        Log.d("ehealth", line);

                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //   int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, Requestcode);

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Requestcode) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("ehealth", "permission Granted");
            }
        }
    }

}
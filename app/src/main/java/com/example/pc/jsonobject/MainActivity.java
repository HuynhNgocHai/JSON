package com.example.pc.jsonobject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnObj , btnArr, btnLang, btnArrObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnObj = findViewById(R.id.btnObj);
        btnArr = findViewById(R.id.btnArr);
        btnLang = findViewById(R.id.btnLang);
        btnArrObj = findViewById(R.id.btnArrObj);

        btnObj.setOnClickListener(this);
        btnArr.setOnClickListener(this);
        btnLang.setOnClickListener(this);
        btnArrObj.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnObj:
                Intent i = new Intent(this, JSONObjectActivity.class);
                startActivity(i);
                break;
            case R.id.btnArr:
                Intent i2 = new Intent(this, JSONArrayActivity.class);
                startActivity(i2);
                break;
            case R.id.btnLang:
                Intent i3 = new Intent(this, JSONObjectLanguageActivity.class);
                startActivity(i3);
                break;
            case R.id.btnArrObj:
                Intent i4 = new Intent(this, JSONArrayObjectActivity.class);
                startActivity(i4);
                break;
        }
    }
}

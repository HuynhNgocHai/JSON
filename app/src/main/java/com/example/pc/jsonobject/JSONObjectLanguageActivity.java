package com.example.pc.jsonobject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONObjectLanguageActivity extends AppCompatActivity {

    ImageButton imgVn, imgEng;
    TextView tvInfo;

    String noiDung = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonobject_language);

        AnhXa();

        new ReadJSON().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");

        imgVn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadJSONLanguage("vn");
            }
        });
        imgEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadJSONLanguage("en");
            }
        });
    }

    private class ReadJSON extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {

            StringBuilder content = new StringBuilder();

            try {
                URL url = new URL(strings[0]);

                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";

                while ((line = bufferedReader.readLine()) != null){
                    content.append(line);
                }
                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
                noiDung = s;

                ReadJSONLanguage("vn");
        }
    }

    private void ReadJSONLanguage(String lang){
        try {
            JSONObject object = new JSONObject(noiDung);

            JSONObject objectLang = object.getJSONObject("language");

            JSONObject objectVn = objectLang.getJSONObject(lang);

            String name = objectVn.getString("name");
            String address = objectVn.getString("address");
            String course1 = objectVn.getString("course1");
            String course2 = objectVn.getString("course2");
            String course3 = objectVn.getString("course3");

            tvInfo.setText(name + "\n" + address + "\n" + course1 + "\n" + course2 + "\n" + course3);
//                Toast.makeText(JSONObjectLanguageActivity.this, name + "\n" + address + "\n" + course1 + "\n" + course2 + "\n" + course3, Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void AnhXa(){
        imgVn = findViewById(R.id.imgVn);
        imgEng = findViewById(R.id.imgEng);
        tvInfo = findViewById(R.id.tvInfo);
    }
}

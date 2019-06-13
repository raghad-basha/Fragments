package com.example.asus.application1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void buGetAge(View view) {
        EditText etAge = this.<EditText>findViewById(R.id.etAge);
     int year= Integer.parseInt(   etAge.getText().toString());
     int age = 2019-year;
        Toast.makeText(this,"age:"+ String.valueOf(age),Toast.LENGTH_LONG);
    }
}

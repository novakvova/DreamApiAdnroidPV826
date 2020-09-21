package com.example.dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.e("Semen","----Hello Peter-----");
        //Log.d("slava", "------dispaly----");
        setContentView(R.layout.activity_main);
    }

    public void btnClickPlus(View v)
    {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Нажатий плюс", Toast.LENGTH_LONG);
        toast.show();
    }
}
package com.example.dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.toolbox.NetworkImageView;
import com.example.dream.network.ImageRequester;

public class LoginActivity extends AppCompatActivity {

    private ImageRequester imageRequester;
    private NetworkImageView iconLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        imageRequester = ImageRequester.getInstance();
        iconLogin = findViewById(R.id.iconLogin);
        imageRequester.setImageFromUrl(iconLogin,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQR1oM0O7QSosPaYIodLtSoz6AuIYOOmxNGJw&usqp=CAU");
    }
}
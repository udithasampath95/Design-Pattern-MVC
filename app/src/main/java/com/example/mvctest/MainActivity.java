package com.example.mvctest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mvctest.model.UserResponse;
import com.example.mvctest.network.APIService;
import com.example.mvctest.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Observer {
    private static final String TAG = "MainActivity ";
    private Button Button1, Button2, Button3;
    private int pageNumber = 0;
    private UserResponse userResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();
        userResponse=new UserResponse();
        userResponse.addObserver(this);
    }

    private void setListeners() {
        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);
        Button3.setOnClickListener(this);
    }

    private void initViews() {
        Button1 = findViewById(R.id.button);
        Button2 = findViewById(R.id.button2);
        Button3 = findViewById(R.id.button3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                userResponse.setValueAtIndex(0);
                break;
            case R.id.button2:
                userResponse.setValueAtIndex(1);
                break;
            case R.id.button3:
                userResponse.setValueAtIndex(2);
                break;
        }
    }

    @Override
    public void update(Observable observable, Object o) {
        Button1.setText("Count: "+userResponse.getValueAtIndex(0));
        Button2.setText("Count: "+userResponse.getValueAtIndex(1));
        Button3.setText("Count: "+userResponse.getValueAtIndex(2));
    }
}
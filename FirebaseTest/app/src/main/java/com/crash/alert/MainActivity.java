package com.crash.alert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;


public class MainActivity extends AppCompatActivity {
   Firebase base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        base = new Firebase("https://crash-beacon.firebaseio.com");
    }
    public void send(View view){
        base.setValue("Hello data");
    }
}

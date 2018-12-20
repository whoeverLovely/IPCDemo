package com.example.liyan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.liyan.myapplication.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, MyService.class));
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}

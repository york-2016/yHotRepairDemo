package com.york.rexiufu.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.york.rexiufu.R;
import com.york.rexiufu.rexiufu.BugClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void check(View view) {
        new BugClass(MainActivity.this);
    }
}

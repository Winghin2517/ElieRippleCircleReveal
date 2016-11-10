package com.example.beloo.circlerectbitmapanimator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.beloo.circlerectbitmapanimator.view.CircleRectView;

public class MainActivity extends AppCompatActivity {

    CircleRectView view;
    View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (CircleRectView) findViewById(R.id.circleView);

        view.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, view, getString(R.string.circle));
            ActivityCompat.startActivity(MainActivity.this, intent , transitionActivityOptions.toBundle());
        });

        view.setTag("FIRST");

        root = findViewById(R.id.root);
    }
}

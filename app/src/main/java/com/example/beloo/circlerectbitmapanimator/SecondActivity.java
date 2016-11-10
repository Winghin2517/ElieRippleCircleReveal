package com.example.beloo.circlerectbitmapanimator;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.example.beloo.circlerectbitmapanimator.support.CircleToRectTransition;
import com.example.beloo.circlerectbitmapanimator.view.CircleRectView;

public class SecondActivity extends AppCompatActivity {

    CircleRectView view;
    View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            CircleToRectTransition circleToRectTransition = new CircleToRectTransition();
            getWindow().setSharedElementEnterTransition(circleToRectTransition
                            .setInterpolator(new AccelerateDecelerateInterpolator())
                            .setDuration(600));
/*            getWindow().setSharedElementExitTransition(new CircleToRectTransition().setDuration(1500));*/
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        view = (CircleRectView) findViewById(R.id.circleView);
        root = findViewById(R.id.root);
        view.setTag("SECOND");

    }

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
//        overridePendingTransition(0, 0);
    }
}

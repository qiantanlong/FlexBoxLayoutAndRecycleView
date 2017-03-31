package com.hongzhen.flexboxlayoutandrecycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.hongzhen.flexboxlayoutandrecycleview.activity.ActivityFlexBoxLayoutSimple;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FlexboxLayout mFlexboxLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_simple_flexboxlayout).setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_simple_flexboxlayout:
                //FlexBoxLayout布局的简单使用
                startActivity(new Intent(MainActivity.this, ActivityFlexBoxLayoutSimple.class));
                break;
        }
    }
}

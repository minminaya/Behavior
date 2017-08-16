package com.minminaya.coordinatebehavior;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                openActivity1(CoordinateToolBar1Activity.class);
                break;
            case R.id.btn2:
                openActivity1(CoordinateToolBar2Activity.class);
                break;
            case R.id.btn3:
                openActivity1(CoordinateToolBar3Activity.class);
                break;
            case R.id.btn4:
                openActivity1(CoordinateToolBar4Activity.class);
                break;
        }
    }

    public void openActivity1(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}

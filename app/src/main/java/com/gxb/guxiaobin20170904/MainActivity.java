package com.gxb.guxiaobin20170904;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyView myView = (MyView) findViewById(R.id.myview);
        myView.setOnclick(new MyView.Onclick() {
            @Override
            public void setColor(View view) {
                Toast.makeText(MainActivity.this, "za", Toast.LENGTH_SHORT).show();
            }
        }, R.color.colorAccent);
    }
}

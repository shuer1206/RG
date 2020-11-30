package com.example.wy.r.leftmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wy.r.R;

public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        TextView textView = (TextView)findViewById(R.id.textview_in_aboutus);
        String aboutme = new String("西南民族大学\n计算机科学与工程学院\n软件工程1801班\n焦少康、肖凯文、罗薇、关姝");
        textView.setText(aboutme);
    }
}

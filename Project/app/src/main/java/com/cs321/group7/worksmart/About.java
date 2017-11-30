package com.cs321.group7.worksmart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class About extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        final TextView title = (TextView) findViewById(R.id.textView5);
        final TextView title2 = (TextView) findViewById(R.id.textView11);

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("WorjSmart - A Digital Student Agenda");
            }
        });

        title2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title2.setText("FLORJIN BLORJIN SMORJ");
            }
        });
    }
}

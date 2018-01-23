package com.farizdotid.tutorialfarizdotid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.farizdotid.tutorialfarizdotid.datepicker.DatePickerActivity;
import com.farizdotid.tutorialfarizdotid.daterangepicker.DateRangePickerActivity;
import com.farizdotid.tutorialfarizdotid.emailvalidation.EmailValidationActivity;
import com.farizdotid.tutorialfarizdotid.imagecircle.ImageCircleActivity;
import com.farizdotid.tutorialfarizdotid.radiobutton.RadioButtonExample;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnActRadio)
    Button btnActRadio;
    @BindView(R.id.btnActDatePicker)
    Button btnActDatePicker;
    @BindView(R.id.btnActEmailValidation)
    Button btnActEmailValidation;
    @BindView(R.id.btnActImageCircle)
    Button btnActImageCircle;
    @BindView(R.id.btnActDateRangePicker)
    Button btnActDateRangePicker;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        unbinder = ButterKnife.bind(this);

        btnActRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RadioButtonExample.class));
            }
        });

        btnActDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DatePickerActivity.class));
            }
        });

        btnActEmailValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EmailValidationActivity.class));
            }
        });

        btnActImageCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ImageCircleActivity.class));
            }
        });

        btnActDateRangePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DateRangePickerActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
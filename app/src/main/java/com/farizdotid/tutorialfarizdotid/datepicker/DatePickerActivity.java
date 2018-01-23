package com.farizdotid.tutorialfarizdotid.datepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.farizdotid.tutorialfarizdotid.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DatePickerActivity extends AppCompatActivity {

    @BindView(R.id.btnOpenDatePicker)
    Button btnOpenDatePicker;
    @BindView(R.id.tvTanggal)
    TextView tvTanggal;

    Calendar myCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        ButterKnife.bind(this);
        myCalendar = Calendar.getInstance();

        btnOpenDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DatePickerActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, month);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String formatTanggal = "dd-MM-yyyy";
                        SimpleDateFormat sdf = new SimpleDateFormat(formatTanggal);
                        tvTanggal.setText("Kamu memilih tanggal : " + sdf.format(myCalendar.getTime()));
                    }
                },
                        myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
}
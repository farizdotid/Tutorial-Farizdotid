package com.farizdotid.tutorialfarizdotid.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.farizdotid.tutorialfarizdotid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RadioButtonExample extends AppCompatActivity {

    @BindView(R.id.rgJawaban1)
    RadioGroup rgJawaban1;
    @BindView(R.id.rbJawaTimur)
    RadioButton rbJawaTimur;
    @BindView(R.id.rbJawaBarat)
    RadioButton rbJawaBarat;
    @BindView(R.id.rbJawaTengah)
    RadioButton rbJawaTengah;
    @BindView(R.id.btnJawab)
    Button btnJawab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_example);
        getSupportActionBar().setTitle("Radio Button Example");

        ButterKnife.bind(this);

        btnJawab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rgJawaban1.getCheckedRadioButtonId();

                if (selectedId == rbJawaTimur.getId()){
                    showToast("Jawaban Kamu : " + rbJawaTimur.getText().toString());
                } else if (selectedId == rbJawaBarat.getId()){
                   showToast("Jawaban Kamu : " + rbJawaBarat.getText().toString());
                } else if (selectedId == rbJawaTengah.getId()){
                    showToast("Jawaban Kamu : " + rbJawaTengah.getText().toString());
                } else {
                    showToast("Kamu Belum Memilih Jawaban");
                }
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(this, "" + message, Toast.LENGTH_LONG).show();
    }
}

package com.farizdotid.tutorialfarizdotid.customfont;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.farizdotid.tutorialfarizdotid.R;

import java.util.Objects;

public class CustomFontActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_font);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.title_custom_font));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
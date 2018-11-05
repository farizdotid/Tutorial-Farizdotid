package com.farizdotid.tutorialfarizdotid.imagecircle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.farizdotid.tutorialfarizdotid.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ImageCircleActivity extends AppCompatActivity {

    @BindView(R.id.ivInternet)
    ImageView ivInternet;
    @BindView(R.id.ivLokal)
    ImageView ivLokal;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_circle);

        ButterKnife.bind(this);
        unbinder =  ButterKnife.bind(this);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.title_image_circle_example));

        // Fungsi untuk mengambil gambar dari internet
        String mUrlPicture = "https://regmedia.co.uk/2015/07/30/android_logo.jpg?x=442&y=293&crop=1";
        Glide.with(this)
                .load(mUrlPicture)
                .apply(RequestOptions.circleCropTransform())
                .into(ivInternet);

        // Fungsi untuk mengambil gambar dari drawable
        Glide.with(this)
                .load(R.drawable.icon_android)
                .apply(RequestOptions.circleCropTransform())
                .into(ivLokal);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}

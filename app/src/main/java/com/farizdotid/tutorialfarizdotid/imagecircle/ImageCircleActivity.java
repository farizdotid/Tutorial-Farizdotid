package com.farizdotid.tutorialfarizdotid.imagecircle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.farizdotid.tutorialfarizdotid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageCircleActivity extends AppCompatActivity {

    @BindView(R.id.ivInternet)
    ImageView ivInternet;
    @BindView(R.id.ivLokal)
    ImageView ivLokal;

    String mUrlPicture = "https://regmedia.co.uk/2015/07/30/android_logo.jpg?x=442&y=293&crop=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_circle);
        ButterKnife.bind(this);

        // Fungsi untuk mengambil gambar dari internet
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
}

package com.farizdotid.tutorialfarizdotid.glideloading;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.farizdotid.tutorialfarizdotid.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GlideLoadingActivity extends AppCompatActivity {

    @BindView(R.id.ivGambar)
    ImageView ivGambar;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_loading);

        ButterKnife.bind(this);
        unbinder =  ButterKnife.bind(this);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.glide_loading_sample));

        String urlGambar = "https://regmedia.co.uk/2015/07/30/android_logo.jpg?x=442&y=293&crop=1";
        Glide.with(this)
                .load(urlGambar)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        pbLoading.setVisibility(View.GONE);
                        Toast.makeText(GlideLoadingActivity.this, "Gagal memuat gambar", Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        pbLoading.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(ivGambar);
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

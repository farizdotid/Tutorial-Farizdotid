package com.farizdotid.tutorialfarizdotid.cornerradius;

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
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.farizdotid.tutorialfarizdotid.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CornerRadiusGlideActivity extends AppCompatActivity {

    @BindView(R.id.ivGambar)
    ImageView ivGambar;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corner_radius_glide);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.title_radius_glide));

        unbinder = ButterKnife.bind(this);

        String urlGambar = "https://storage.googleapis.com/spec-host-backup/mio-design%2Fassets%2F1tQssXg-bNQWBXuGFBP8Dsj0csZaCIfNU%2Fimplementation-android.png";

        Glide.with(this)
                .load(urlGambar)
                .apply(new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(32)))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        pbLoading.setVisibility(View.GONE);
                        Toast.makeText(CornerRadiusGlideActivity.this, "Gagal memuat gambar", Toast.LENGTH_SHORT).show();
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
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}

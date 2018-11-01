package com.farizdotid.tutorialfarizdotid.tabgoogleplay;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.farizdotid.tutorialfarizdotid.R;
import com.lapism.searchview.widget.SearchView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabGooglePlayActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.rlSearch)
    RelativeLayout rlSearch;

    TabGooglePlayAdapter tabGooglePlayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_google_play);
        ButterKnife.bind(this);

        setupTabLayout();
        searchView.setHint("Search Home");
    }

    /*
    Fungsi untuk mengganti warna pada status bar
     */
    public void setStatusBarColor(String color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            int statusBarColor = Color.parseColor(color);
            if (statusBarColor == Color.BLACK && window.getNavigationBarColor() == Color.BLACK) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            } else {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            }
            window.setStatusBarColor(statusBarColor);
        }
    }

    /*
    FUngsi untuk membuat dan mengkonfigurasi tab.
     */
    private void setupTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("HOME"));
        tabLayout.addTab(tabLayout.newTab().setText("GAMES"));
        tabLayout.addTab(tabLayout.newTab().setText("MOVIES"));
        tabLayout.addTab(tabLayout.newTab().setText("BOOKS"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabGooglePlayAdapter = new TabGooglePlayAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabGooglePlayAdapter);
        viewPager.setCurrentItem(0);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                /*
                Switch case disini berfungsi untuk mengatur warna dan hint ketika disuatu posisi.
                Contoh :
                jika tab berada di posisi 0 yang berarti posisi 0 ini adalah tab pada kategori Home,
                warnanya akan berubah dan juga hint pada searchview akan berubah.

                posisi 0 = HOME
                posisi 1 = GAMES
                posisi 2 = MOVIES
                posisi 3 = BOOKS
                 */
                switch (tab.getPosition()) {
                    case 0:
                        setStatusBarColor("#3F51B5");
                        tabLayout.setBackgroundColor(Color.parseColor("#3F51B5"));
                        rlSearch.setBackgroundColor(Color.parseColor("#3F51B5"));
                        searchView.setHint("Search Home");
                        break;
                    case 1:
                        setStatusBarColor("#007a0e");
                        tabLayout.setBackgroundColor(Color.parseColor("#007a0e"));
                        rlSearch.setBackgroundColor(Color.parseColor("#007a0e"));
                        searchView.setHint("Search Games");
                        break;
                    case 2:
                        setStatusBarColor("#960000");
                        tabLayout.setBackgroundColor(Color.parseColor("#960000"));
                        rlSearch.setBackgroundColor(Color.parseColor("#960000"));
                        searchView.setHint("Search Movies");
                        break;
                    case 3:
                        setStatusBarColor("#008282");
                        tabLayout.setBackgroundColor(Color.parseColor("#008282"));
                        rlSearch.setBackgroundColor(Color.parseColor("#008282"));
                        searchView.setHint("Search Books");
                        break;
                }
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }
}

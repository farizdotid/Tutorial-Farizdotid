package com.farizdotid.tutorialfarizdotid.adapterlistener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.farizdotid.tutorialfarizdotid.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AdapterListenerActivity extends AppCompatActivity
        implements MakananAdapter.MakananAdapterCallback {

    @BindView(R.id.rvMakanan)
    RecyclerView rvMakanan;

    Unbinder unbinder;
    MakananAdapter makananAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_listener);

        ButterKnife.bind(this);
        unbinder = ButterKnife.bind(this);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.title_adapter_click_listener));

        makananAdapter = new MakananAdapter(this, getMakananSundaList(), this);
        rvMakanan.setLayoutManager(new LinearLayoutManager(this));
        rvMakanan.setItemAnimator(new DefaultItemAnimator());
        rvMakanan.setHasFixedSize(true);
        rvMakanan.setAdapter(makananAdapter);
        makananAdapter.notifyDataSetChanged();
    }

    private List<MakananSunda> getMakananSundaList(){
        List<MakananSunda> makananSundaList = new ArrayList<>();
        makananSundaList.add(new MakananSunda(R.drawable.bakakak_hayam, "Bakakak Ayam"));
        makananSundaList.add(new MakananSunda(R.drawable.karedok, "Karedok"));
        makananSundaList.add(new MakananSunda(R.drawable.lotek, "Lotek"));
        makananSundaList.add(new MakananSunda(R.drawable.mie_kocok, "Mie Kocok"));
        makananSundaList.add(new MakananSunda(R.drawable.nasi_liwet, "Nasi Liwet"));
        makananSundaList.add(new MakananSunda(R.drawable.nasi_timbel, "Nasi Timbel"));
        makananSundaList.add(new MakananSunda(R.drawable.pepes, "Pepes"));
        makananSundaList.add(new MakananSunda(R.drawable.tumis_genjer_oncom, "Tumis Genjer Oncom"));
        return makananSundaList;
    }

    @Override
    public void onRowMakananAdapterClicked(int position) {
        String nama = getMakananSundaList().get(position).getNama();
        Toast.makeText(this, "Kamu memilih makanan " + nama, Toast.LENGTH_SHORT).show();
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

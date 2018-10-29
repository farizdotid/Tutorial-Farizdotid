package com.farizdotid.tutorialfarizdotid.adapterlistener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.farizdotid.tutorialfarizdotid.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Fariz Ramadhan.
 * website : https://farizdotid.com/
 * github : https://github.com/farizdotid
 * linkedin : https://www.linkedin.com/in/farizramadhan/
 */
public class MakananAdapter extends
        RecyclerView.Adapter<MakananAdapter.ViewHolder> {

    private static final String TAG = MakananAdapter.class.getSimpleName();

    private Context context;
    private List<MakananSunda> list;
    private MakananAdapterCallback mAdapterCallback;

    public MakananAdapter(Context context, List<MakananSunda> list, MakananAdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.mAdapterCallback = adapterCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_makanan,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MakananSunda item = list.get(position);

        int resourceGambar = item.getGambar();
        String nama = item.getNama();

        holder.ivGambar.setImageResource(resourceGambar);
        holder.tvNama.setText(nama);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear() {
        int size = this.list.size();
        this.list.clear();
        notifyItemRangeRemoved(0, size);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivGambar)
        ImageView ivGambar;
        @BindView(R.id.tvNama)
        TextView tvNama;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            /*
            Inisialisasi onclick pada itemview dan memanggil interface yang sudah kita buat tadi.
             */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    Memanggil interface dan juga methodnya. getAdapterPosition ini adalah method bawaan
                    adapter untuk memanggil index posisi.
                     */
                    mAdapterCallback.onRowMakananAdapterClicked(getAdapterPosition());
                }
            });
        }
    }

    /*
    interface sebagai listener onclick adapter ke parent activity
     */
    public interface MakananAdapterCallback {
        /*
        Disini kalian bisa membuat beberapa fungsi dengan parameter sesuai kebutuhan. Kebutuhan
        disini adalah untuk mendapatkan pada posisi mana user mengklik listnya.
         */
        void onRowMakananAdapterClicked(int position);
    }
}
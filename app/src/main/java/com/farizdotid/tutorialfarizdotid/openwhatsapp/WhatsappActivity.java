package com.farizdotid.tutorialfarizdotid.openwhatsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.farizdotid.tutorialfarizdotid.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WhatsappActivity extends AppCompatActivity {

    @BindView(R.id.etNomorHp)
    EditText etNomorHp;
    @BindView(R.id.btnOpenWhatsapp)
    Button btnOpenWhatsapp;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);

        unbinder = ButterKnife.bind(this);

        btnOpenWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                substring(1) ini artinya kita akan menghapus karakter pertama dari sebuah string.
                Misalnya user meng-inputkan 0858 maka angka pertama dari 0858 yaitu 0 akan dihapus,
                karena kebutuhan kita titdak perlu memakai angka 0.
                 */
                String nomorHp = etNomorHp.getText().toString().substring(1);
                if (nomorHp.isEmpty()) {
                    Toast.makeText(WhatsappActivity.this, getString(R.string.error_message_form_empty),
                            Toast.LENGTH_SHORT).show();
                } else {
                    /*
                    Setelah kebutuhan nomor kita sudah di sortir. Maksudnya yang asalnya user input
                    08586078xxxx maka jadi 8586078xxxxx dan disini kita tambahkan +62 didepan nomor yang
                    user sudah input. Karena kebutuhan dari api Whatsapp harus memakai kode negara.
                     */
                    openWhatsApp("+62" + nomorHp);
                }
            }
        });
    }

    /*
    Fungsi untuk membuka aplikasi whatsapp menggunakan API yang disediakan.
     */
    private void openWhatsApp(String number) {
        String url = "https://api.whatsapp.com/send?phone=" + number;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}

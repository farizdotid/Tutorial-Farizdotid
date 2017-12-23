package com.farizdotid.tutorialfarizdotid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class EmailValidationActivity extends AppCompatActivity {

    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.btnCek)
    Button btnCek;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_validation);
        ButterKnife.bind(this);
        unbinder = ButterKnife.bind(this);

        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidEmail(etEmail.getText().toString())){
                    Toast.makeText(EmailValidationActivity.this,
                            "Format email sudah benar", Toast.LENGTH_SHORT).show();
                } else {
                    etEmail.setError("Format email salah");
                    Toast.makeText(EmailValidationActivity.this,
                            "Format email salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static boolean isValidEmail(String email) {
        boolean validate = true;
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String emailPattern2 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";

        if (email.matches(emailPattern)) {
            validate = true;
        } else if (email.matches(emailPattern2)) {
            validate = true;
        } else {
            validate = false;
        }

        return validate;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
package com.example.componentwidgetbag1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    // deklarasi komponen
    String resultText;
    EditText edtName;
    Button btnSubmit;
    TextView txtResult;
    CheckBox cbMancing, cbNgoding, cbRebahan;
    ToggleButton tgMakan;
    Switch swIsJomblo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // inisialisasi komponen
        edtName = findViewById(R.id.edt_name);
        btnSubmit = findViewById(R.id.btn_submit);
        txtResult = findViewById(R.id.txt_result);
        cbMancing = findViewById(R.id.cb_mancing);
        cbNgoding = findViewById(R.id.cb_ngoding);
        cbRebahan = findViewById(R.id.cb_rebahan);
        tgMakan = findViewById(R.id.tg_makan);
        swIsJomblo = findViewById(R.id.sw_is_jomblo);

        // event click button submit
        btnSubmit.setOnClickListener(view -> {
            this.getResult();
        });
    }

    private void getResult()
    {
        resultText = "";
        txtResult.setText(resultText);

        // get value dari edtName
        resultText += "Nama : " + edtName.getText().toString();

        // check isChecked dari checkbox jika checkbox nya aktif / dipilih
        resultText += "\nHobi : ";
        if( cbMancing.isChecked() ) { resultText += "Mancing, "; };
        if( cbNgoding.isChecked() ) { resultText += "Ngoding, "; };
        if( cbRebahan.isChecked() ) { resultText += "Rebahan"; };

        // get text dari toggle button
        resultText += "\nStatus makan : " + tgMakan.getText();

        // get isChecked dari switch
        resultText += "\nStatus Jomblo : ";
        if(swIsJomblo.isChecked()){ resultText += "Iya"; } else { resultText += "Tidak dong"; }

        // tampilkan result nya
        txtResult.setText(resultText);
    }
}
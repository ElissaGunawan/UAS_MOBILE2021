package umn.ac.id.uasproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    Spinner spinner;
    TextView cek;
    EditText nama, alamat, notelp, deskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().hide();

        cek = findViewById(R.id.cek);
        nama = findViewById(R.id.ETname);
        alamat = findViewById(R.id.ETalamat);
        notelp = findViewById(R.id.ETnoTelp);
        deskripsi = findViewById(R.id.ETdeskirpsi);
        spinner = findViewById(R.id.spinner);
    }
    public void pilihCuci(View view){
        String cuci = String.valueOf(spinner.getSelectedItem());
        cek.setText("Berhasil");
    }
}
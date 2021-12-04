package com.example.tugas7_1918094_arkan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Emusik, Eartist, Egenre;
    private String Smusik, Sartist, Sgenre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Emusik = (EditText) findViewById(R.id.create_musik);
        Eartist = (EditText) findViewById(R.id.create_artist);
        Egenre = (EditText) findViewById(R.id.create_genre);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Smusik = String.valueOf(Emusik.getText());
                Sartist = String.valueOf(Eartist.getText());
                Sgenre = String.valueOf(Egenre.getText());
                if (Smusik.equals("")){
                    Emusik.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama musik",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sartist.equals("")) {
                    Eartist.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama artist",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sgenre.equals("")) {
                    Egenre.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama genre",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Emusik.setText("");
                    Eartist.setText("");
                    Egenre.setText("");
                    Toast.makeText(MainCreate.this, "Submit Berhasil!",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMusik(new Musik(null, Smusik, Sartist, Sgenre));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}


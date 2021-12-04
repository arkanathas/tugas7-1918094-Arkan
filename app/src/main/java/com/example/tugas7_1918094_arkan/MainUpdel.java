package com.example.tugas7_1918094_arkan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Smusik, Sartist, Sgenre;
    private EditText Emusik, Eartist, Egenre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Smusik = i.getStringExtra("Imusik");
        Sartist = i.getStringExtra("Iartist");
        Sgenre = i.getStringExtra("Igenre");
        Emusik = (EditText) findViewById(R.id.updel_musik);
        Eartist = (EditText) findViewById(R.id.updel_artist);
        Egenre = (EditText) findViewById(R.id.updel_genre);
        Emusik.setText(Smusik);
        Eartist.setText(Sartist);
        Egenre.setText(Sgenre);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Smusik = String.valueOf(Emusik.getText());
                Sartist = String.valueOf(Eartist.getText());
                Sgenre = String.valueOf(Egenre.getText());
                if (Smusik.equals("")){
                    Emusik.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama musik",
                            Toast.LENGTH_SHORT).show();
                } else if (Sartist.equals("")){
                    Eartist.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama artist",
                            Toast.LENGTH_SHORT).show();
                } else if (Sgenre.equals("")){
                    Egenre.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama genre",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMusik(new Musik(Sid, Smusik, Sartist, Sgenre));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMusik(new Musik(Sid, Smusik, Sartist, Sgenre));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}


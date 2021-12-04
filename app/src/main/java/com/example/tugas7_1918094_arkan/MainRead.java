package com.example.tugas7_1918094_arkan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Musik> ListMusik = new ArrayList<Musik>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMusik);
        mListView = (ListView) findViewById(R.id.list_musik);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMusik.clear();
        List<Musik> musik = db.ReadMusik();
        for (Musik msk : musik) {
            Musik daftar = new Musik();
            daftar.set_id(msk.get_id());
            daftar.set_musik(msk.get_musik());
            daftar.set_artist(msk.get_artist());
            daftar.set_genre(msk.get_genre());
            ListMusik.add(daftar);
            if ((ListMusik.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Musik detailMsk = (Musik) o;
        String Sid = detailMsk.get_id();
        String Smusik = detailMsk.get_musik();
        String Sartist = detailMsk.get_artist();
        String Sgenre = detailMsk.get_genre();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Imusik", Smusik);
        goUpdel.putExtra("Iartist", Sartist);
        goUpdel.putExtra("Igenre" , Sgenre);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMusik.clear();
        mListView.setAdapter(adapter_off);
        List<Musik> musik = db.ReadMusik();
        for (Musik msk : musik) {
            Musik daftar = new Musik();
            daftar.set_id(msk.get_id());
            daftar.set_musik(msk.get_musik());
            daftar.set_artist(msk.get_artist());
            daftar.set_genre(msk.get_genre());
            ListMusik.add(daftar);
            if ((ListMusik.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

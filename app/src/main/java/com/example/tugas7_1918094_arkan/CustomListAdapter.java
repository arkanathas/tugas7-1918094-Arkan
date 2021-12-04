package com.example.tugas7_1918094_arkan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Musik> Musik;
    public CustomListAdapter(Activity activity, List<Musik> Musik) {
        this.activity = activity;
        this.Musik = Musik;
    }
    @Override
    public int getCount() {
        return Musik.size();
    }
    @Override
    public Object getItem(int location) {
        return Musik.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView musik = (TextView)
                convertView.findViewById(R.id.text_musik);
        TextView artist = (TextView)
                convertView.findViewById(R.id.text_artist);
        TextView genre = (TextView)
                convertView.findViewById(R.id.text_genre);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Musik m = Musik.get(position);
        musik.setText("Nama Musik : "+ m.get_musik());
        artist.setText("Artist : "+ m.get_artist());
        genre.setText("Genre : "+ m.get_genre());
        return convertView;
    }
}


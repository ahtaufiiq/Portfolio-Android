package com.example.ataufiq.firebase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ataufiq.firebase.model.Makanan;

import java.util.List;

public class MakananList extends ArrayAdapter<Makanan> {
    private Activity context;
    List<Makanan> foods;

    public MakananList(Activity context, List<Makanan> makanan) {
        super(context, R.layout.activity_makanan_list, makanan);
        this.context = context;
        this.foods = makanan;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_makanan_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewType = (TextView) listViewItem.findViewById(R.id.textViewGenre);

        Makanan makanan = foods.get(position);
        textViewName.setText(makanan.getFoodName());
        textViewType.setText(makanan.getTypeFood());

        return listViewItem;
    }
}


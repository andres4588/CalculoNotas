package com.example.sistemas.calculonotas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sistemas on 29/09/17.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    int[] images;
    String[] names;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationcontext, String[] names, int[] Images) {
        this.context = applicationcontext;
        this.images = Images;
        this.names = names;
        inflter = (LayoutInflater.from(applicationcontext));

    }


    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.list_item, null);
        TextView NameG = (TextView) view.findViewById(R.id.name);
        ImageView ImageG = (ImageView) view.findViewById(R.id.image);
        NameG.setText(names[position]);
        ImageG.setImageResource(images[position]);
        return view;

    }




}

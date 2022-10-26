package com.example.tp2_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FruitAdapter extends BaseAdapter {
    private Context context;
    private List<Fruit> fruits = new ArrayList<>();

    public FruitAdapter(Context context, List<Fruit> fruits) {
        this.context = context;
        this.fruits = fruits;
    }

    @Override
    public int getCount() {
        return fruits.size();
    }

    @Override
    public Object getItem(int i) {
        return fruits.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = LayoutInflater.from(context);
        View v = li.inflate(R.layout.item_list, null);
        TextView fruitName = (TextView) v.findViewById(R.id.fruitn);
        TextView fruitDescription = (TextView) v.findViewById(R.id.fruitd);
        ImageView fruitIcon = (ImageView) v.findViewById(R.id.fruit_icon);

        fruitName.setText(fruits.get(i).Nom);
        fruitDescription.setText(fruits.get(i).Description);
        fruitIcon.setImageResource(context.getResources().getIdentifier(fruits.get(i).Nom_Icone, "drawable", context.getPackageName()));
        return v;
    }
}

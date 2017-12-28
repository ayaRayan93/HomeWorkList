package com.example.ayaali.homeworklist.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ayaali.homeworklist.R;
import com.example.ayaali.homeworklist.models.HomeWork;

import java.util.List;

/**
 * Created by AyaAli on 28/12/2017.
 */

public class HomeWorkAdapter extends ArrayAdapter<String> {

    private List<HomeWork> homeWorks;
    private final Activity context;

    public HomeWorkAdapter(List<HomeWork> homeWorks, Activity context1) {
        super(context1, R.layout.item_list);

        this.homeWorks = homeWorks;
        this.context = context1;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.item_list, null, true);
        TextView textView = (TextView) rowView.findViewById(R.id.title);
        TextView TextView1 = (TextView) rowView.findViewById(R.id.date);
        textView.setText(homeWorks.get(position).getTitel());
        TextView1.setText(homeWorks.get(position).getTitel());

        return rowView;
    }
}
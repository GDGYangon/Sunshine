package com.androidbootcamp.sunshine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ye Lin Aung on 14/09/26.
 */
public class ForecastAdapter extends ArrayAdapter<Item> {

    Context context;

    public ForecastAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);

        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item_forecast, null, false);

        TextView textView = (TextView)convertView.findViewById(R.id.list_item_forecast_textview);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.list_item_forecast_image);

        Item item = (Item)getItem(position);
        textView.setText(item.getText());
        Picasso.with(context).load(item.getImage()).into(imageView);
        return convertView;

    }
}

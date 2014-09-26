package com.androidbootcamp.sunshine;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by Ye Lin Aung on 14/09/26.
 */
public class ForecastAdapter extends ArrayAdapter<String> {

    public ForecastAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}

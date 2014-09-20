package com.androidbootcamp.sunshine;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Ye Lin Aung on 14/09/20.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView detailText = (TextView) rootView.findViewById(R.id.detail_text);
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String foreCastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
            detailText.setText(foreCastStr);
        }

        return rootView;
    }
}

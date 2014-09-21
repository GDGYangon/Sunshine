package com.androidbootcamp.sunshine;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ShareActionProvider;
import android.widget.TextView;

/**
 * Created by Ye Lin Aung on 14/09/20.
 */
public class DetailFragment extends Fragment {

    public static final String BOOTCAMP_HASH = " #AndroidBootCampYangon";
    public String mForecastStr;
    public static final String LOG_TAG = DetailFragment.class.getSimpleName();

    public DetailFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView detailText = (TextView) rootView.findViewById(R.id.detail_text);
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            mForecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
            detailText.setText(mForecastStr);
        }

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //inflate the menu. This adds the menu item to the ActionBar
        inflater.inflate(R.menu.detail_fragment, menu);
/*
        //Retrieve the share menu item
*/
        MenuItem item = menu.findItem(R.id.menu_item_share);
        //fetch and store the ActionProvider
        android.support.v7.widget.ShareActionProvider mShareActionProvider =
                (android.support.v7.widget.ShareActionProvider) MenuItemCompat.getActionProvider(item);
        //Attach the intent to the ActionProvider. You can update this at any time.
        //like when users select a new piece of data they'd like to share
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(createShareForecastIntent());
            Log.d(LOG_TAG, "Setting share intent");
        } else {
            Log.d(LOG_TAG, "Share Action Provider is null");
        }
        super.onCreateOptionsMenu(menu, inflater);
    }


    private Intent createShareForecastIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        // Important to set the flag. Else, you may end up in the app that share the data
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mForecastStr + BOOTCAMP_HASH);
        return shareIntent;
    }
}

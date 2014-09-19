package com.androidbootcamp.sunshine;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Ye Lin Aung on 14/09/19.
 */
public class MySharedPreference {

    private static MySharedPreference pref;
    protected SharedPreferences mSharedPreferences;
    protected SharedPreferences.Editor mEditor;
    protected Context mContext;

    private static final String PREF_LOCATION = "pref_location";
    private static final String DEFAULT_LOCATION = "YANGON";

    public MySharedPreference(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mSharedPreferences.edit();

        this.mContext = context;
    }

    // Get an instance of a MySharedPreference
    public static synchronized MySharedPreference getInstance(Context mContext) {
        if (pref == null) {
            pref = new MySharedPreference(mContext);
        }
        return pref;
    }

    /**
     * Set location passed via argument
     *
     * @param location location argument
     */
    public void setLocation(String location) {
        mEditor.putString(PREF_LOCATION, location).apply();
    }

    /**
     * Return a default location if the getString returns null
     *
     * @return the saved location. If the getString returns null, return default location.
     */

    public String getLocation() {
        return mSharedPreferences.getString(PREF_LOCATION, DEFAULT_LOCATION);
    }
}

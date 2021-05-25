package com.example.nanum;

import android.content.Context;
import android.content.SharedPreferences;

public class ExplainSession {

    SharedPreferences spref;
    SharedPreferences.Editor editor;
    Context context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "ExplainSession";

    private static final String FIRST_TIME_LAUNCH = "FirstTimeLaunch";

    public ExplainSession(Context context) {
        this.context = context;
        spref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = spref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return spref.getBoolean(FIRST_TIME_LAUNCH, true);
    }

}

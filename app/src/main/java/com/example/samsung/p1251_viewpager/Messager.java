package com.example.samsung.p1251_viewpager;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by samsung on 18.05.2017.
 */

public class Messager {

    private final static String LOG_TAG = "myLogs";

    public final static void sendToAllRecipients(
            final Context context,
            final String message) {
        Log.d(LOG_TAG, message);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public final static void sendToOnlyLog(
            final String message) {
        Log.d(LOG_TAG, message);
    }

}

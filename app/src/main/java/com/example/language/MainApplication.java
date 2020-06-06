package com.example.language;

import android.app.Application;
import android.content.Context;

import com.example.language.Helper.LocalHelper;

import java.util.Locale;

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocalHelper.onAttach(base, "en"));
    }
}















































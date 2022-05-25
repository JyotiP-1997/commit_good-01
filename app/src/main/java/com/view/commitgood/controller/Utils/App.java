package com.view.commitgood.controller.Utils;

/*
 * Created by Nishant  Bhardwaj on 15-06-2017.
 */


import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class App extends MultiDexApplication {
    private static App appInstance;
    private static com.view.commitgood.controller.Utils.AppPreferences appPreferences;





    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        appInstance = this;
        appPreferences = com.view.commitgood.controller.Utils.AppPreferences.init(appInstance);

    }



    public static App getAppContext() {
        return appInstance;

    }


    }

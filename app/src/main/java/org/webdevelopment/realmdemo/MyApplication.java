package org.webdevelopment.realmdemo;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by makn on 08-05-2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
        RealmConfiguration config =
                new RealmConfiguration.Builder().
                    modules(new MyRealmModule()).build();
        Realm.setDefaultConfiguration(config);
    }

}

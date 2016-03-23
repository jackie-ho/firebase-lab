package com.adi.ho.jackie.chatroomapp;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by JHADI on 3/23/16.
 */
public class FirebaseApplication  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}

package dev3.dswiii_grupo03;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Chris on 04/11/2017.
 */

public class MyApp extends Application {

    public void onCreate() {
        super.onCreate();
    }

    private AppCompatActivity mCurrentActivity = null;

    public AppCompatActivity getCurrentActivity(){
        return mCurrentActivity;
    }


    public void setCurrentActivity(AppCompatActivity mCurrentActivity){
        this.mCurrentActivity = mCurrentActivity;
    }
}

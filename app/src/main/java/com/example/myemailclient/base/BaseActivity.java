package com.example.myemailclient.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.myemailclient.application.MyEmailClientApplication;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 * Created by dendy-prtha on 25/02/2019.
 * as base Activity. all activity must extend this class!
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    public abstract int getLayout();

    public abstract void init();

    public void init(Bundle savedInstanceState){
        init();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        init(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * get {@link MyEmailClientApplication}
     */
    /*public MyEmailClientApplication getApplicationComponent() {
        return ((MyEmailClientApplication) getApplication()).ge;
    }*/
}

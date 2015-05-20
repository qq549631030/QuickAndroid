package com.huangxiang.quickandroid.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.huangxiang.quickandroid.BaseActivity;
import com.huangxiang.quickandroid.R;

public class SplashActivity extends BaseActivity {

    private static final int GO_TO_GUIDE = 1;
    private static final int GO_TO_LOGIN = 2;
    private static final int GO_TO_HOME = 3;

    private boolean isFirst;
    private boolean autoLogin;
    private String userName;
    private String password;


    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_TO_GUIDE:
                    Intent intentGuide = new Intent(SplashActivity.this,
                            LoginActivity.class);
                    startActivity(intentGuide);
                    SplashActivity.this.finish();
                    break;

                case GO_TO_LOGIN:
                    Intent intentLogin = new Intent(SplashActivity.this,
                            LoginActivity.class);
                    startActivity(intentLogin);
                    SplashActivity.this.finish();
                    break;
                case GO_TO_HOME:

                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler.sendEmptyMessageDelayed(GO_TO_LOGIN, 2000);
    }

    @Override
    protected void onDestroy() {
        mHandler.removeMessages(GO_TO_GUIDE);
        mHandler.removeMessages(GO_TO_LOGIN);
        mHandler.removeMessages(GO_TO_HOME);
        super.onDestroy();
    }

    public void toLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}

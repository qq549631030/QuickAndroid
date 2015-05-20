package com.huangxiang.quickandroid.login;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.huangxiang.quickandroid.BaseActivity;
import com.huangxiang.quickandroid.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {

    @InjectView(R.id.login_progress)
    ProgressBar loginProgress;
    @InjectView(R.id.email)
    AutoCompleteTextView email;
    @InjectView(R.id.password)
    EditText password;
    @InjectView(R.id.email_sign_in_button)
    Button emailSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

    }


}


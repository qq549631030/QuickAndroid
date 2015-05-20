package com.huangxiang.quickandroid.simples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.huangxiang.quickandroid.R;
import com.huangxiang.quickandroid.compat.ActivityOptionsUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SimplesActivity extends Activity implements View.OnClickListener {


    @InjectView(R.id.top_textView_left)
    TextView topTextViewLeft;
    @InjectView(R.id.top_textview_center)
    TextView topTextviewCenter;
    @InjectView(R.id.top_textView_right)
    TextView topTextViewRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simples);
        ButterKnife.inject(this);

        findViewById(R.id.button1).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent(SimplesActivity.this, PullRefreshSimpleActivity.class);
                //startActivity(intent);
                ActivityOptionsUtils.startActivityAnim(SimplesActivity.this,intent);
                break;
        }
    }
}

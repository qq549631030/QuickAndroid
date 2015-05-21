package com.huangxiang.quickandroid.simples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.huangxiang.quickandroid.R;
import com.huangxiang.quickandroid.compat.activityoptions.ActivityCompatICS;
import com.huangxiang.quickandroid.compat.activityoptions.ActivityOptionsCompatICS;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SimplesActivity extends Activity implements View.OnClickListener {


    @InjectView(R.id.top_textView_left)
    TextView topTextViewLeft;
    @InjectView(R.id.top_textview_center)
    TextView topTextviewCenter;
    @InjectView(R.id.top_textView_right)
    TextView topTextViewRight;
    @InjectView(R.id.button1)
    Button button1;
    @InjectView(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simples);
        ButterKnife.inject(this);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent1 = new Intent(SimplesActivity.this, PullRefreshSimpleActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
                break;

            case R.id.button2:
                Intent intent2 = new Intent(SimplesActivity.this, MainActivity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
                break;
        }
    }

    public void scaleUpAnim(View view) {
        Intent intent = new Intent(SimplesActivity.this, PullRefreshSimpleActivity.class);
        ActivityOptionsCompatICS options = ActivityOptionsCompatICS.makeScaleUpAnimation(view,
                0, 0, //拉伸开始的坐标
                view.getMeasuredWidth(), view.getMeasuredHeight());//初始的宽高
        ActivityCompatICS.startActivity(SimplesActivity.this, intent, options.toBundle());
    }
}

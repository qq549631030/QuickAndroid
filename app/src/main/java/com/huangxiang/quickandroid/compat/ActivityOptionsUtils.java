package com.huangxiang.quickandroid.compat;

import android.app.Activity;
import android.content.Intent;

import com.huangxiang.quickandroid.R;
import com.huangxiang.quickandroid.compat.activityoptions.ActivityCompatICS;
import com.huangxiang.quickandroid.compat.activityoptions.ActivityOptionsCompatICS;
import com.huangxiang.quickandroid.compat.activityoptions.TransitionCompat;

/**
 * Created by huangxiang on 15/5/20.
 */
public class ActivityOptionsUtils {
    public static void startActivityAnim(Activity activity, Intent intent) {
        ActivityOptionsCompatICS options = ActivityOptionsCompatICS.makeCustomAnimation(activity,
                R.anim.move_right_in_activity, R.anim.move_left_out_activity);
        ActivityCompatICS.startActivity(activity, intent, options.toBundle());
    }

    public static void endActivityAnim(Activity activity) {
        TransitionCompat.finishAfterTransition(activity, R.anim.move_left_in_activity, R.anim.move_right_out_activity);
    }
}

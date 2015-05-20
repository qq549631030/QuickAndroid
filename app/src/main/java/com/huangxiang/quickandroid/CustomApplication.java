package com.huangxiang.quickandroid;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.huangxiang.quickandroid.utils.LogUtils;
import com.huangxiang.quickandroid.utils.SharedPreferencesUtils;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by huangxiang on 15/5/14.
 */
public class CustomApplication extends Application{


    private final String TAG = CustomApplication.class.getSimpleName();

    private static final String SET_COOKIE_KEY = "Set-Cookie";
    private static final String COOKIE_KEY = "Cookie";
    private static final String SESSION_COOKIE = "JSESSIONID";

    /**
     * Log or request TAG
     */
    public static final String VOLLEY_TAG = "VolleyPatterns";

    private static CustomApplication mInstance;

    public static ArrayList<Activity> activityList;

    private static RequestQueue mRequestQueue;

    public static int currentLoginId;

    private String sessionId = "";

    private SharedPreferencesUtils preferences;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        preferences = new SharedPreferencesUtils(mInstance);
        // sessionId = preferences.getPreferenceValue(SESSION_COOKIE, "");
        activityList = new ArrayList<Activity>();
        initImageLoader(getApplicationContext());
    }

    public static synchronized CustomApplication getInstance() {
        return mInstance;
    }

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeAllActivity() {
        for (Activity a : activityList) {
            a.finish();
        }
        activityList.clear();
    }

    public static void initImageLoader(Context context) {
        try {// 缓存目录
            ImageLoaderConfiguration config;
            config = new ImageLoaderConfiguration.Builder(context)
                    .threadPriority(Thread.NORM_PRIORITY - 2)
                    .denyCacheImageMultipleSizesInMemory()
                            // 使用1/8 (13%)APP内存
                    .memoryCacheSizePercentage(13)
                    .diskCacheFileNameGenerator(new ImageNameGenerator())
                    .tasksProcessingOrder(QueueProcessingType.LIFO).build();
            ImageLoader.getInstance().init(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // L.disableLogging();
    }

    private  static class ImageNameGenerator extends Md5FileNameGenerator {

        @Override
        public String generate(String imageUri) {
            return super.generate(imageUri) + ".jpg";
        }

    }

    public synchronized RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            synchronized (CustomApplication.class) {
                if (mRequestQueue == null) {
                    mRequestQueue = Volley.newRequestQueue(mInstance);
                }
            }
        }
        return mRequestQueue;
    }

    /**
     * Adds the specified request to the global queue, if tag is specified then
     * it is used else Default TAG is used.
     *
     * @param req
     * @param tag
     */
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? VOLLEY_TAG : tag);

        LogUtils.d(TAG, "Adding request to queue:" + req.getUrl());

        getRequestQueue().add(req);
    }

    /**
     * Adds the specified request to the global queue using the Default TAG.
     *
     * @param req
     */
    public <T> void addToRequestQueue(Request<T> req) {
        // set the default tag if tag is empty
        req.setTag(VOLLEY_TAG);

        getRequestQueue().add(req);
    }

    /**
     * Cancels all pending requests by the specified TAG, it is important to
     * specify a TAG so that the pending/ongoing requests can be cancelled.
     *
     * @param tag
     */
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    /**
     * 保存session
     *
     * @param headers
     */
    public void checkSessionCookie(Map<String, String> headers) {
        if (headers.containsKey(SET_COOKIE_KEY)
                && headers.get(SET_COOKIE_KEY).startsWith(SESSION_COOKIE)) {
            String cookie = headers.get(SET_COOKIE_KEY);
            if (cookie.length() > 0) {
                String[] splitCookie = cookie.split(";");
                String[] splitSessionId = splitCookie[0].split("=");
                cookie = splitSessionId[1];
                if (!cookie.equals(sessionId)) {
                    sessionId = cookie;
                    preferences.setPreferenceValue(SESSION_COOKIE, sessionId);
                }
            }
        }
    }

    /**
     * 请求头中加上保存的session
     *
     * @param headers
     */
    public void addSessionCookie(Map<String, String> headers) {
        if (sessionId.length() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append(SESSION_COOKIE);
            builder.append("=");
            builder.append(sessionId);
            if (headers.containsKey(COOKIE_KEY)) {
                builder.append("; ");
                builder.append(headers.get(COOKIE_KEY));
            }
            headers.put(COOKIE_KEY, builder.toString());
        }
    }

}

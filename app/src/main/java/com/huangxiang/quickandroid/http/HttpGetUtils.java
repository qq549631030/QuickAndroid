package com.huangxiang.quickandroid.http;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.huangxiang.quickandroid.CustomApplication;
import com.huangxiang.quickandroid.R;
import com.huangxiang.quickandroid.utils.LogUtils;
import com.huangxiang.quickandroid.utils.NetWorkUtils;
import com.huangxiang.quickandroid.utils.ToastUtils;

import org.json.JSONObject;

import java.util.Map;

public class HttpGetUtils {
	private final static String TAG = HttpGetUtils.class.getSimpleName();

	/**
	 * 执行HTTP请求
	 * 
	 * @param request
	 *            HTTP请求
	 * @return void
	 */
	public static void doRequest(Request<JSONObject> request) {
		CustomApplication.getInstance().addToRequestQueue(request);
	}

	/**
	 * GET请求
	 * 
	 * @param url
	 *            请求地址
	 * @param listener
	 *            请求监听
	 * @param errorListener
	 *            请求错误监听
	 * @return void
	 */
	public static void doGetRequest(String url, Map<String, String> params,
			Listener<JSONObject> listener, ErrorListener errorListener) {
		if (params != null) {
			url = url + "?";
			for (String key : params.keySet()) {
				url = url + key + "=" + params.get(key) + "&";
			}
			if (url.endsWith("&")) {
				url = url.substring(0, url.length() - 1);
			}
		}
		LogUtils.i(TAG, url);
		JsonObjectGetRequest mRequest = new JsonObjectGetRequest(url, listener,
				errorListener);
		doRequest(mRequest);
	}

	/**
	 * 懒调用(可设置是否显示默认错误提示语)
	 * 
	 * @param context
	 *            内容提供者
	 * @param url
	 *            接口地址
	 * @param params
	 *            接口参数
	 * @param listener
	 *            回调监听
	 * @param showCommanErrorMsg
	 *            是否显示默认提示语
	 */
	public static void doLazyGetRequest(final Context context, String url,
			Map<String, String> params, final HttpListener listener,
			final boolean showCommanErrorMsg) {
		if (context != null) {
			if (NetWorkUtils.isNetWorkConnect(context)) {
				doGetRequest(url, params, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject arg0) {
						listener.onPass(arg0);
					}
				}, new ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError arg0) {
						if (showCommanErrorMsg) {
							ToastUtils.showToast(
									context,
									context.getResources().getString(
											R.string.error_network_abnormal));
						}
						listener.onError(
								context.getResources().getString(
										R.string.error_network_available), 2);
					}
				});
			} else {
				if (showCommanErrorMsg) {
					ToastUtils.showToast(context, context.getResources()
							.getString(R.string.error_network_available));
				}
				listener.onError(
						context.getResources().getString(
								R.string.error_network_available), 1);
			}
		}
	}
}

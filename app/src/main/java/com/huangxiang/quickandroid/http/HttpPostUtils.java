package com.huangxiang.quickandroid.http;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
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

public class HttpPostUtils {

	private final static String TAG = HttpPostUtils.class.getSimpleName();

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
	 * POST请求
	 * 
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @param listener
	 *            请求监听
	 * @param errorListener
	 *            请求错误监听
	 * @return void
	 */
	public static void doPostRequest(String url, Map<String, String> params,
			Listener<JSONObject> listener, ErrorListener errorListener) {
		LogUtils.i(TAG, url);
		LogUtils.i(TAG, params.toString());
		JsonObjectPostRequest mRequest = new JsonObjectPostRequest(url,
				listener, errorListener, params);
		doRequest(mRequest);
	}

	/**
	 * 上传文件
	 * 
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @param listener
	 *            请求监听
	 * @param errorListener
	 *            请求错误监听
	 * @return void
	 */
	public static void doUploadRequest(String url,
			MultipartRequestParams params, Listener<JSONObject> listener,
			ErrorListener errorListener) {
		LogUtils.i(TAG, url);
		LogUtils.i(TAG, params.urlParams.toString());
		LogUtils.i(TAG, params.fileParams.toString());
		MultipartRequest mRequest = new MultipartRequest(url, listener,
				errorListener, params);
		mRequest.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));
		doRequest(mRequest);
	}

	/**
	 * 上传文件懒调用(可设置是否显示默认错误提示语)
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
	public static void dolazyUploadRequest(final Context context, String url,
			MultipartRequestParams params, final HttpListener listener,
			final boolean showCommanErrorMsg) {
		if (context != null) {
			if (NetWorkUtils.isNetWorkConnect(context)) {
				doUploadRequest(url, params, new Listener<JSONObject>() {

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
	public static void doLazyPostRequest(final Context context, String url,
			Map<String, String> params, final HttpListener listener,
			final boolean showCommanErrorMsg) {
		if (context != null) {
			if (NetWorkUtils.isNetWorkConnect(context)) {
				doPostRequest(url, params, new Listener<JSONObject>() {

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

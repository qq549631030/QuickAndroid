package com.huangxiang.quickandroid.utils;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ViewUtils {
	public static void setEmptyView(Context context, AbsListView adapterView) {
		TextView emptyView = new TextView(context);
		emptyView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		emptyView.setText("暂无内容");
		emptyView.setGravity(Gravity.CENTER);
		emptyView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
		emptyView.setVisibility(View.GONE);
		((ViewGroup) adapterView.getParent()).addView(emptyView);
		adapterView.setEmptyView(emptyView);
	}

	/**
	 * 
	 * @Title: setListViewHeightBasedOnChildren
	 * @author huangxiang
	 * @Description: 根据列表项数设置列表高度，最多显示5项
	 * @param @param listView 参数
	 * @return void 返回类型
	 * @throws
	 */
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		BaseAdapter listAdapter = (BaseAdapter) listView.getAdapter();
		if (listAdapter == null) {
			return;
		}

		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			int itemHeight = listItem.getMeasuredHeight();
			if (i <= 4) {
				totalHeight += itemHeight;
			}
		}

		LayoutParams params = listView.getLayoutParams();

		float dividerHeight = listView.getDividerHeight();
		if (listAdapter.getCount() <= 5) {
			params.height = (int) (totalHeight + ((dividerHeight) * (listAdapter
					.getCount() - 1)));
		} else {
			params.height = (int) (totalHeight + ((dividerHeight) * 4));
		}
		listView.setLayoutParams(params);

	}
}

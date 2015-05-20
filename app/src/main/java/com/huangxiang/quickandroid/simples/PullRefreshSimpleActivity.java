package com.huangxiang.quickandroid.simples;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.huangxiang.quickandroid.R;
import com.huangxiang.quickandroid.pullrefresh.PullToRefreshBase;
import com.huangxiang.quickandroid.pullrefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class PullRefreshSimpleActivity extends Activity {

    private PullToRefreshListView pullToRefreshListView;

    private ListView listView;

    private ListItemSimpleAdapter listItemSimpleAdapter;
    /**
     * 是否加载过数据
     */
    private boolean initRefresh;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    listItemSimpleAdapter.notifyDataSetChanged();
                    pullToRefreshListView.onRefreshComplete();
                    break;
            }
        }
    };

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        getWindow().setExitTransition(new Explode());

        setContentView(R.layout.pull_refresh_simple);
        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_to_refresh_listView);
        listView = pullToRefreshListView.getRefreshableView();
        listItemSimpleAdapter = new ListItemSimpleAdapter(this);
        listView.setAdapter(listItemSimpleAdapter);

        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                new GetDataTask(true).execute();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                new GetDataTask(false).execute();
            }
        });
    }

    @Override
    protected void onResume() {
        if (!initRefresh) {
            pullToRefreshListView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    pullToRefreshListView.setCurrentMode(PullToRefreshBase.Mode.PULL_FROM_START);
                    pullToRefreshListView.setRefreshing();
                    initRefresh = true;
                }
            }, 300);
        }
        super.onResume();
    }

    private void refreshDatas() {
        listItemSimpleAdapter.getObjects().clear();
        for (int i = 0; i < 10; i++) {
            String str = "item " + i;
            listItemSimpleAdapter.getObjects().add(str);
        }
    }

    private void getMoreDatas() {
        for (int i = 0; i < 10; i++) {
            String str = "item " + i;
            listItemSimpleAdapter.getObjects().add(str);
        }
    }

    private class GetDataTask extends AsyncTask<Void, Void, String[]> {
        private boolean isDropDown;

        public GetDataTask(boolean isDropDown) {
            this.isDropDown = isDropDown;
        }

        @Override
        protected String[] doInBackground(Void... params) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new String[0];
        }

        @Override
        protected void onPostExecute(String[] strings) {
            if (isDropDown) {
                refreshDatas();
            } else {
                getMoreDatas();
            }
            mHandler.sendEmptyMessage(1);
            super.onPostExecute(strings);
        }
    }


    public class ListItemSimpleAdapter<T> extends BaseAdapter {

        private List<T> objects = new ArrayList<T>();

        private Context context;
        private LayoutInflater layoutInflater;

        public ListItemSimpleAdapter(Context context) {
            this.context = context;
            this.layoutInflater = LayoutInflater.from(context);
        }

        public List<T> getObjects() {
            return objects;
        }

        @Override
        public int getCount() {
            return objects.size();
        }

        @Override
        public T getItem(int position) {
            return objects.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.list_item_simple, null);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
                viewHolder.textView = (TextView) convertView.findViewById(R.id.textView);

                convertView.setTag(viewHolder);
            }
            initializeViews((T) getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(T object, ViewHolder holder) {
            //TODO implement
            String str = (String) object;
            holder.textView.setText(str);
        }

        protected class ViewHolder {
            private ImageView imageView;
            private TextView textView;
        }
    }


}

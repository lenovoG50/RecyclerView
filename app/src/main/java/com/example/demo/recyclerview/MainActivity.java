package com.example.demo.recyclerview;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {



    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //适配器
            MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(MainActivity.this,data);
            mRecyclerView.setAdapter(myRecyclerViewAdapter);
        }
    };
    @BindView(R.id.mRecyclerView)
    public RecyclerView mRecyclerView;
    private List<JsonBean.ResultBean.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //请求数据
        initData();
        //绑定activity
        ButterKnife.bind(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

    }

    private void initData() {
        OkGo.get("http://v.juhe.cn/toutiao/index?type=top&key=b0c1a57febbe49da8940dc820c2d8e43")
                .tag(this).cacheKey("头条").execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                Gson gson = new Gson();
                JsonBean b = gson.fromJson(s, JsonBean.class);
                JsonBean.ResultBean result = b.getResult();
                data = result.getData();
                handler.sendEmptyMessage(0);
            }
        });
    }
}

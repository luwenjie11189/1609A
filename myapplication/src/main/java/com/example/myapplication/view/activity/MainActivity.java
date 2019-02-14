package com.example.myapplication.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.presenter.MainPresenter;
import com.example.myapplication.view.initface.iMainView;

public class MainActivity extends BaseAcitiviry implements iMainView {

    private String path = "http://apis.juhe.cn/cook/query?key=4a94fa92d40a6199e859ee6caf233225&menu=%E7%89%9B%E8%82%89%E5%8C%85%E5%AD%90";
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        loadDataFromNet();

    }

    private void initView() {
        //findView
    }

    private void initData() {
        mainPresenter = new MainPresenter();
        mainPresenter.setView(this);
    }

    private void loadDataFromNet() {
        mainPresenter.getHomeData(path);
    }

    @Override
    public void CallBackData(String data) {
        Log.e("myMessage",""+data);
    }
}

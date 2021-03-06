package com.bw.luwenjie0214;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @Auther: 努力
 * @Date: 2019/2/14 08:47:${卢文杰}
 * @Description:
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindlayout());
        initView();
        initData();
        bindEvent();
    }

    protected abstract int bindlayout();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void bindEvent();

    protected <T extends View> T bindView(int resId) {
        return (T) findViewById(resId);
    }

}

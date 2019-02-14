package com.example.myapplication.presenter;


import com.example.myapplication.model.utils.HttpUtils;
import com.example.myapplication.view.activity.MainActivity;
import com.example.myapplication.view.initface.iMainView;

/**
 * @Auther: 努力
 * @Date: 2019/2/14 15:54:${卢文杰}
 * @Description:
 */
public class MainPresenter extends BasePresenter {

    private HttpUtils httpUtils;
    private iMainView view;

    public MainPresenter() {
        httpUtils = httpUtils.getInstance();
    }

    public void getHomeData(final String url) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String data = httpUtils.getData(url);
                view.CallBackData(data);
            }
        }).start();

    }

    public void setView(iMainView view) {
        this.view = view;
    }
}

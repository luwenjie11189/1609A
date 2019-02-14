package com.bw.luwenjie0214;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends BaseActivity {

    private String path = "http://apis.juhe.cn/cook/query?key=4a94fa92d40a6199e859ee6caf233225&menu=%E7%89%9B%E8%82%89%E5%8C%85%E5%AD%90";

    @Override
    protected int bindlayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String data = getData();
                Log.e("myMessage", "" + data);
            }
        }).start();

    }

    private String getData() {
        //开启一个新连接
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int length = 0;
                while ((length = inputStream.read(bytes)) != -1) {
                    byteArrayOutputStream.write(bytes, 0, length);
                }
                String value = byteArrayOutputStream.toString();
                return value;
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void bindEvent() {

    }
}

package com.example.myapplication.model.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Auther: 努力
 * @Date: 2019/2/14 15:29:${卢文杰}
 * @Description:
 */
public class HttpUtils {

    private static HttpUtils httpUtils;

    private HttpUtils() {
    }

    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
            return httpUtils;
        } else {
            return httpUtils;
        }
    }

    public String getData(String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int length = 0;
                while ((length = inputStream.read(bytes)) != -1) {
                    byteArrayOutputStream.write(bytes, 0, length);
                    byteArrayOutputStream.flush();
                }
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String postData(String path, String post) {
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
            printWriter.write(post);
            printWriter.flush();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(connection.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = bufferedInputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, length);
                byteArrayOutputStream.flush();
            }
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toString("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

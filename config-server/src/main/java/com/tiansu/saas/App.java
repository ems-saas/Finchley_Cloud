package com.tiansu.saas;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@SpringBootApplication
@EnableConfigServer
public class App
{
    public static void main(String[] args) {
    SpringApplication.run(App.class, args);
    }

    @PostMapping("postRefresh")
    public void httpPostJSON() throws IOException {
        // 模拟 http 请求
    //    DefaultHttpClient httpClient = new DefaultHttpClient();
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = "http://localhost:9000/actuator/bus-refresh";
        HttpPost httpPost = new HttpPost(url);
        // 设置请求的header
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
    }
}

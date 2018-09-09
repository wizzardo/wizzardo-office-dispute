package com.example;

import com.wizzardo.http.HttpServer;
import com.wizzardo.http.request.Header;
import com.wizzardo.http.request.Parameters;

public class App {

    public static void main(String[] args) {
        HttpServer<?> application = new HttpServer(9090);
        application.getUrlMapping()
                .append("/", (request, response) -> {
                    Parameters params = request.params();
                    double a = Double.parseDouble(params.get("a", "1"));
                    double b = Double.parseDouble(params.get("b", "1"));
                    double result = a / b;
                    return response.body(String.valueOf(result))
                            .appendHeader(Header.KV_CONTENT_TYPE_TEXT_PLAIN);
                })
        ;
        application.start();
    }
}

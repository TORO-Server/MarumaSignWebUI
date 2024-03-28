package marumasa.maruma_sign_webui.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import marumasa.maruma_sign_webui.http.service.APIService;
import marumasa.maruma_sign_webui.http.service.WebUIService;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerEngine {

    public final HttpServer server;
    public final int port;

    public ServerEngine(int port) {
        this.port = port;
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        server.createContext("/", new Handler());
    }

    public static class Handler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // リクエストを処理する
            if ("POST".equals(exchange.getRequestMethod())) {
                APIService.Handle(exchange);
            } else {
                WebUIService.Handle(exchange);
            }
        }
    }
}

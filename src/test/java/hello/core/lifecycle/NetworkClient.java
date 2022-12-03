package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url: " + url);
        connect();
        call("초기연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @PostConstruct
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call, message: " + message);
    }

    @PreDestroy
    public void disconnect(){
        System.out.println("disconnected");
    }
}

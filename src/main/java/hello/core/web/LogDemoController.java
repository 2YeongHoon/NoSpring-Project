package hello.core.web;

import hello.core.common.MyLogger;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    // 이대로 사용하면 주입 시점이 달라 에러발생
//    private final MyLogger myLogger;
    private final ObjectProvider<MyLogger> myLoggerObjectProvider;


    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest servletRequest){
        String requestUrl = servletRequest.getRequestURL().toString();
        MyLogger myLogger = myLoggerObjectProvider.getObject();

        myLogger.setRequestUrl(requestUrl);

        myLogger.log("Controller Test");
        logDemoService.logic("testId");
        return "OK";
    }

}

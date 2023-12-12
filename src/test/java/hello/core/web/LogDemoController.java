package hello.core.web;


import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoController logDemoController;
    private final MyLogger myLogger;

    public LogDemoController(LogDemoController logDemoController, MyLogger myLogger) {
        this.logDemoController = logDemoController;
        this.myLogger = myLogger;
    }

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoController.logic("testId");
        
        return "OK";
    }

    private void logic(String testId) {
    }
}

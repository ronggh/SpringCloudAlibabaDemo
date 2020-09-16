package cn.alan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "===============> testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "===============> testB";
    }

    @GetMapping("/testD")
    public String testD() {
        // 暂停几秒钟线程
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("testD测试RT");
        return "===============> testD";
    }

    @GetMapping("/testC")
    public String testC() {
        System.out.println("testC测试异常比例");
        int age = 10 / 0;
        return "===============> testC";
    }

    /**
     * 如果不指定blockHandler，则触发热点限流时会显示ErrorPage错误页面
     * 
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
        @RequestParam(value = "p2", required = false) String p2) {
        return "===============> testHotKey";
    }

    public String dealTestHotKey(String p1, String p2, BlockException exception) {
        return "===============> dealTestHotKey ";
    }
}

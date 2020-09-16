package cn.alan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import cn.alan.entity.CommonResult;
import cn.alan.myhandler.MyBlockHandler;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按URL地址限流测试OK");
    }

    @GetMapping("/byCustomerBlockHandler")
    @SentinelResource(value = "byCustomerBlockHandler", blockHandlerClass = MyBlockHandler.class,
        blockHandler = "handlerException1")
    public CommonResult byCustomerBlockHandler() {
        return new CommonResult(200, "按自定义限流处理规则测试OK");
    }

    /**
     * 兜底的处理方法
     * 
     * @param exception
     * @return
     */
    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + " 服务不可用");
    }

}

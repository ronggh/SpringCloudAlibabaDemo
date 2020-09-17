package cn.alan.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

@RestController
public class CircleBreakerController {
    /**
     * 模拟数据
     */
    private static Map<Integer, String> data = new HashMap<>();
    static {
        data.put(1, "Serial:bf57f77f-441f-4e26-a406-6a426a73910c");
        data.put(2, "Serial:51d651ab-51e8-4a73-a46f-5cff3e3c08a1");
        data.put(3, "Serial:26f57e3b-85bf-4849-b450-c1ead1f8fe58");
    }

    /**
     * 不配置: 不指定fallback和blockHandler
     * 
     * @param id
     * @return
     */
    @GetMapping("/testNotAny/{id}")
    @SentinelResource(value = "testNotAny")
    public String testNotAny(@PathVariable Integer id) {
        return test(id);
    }

    /**
     * 仅有fallback <br/>
     * fallback只负责业务异常
     * 
     * @param id
     * @return
     */
    @GetMapping("/testOnlyFallback/{id}")
    @SentinelResource(value = "testOnlyFallback", fallback = "fallbackHandler")
    public String testOnlyFallback(@PathVariable Integer id) {
        return test(id);
    }

    /**
     * 兜底的fallback处理
     * 
     * @param id
     * @param e
     * @return
     */
    public String fallbackHandler(@PathVariable Integer id, Throwable e) {
        String result = "兜底的fallback处理，请求参数：" + id + "\t,异常信息：" + e.getMessage();
        return result;
    }

    /**
     * 仅有 blockHandler <br/>
     * blockHandler 只负责处理 Sentinel的流控规则
     * 
     * @param id
     * @return
     */
    @GetMapping("/testOnlyBlockHandler/{id}")
    @SentinelResource(value = "testOnlyBlockHandler", blockHandler = "myBlockHandler")
    public String testOnlyBlockHandler(@PathVariable Integer id) {
        return test(id);
    }

    public String myBlockHandler(@PathVariable Integer id, BlockException e) {
        return "Sentinel 限流：blockHandler 处理 ===> " + e.getMessage();
    }

    /**
     * fallback & blockHandler 都配置的情况
     * 
     * @param id
     * @return
     */
    @GetMapping("/testFallbackAndBlockHandler/{id}")
    @SentinelResource(value = "testFallbackAndBlockHandler", fallback = "fallbackHandler",
        blockHandler = "myBlockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
    public String testFallbackAndBlockHandler(@PathVariable Integer id) {
        return test(id);
    }

    /**
     * 共同的调用同一个测试方法
     * 
     * @param id
     * @return
     */
    private String test(Integer id) {
        String result = data.get(id);

        // 人为设置
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常！！");
        } else if (result == null) {
            throw new NullPointerException("空指针异常,没有该ID对应的数据！！");
        }

        return result;
    }
}

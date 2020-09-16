package cn.alan.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

import cn.alan.entity.CommonResult;

public class MyBlockHandler {
    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(444, "自定义的全局限流处理: handlerException1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "自定义的全局限流处理: handlerException2");
    }
}

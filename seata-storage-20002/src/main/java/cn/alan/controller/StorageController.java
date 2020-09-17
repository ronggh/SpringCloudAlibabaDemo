package cn.alan.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.alan.entity.CommonResult;
import cn.alan.service.IStorageService;

@RestController
public class StorageController {
    @Resource
    private IStorageService storageService;

    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功！");
    }
}

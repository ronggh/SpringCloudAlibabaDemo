package cn.alan.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.alan.entity.CommonResult;

@FeignClient(value = "seata-storage-service")
public interface IStorageService {
    /**
     * 请求方式要与seata-storage-20002中的StorageController一致
     * 
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}

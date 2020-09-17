package cn.alan.service;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.alan.entity.CommonResult;

@FeignClient(value = "seata-account-service")
public interface IAccountService {
    /**
     * 请求方式要与seata-account-20003中的AccountController一致
     * 
     * @param userId
     * @param money
     * @return
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}

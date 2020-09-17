package cn.alan.service;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.alan.entity.Account;

public interface IAccountService extends IService<Account> {
    // 扣减账户余额
    void decrease(Long userId, BigDecimal money);
}

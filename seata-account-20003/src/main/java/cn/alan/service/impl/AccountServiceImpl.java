package cn.alan.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.alan.dao.AccountDao;
import cn.alan.entity.Account;
import cn.alan.service.IAccountService;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements IAccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId, money);
    }
}

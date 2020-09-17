package cn.alan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.alan.dao.StorageDao;
import cn.alan.entity.Storage;
import cn.alan.service.IStorageService;

@Service
public class StorageServiceImpl extends ServiceImpl<StorageDao, Storage> implements IStorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId, count);
    }
}

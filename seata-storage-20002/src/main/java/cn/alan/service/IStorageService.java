package cn.alan.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.alan.entity.Storage;

public interface IStorageService extends IService<Storage> {
    /**
     * 扣减库存
     * 
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}

package cn.alan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.alan.entity.Storage;

@Mapper
public interface StorageDao extends BaseMapper<Storage> {
    /**
     * 扣减库存
     * 
     * @param productId
     * @param count
     */
    @Update("UPDATE storage_tbl SET used = used + #{count}, residue = residue - #{count} WHERE product_id = #{productId}")
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}

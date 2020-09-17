package cn.alan.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.alan.entity.Account;

@Mapper
public interface AccountDao extends BaseMapper<Account> {
    /**
     * 扣减账户余额
     * 
     * @param userId
     * @param money
     */
    @Update("UPDATE t_account SET residue = residue - #{money}, used = used + #{money}  WHERE user_id = #{userId}")
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}

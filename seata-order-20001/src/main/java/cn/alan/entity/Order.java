package cn.alan.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;

    /**
     * 订单状态,0：创建中；1：已完结
     */
    private Integer status;
}

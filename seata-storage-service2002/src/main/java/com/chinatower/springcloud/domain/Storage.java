package com.chinatower.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yunxl
 * @date 2020/4/10 16:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    /**
     * 产品ID
     */
    private Long id;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}

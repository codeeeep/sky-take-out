package com.sky.service;

import com.sky.dto.DishDTO;

/**
 * @author codeep
 * @date 2023/11/24 11:19
 * @description:
 */
public interface DishService {

    /**
     * 新增菜品和对应的口味
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);

}

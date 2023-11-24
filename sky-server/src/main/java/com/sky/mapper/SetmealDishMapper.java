package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author codeep
 * @date 2023/11/24 19:37
 * @description:
 */
@Mapper
public interface SetmealDishMapper {


    /**
     * 根据菜品 id 查询对应的套餐 id
     * @param dishIds
     * @return
     */
    // select setmeal_id from setmeal_dish where dish_id in (1,2,3,4)
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);
}

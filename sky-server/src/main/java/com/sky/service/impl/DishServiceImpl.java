package com.sky.service.impl;

import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author codeep
 * @date 2023/11/24 11:24
 * @description:
 */

@Service
@Slf4j
public class DishServiceImpl implements DishService {

    @Resource
    private DishMapper dishMapper;

    @Resource
    private DishFlavorMapper dishFlavorMapper;

    /**
     * 新增菜品和对应的口味
     * @param dishDTO
     */
    @Override
    public void saveWithFlavor(DishDTO dishDTO) {

        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);
        // 向菜品表插入 1 条数据
        dishMapper.insert(dish);

        // 获取 insert 语句生成的主键值
        Long dishId = dish.getId();

        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (flavors != null && flavors.size() > 0) {
            flavors.forEach((dishFlavor) -> {
                dishFlavor.setDishId(dishId);
            });
            // 向口味表插入 n 条数据
            dishFlavorMapper.insertBatch(flavors);
        }
    }
}

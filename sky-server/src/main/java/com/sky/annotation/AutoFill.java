package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author codeep
 * @date 2023/11/23 20:40
 * @description: 自定义注解，用于标识某个方法需要进行公共字段填充处理
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {

    // 指定数据库的操作类型：INSERT UPDATE
    OperationType value();

}

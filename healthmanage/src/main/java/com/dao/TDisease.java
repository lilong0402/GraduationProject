package com.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/17 15:53
 * @注释
 */

public interface TDisease {
 @Select("select disease_name as type from t_disease")
 List<String> selectall();
}

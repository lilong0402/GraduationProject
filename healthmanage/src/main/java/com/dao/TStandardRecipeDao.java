package com.dao;

import com.entity.TStandardRecipeEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/19 10:22
 * @注释
 */
public interface TStandardRecipeDao {

 @Select("select * from t_standard_recipe where scoreMin<=#{score}&&scoreMax>=#{score}")
 List<TStandardRecipeEntity> selectByscore(Double score);
}

package com.service;

import com.entity.TStandardRecipeEntity;

import java.util.List;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/19 10:26
 * @注释
 */
public interface TstandardReciptService {
 List<TStandardRecipeEntity> selectByscore(Double score);

}

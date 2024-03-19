package com.service.impl;

import com.dao.TStandardRecipeDao;
import com.entity.TStandardRecipeEntity;
import com.service.TstandardReciptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/19 10:26
 * @注释
 */
@Service
public class TStandardRecipeServiceImpl implements TstandardReciptService {
 @Resource
 private TStandardRecipeDao tStandardRecipeDao;
 @Override
 public List<TStandardRecipeEntity> selectByscore(Double score) {
  return tStandardRecipeDao.selectByscore(score);
 }
}

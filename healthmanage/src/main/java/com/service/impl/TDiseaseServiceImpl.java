package com.service.impl;

import com.dao.TDisease;
import com.service.TDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/17 15:57
 * @注释
 */
@Service
public class TDiseaseServiceImpl implements TDiseaseService {

 @Resource
 private  TDisease tDisease;
 @Override
 public List<String> selectAll() {

  return tDisease.selectall();
 }
}

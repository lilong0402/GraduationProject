package com.service;

import com.entity.healthaccessEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/17 19:11
 * @注释
 */
public interface healthaccessService {
 List<healthaccessEntity> selectByusername (String username);

 Double inserthealthaccess(healthaccessEntity healthaccessEntity);

 
package com.controller;

import com.service.TstandardReciptService;
import com.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/19 10:28
 * @注释
 */
@RestController
@RequestMapping("standard")
public class TStandardRecipeController {
 @Resource
 private TstandardReciptService service;

 @GetMapping("standardRecipe")
 public R selectByScore(Double score){
  return R.ok().put("standard",service.selectByscore(score));
 }
}

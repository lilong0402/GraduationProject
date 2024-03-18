package com.controller;

import com.service.TDiseaseService;
import com.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/17 15:59
 * @注释
 */
@RestController
@RequestMapping("/disease")
public class TDiseaseController {
 @Resource
 private TDiseaseService tDiseaseServicel;

 @GetMapping("/diseaseAll")
 public R diseaseAll(){
  return  R.ok().put("data",tDiseaseServicel.selectAll());
 }
}

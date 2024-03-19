package com.controller;

import com.entity.healthaccessEntity;
import com.service.healthaccessService;
import com.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/17 19:16
 * @注释
 */
@RestController
@RequestMapping("/healthaccess")
public class healthaccessController {
 @Resource
 private healthaccessService healthaccessService;

 @GetMapping("selectByUsername")
public R selectByUsername(String username){
 return R.ok().put("HealthData",healthaccessService.selectByusername(username));
}
@PostMapping("insertHealthAccess")
public  R insertHealthAccess(@RequestBody healthaccessEntity healthaccessEntity){
 Double score = healthaccessService.inserthealthaccess(healthaccessEntity);
 return R.ok().put("score",score);
}
@GetMapping("sbrscore")
public  R selectByUserNameReturnScore(String username){
  return R.ok().put("score",healthaccessService.selectByUserNameReturnScore(username));
}

}

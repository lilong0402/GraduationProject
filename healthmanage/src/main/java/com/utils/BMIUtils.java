package com.utils;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/18 9:44
 * @注释
 */
public class BMIUtils {
 public  static Double countBMI(Double height,Double weight){
  height=height/100;
  return weight/(height*height);
 }
}

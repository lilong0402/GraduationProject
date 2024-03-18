package com.entity;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/17 18:53
 * @注释
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class healthaccessEntity {
 private Integer id;
 private String username;
 private Double height;
 private Double weight;
 private Integer age;
 private Integer heartrate1;
 private Integer heartrate2;
 private String typename;
 private Integer pushUp;
 private Integer pullUp;
 private Integer siteUp;
 private Double rate;
 private Double bloodGlucose;
 private Integer sleep;
 private Integer stepNumber;
 private Double score;
 private DateTime testTime;

}

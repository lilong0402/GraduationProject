package com.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/19 10:17
 * @注释
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TStandardRecipeEntity {
 private  Integer id ;
 private  String name;
 private  String sportsTime;
 private String sportsFrequency;
 private String tabooDiseaseId;
 private Double scoreMin;
 private Double scoreMax;
 private Integer reviewCycle;
 private String videoUrl;
 private String notice;
 private Date InsertTime;
}

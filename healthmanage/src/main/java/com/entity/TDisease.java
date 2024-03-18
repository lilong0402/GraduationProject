package com.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/17 15:50
 * @注释
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TDisease {
    private Integer id;
    private String DiseaseName;
    private String description;
}

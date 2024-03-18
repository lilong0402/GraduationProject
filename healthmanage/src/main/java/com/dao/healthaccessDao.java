package com.dao;

import com.entity.healthaccessEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/17 18:58
 * @注释
 */
public interface healthaccessDao {
 /**
  * 根据账号查询
  */
 @Select("select * from healthaccess where username=#{username}")
   List<healthaccessEntity> selectByusername(String username);

    /**
     * 查询最近一次记录的成绩
     * @param username
     * @return
     */
 @Select("select score from healthaccess where username=#{username} and testTime<NOW() ORDER BY testTime DESC LIMIT 1 ")
 Double selectByUserNameReturnScore(String username);
    /**
     * 插入数据
     */
    @Insert("insert into healthaccess (username,height,weight,age,heartrate1,heartrate2,typename,pushUp,pullUp,siteUp,rate,bloodGlucose,sleep,stepNumber,score,testTime) " +
            "values (#{username},#{height},#{weight},#{age},#{heartrate1},#{heartrate2},#{typename},#{pushUp},#{pullUp},#{siteUp},#{rate},#{bloodGlucose},#{sleep},#{stepNumber},#{score},NOW())")
    int inserthealthaccess(String username,Double height,Double weight,Integer age,Integer heartrate1,Integer heartrate2,String typename,Integer pushUp,Integer pullUp,Integer siteUp,Double rate,Double bloodGlucose,Integer sleep,Integer stepNumber,Double score);


}

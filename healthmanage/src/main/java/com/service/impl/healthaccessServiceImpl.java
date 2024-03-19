package com.service.impl;

import com.dao.YonghuDao;
import com.dao.healthaccessDao;
import com.entity.healthaccessEntity;
import com.service.YonghuService;
import com.service.healthaccessService;
import com.utils.BMIUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2024/3/17 19:13
 * @注释
 */
@Service
public class healthaccessServiceImpl implements healthaccessService {

 @Resource
 private healthaccessDao healthaccessDao;

 @Resource
 private YonghuDao yonghuDao;


 @Override
 public List<healthaccessEntity> selectByusername(String username) {
  return healthaccessDao.selectByusername(username);
 }

 @Override
 public Double inserthealthaccess(healthaccessEntity healthaccessEntity) {
  Double score = sumScore(healthaccessEntity);
  DecimalFormat decimalFormat = new DecimalFormat("#.00");
  score=  Double.parseDouble(decimalFormat.format(score));
  healthaccessDao.inserthealthaccess(healthaccessEntity.getUsername(),
           healthaccessEntity.getHeight(), healthaccessEntity.getWeight(),
           healthaccessEntity.getAge(), healthaccessEntity.getHeartrate1(),
           healthaccessEntity.getHeartrate2(), healthaccessEntity.getTypename(),
           healthaccessEntity.getPushUp(), healthaccessEntity.getPullUp(),
           healthaccessEntity.getSiteUp(), healthaccessEntity.getRate(),
           healthaccessEntity.getBloodGlucose(), healthaccessEntity.getSleep(),
           healthaccessEntity.getStepNumber(),score);
   return score;


 }

 @Override
 public Double selectByUserNameReturnScore(String username) {
  if (healthaccessDao.selectByUserNameReturnScore(username) == null) return 0.0;
  else return healthaccessDao.selectByUserNameReturnScore(username);
 }

 private  Double sumScore(healthaccessEntity healthaccessEntity){
  Double score=0.0;
  score=pushUpScore(healthaccessEntity.getPushUp())+pullUpScore(healthaccessEntity.getPullUp())
          +siteUpScore(healthaccessEntity.getSiteUp())+rateScore(healthaccessEntity.getRate())
          +sleepScore(healthaccessEntity.getSleep())+stepNumberScore(healthaccessEntity.getStepNumber())
          +bloodGlucose(healthaccessEntity.getBloodGlucose())+BMIScore(healthaccessEntity.getHeight(),healthaccessEntity.getWeight())
          +ageScore(healthaccessEntity.getAge())+heartScore(healthaccessEntity.getHeartrate1(),healthaccessEntity.getHeartrate2())
          +diseaseScore(healthaccessEntity.getTypename());
  //用于统计有几个属性是空的
  int emptyCount = -2;
  //调取所有对象字段
  Field[] fields = healthaccessEntity.getClass().getDeclaredFields();
  for (Field field : fields){
   field.setAccessible(true);//设置字段可以访问
   try {
    if (field.get(healthaccessEntity) == null){
     emptyCount++;
    }
   } catch (IllegalAccessException e) {
    throw new RuntimeException(e);
   }
  }
  if (healthaccessEntity.getTypename()==null){
   emptyCount--;
  }
  score=score-emptyCount;
  //计算已输入数据的分数
  score = score/(100.0-emptyCount*10) * 100;
  return score;
 }
 /**
  * 俯卧撑数打分
  */
 private  Double pushUpScore(Integer pushUpNumber){
  if (pushUpNumber==null){return 0.0;}
  //满分50
  int maxPushUps = 40;
  double score = 0.0;
  double pushUp =pushUpNumber;
  if (pushUpNumber>maxPushUps)  {score+=10;}
  else if (pushUpNumber>0&& pushUpNumber<50){
   score = (pushUp/maxPushUps) *10.0;
  }
  return score;

 }
 /**
  * 引体向上打分
  */
 private Double pullUpScore(Integer pullUpNumber){
  /**
   * 满分15
   */
  if (pullUpNumber==null) {return 0.0;}
  int maxPullUps = 15;
  Double score = 0.0;
  double pullUp=pullUpNumber;
  if (pullUpNumber>maxPullUps) {
   score =10.0;
  }else if (pullUpNumber>0&&pullUpNumber<15){
   score = (pullUp/maxPullUps) * 10.0;
  }
  return score;
 }
/**
 * 仰卧起坐打分
 */
private Double siteUpScore(Integer siteUpNumber){
 //满分
 if (siteUpNumber==null){return  0.0;}
 int maxSiteUpScore = 56;
 Double score= 0.0;
 double siteUp=siteUpNumber;
 if (siteUpNumber > maxSiteUpScore) {
  score = 10.0;
 }else if (siteUpNumber>0&&siteUpNumber<maxSiteUpScore){
  score = (siteUp/maxSiteUpScore) *10.0;
 }
 return score;
}

 /**
  * 1公里配速打分
  * @param rateNumber
  * @return
  */
 private Double rateScore(Double rateNumber){
  if (rateNumber==null){return 0.0;}
  int maxrate =3;
  Double  score = 0.0;
  if (rateNumber<3.0&&rateNumber>0) {
   score =10.0;
  }else if (rateNumber>=3.0&& rateNumber<=15.0){
   score = 10*((12-(rateNumber-maxrate))/12.0);
  }
  return score;
}

 /**
  * 睡眠打分
  * @param sleepNumber
  * @return
  */
 private Double sleepScore(Integer sleepNumber){
  if (sleepNumber==null){return 0.0;}
  Double score=0.0;
  if (sleepNumber>=6&&sleepNumber<=10){
   score = 10.0;
  }else  if (sleepNumber<6&&sleepNumber>0){
   score = (sleepNumber/6.0)*10;
  }else if (sleepNumber>10&&sleepNumber<24){
   score = ((24.0-sleepNumber)/14.0)*10;
  }
  return score;
}

 /**
  * 每周平均步数打分
  * @param stepNumber
  * @return
  */
 private Double stepNumberScore(Integer stepNumber){
  if (stepNumber==null) {return  0.0;}
  Double score = 0.0;
  //每天最好走1000步
  Double stepadvice = 10000.0;
  if(stepNumber>stepadvice){score +=10;}
  else if(stepNumber<stepadvice&&stepNumber>0){
   score = (stepNumber/stepadvice) * 10;
  }
  return score;

}

/**
 * 血糖打分
 */
private Double bloodGlucose(Double bloodGlucoseNumber){
 if (bloodGlucoseNumber==null){return 0.0;}
 if (bloodGlucoseNumber>=3.9&&bloodGlucoseNumber<=6.0){
  return 10.0;
 }
 else  if (bloodGlucoseNumber<3.9&& bloodGlucoseNumber>0){
  return (bloodGlucoseNumber/3.9) * 10;
 }else if (bloodGlucoseNumber>6.0&&bloodGlucoseNumber<10.0){
  return 10.0-bloodGlucoseNumber;
 }
 return 0.0;
}
 /**计算BMI得分*/
 private Double BMIScore(Double height,Double weight) {
  Double bmi = BMIUtils.countBMI(height,weight);
  if (bmi >= 18.5 && bmi <= 24.9) {
   return 10.0;
  } else if (bmi > 24.9 && bmi <= 29.9) {
   return (bmi+5)%10;
  } else {
   return 0.0;
  }
 }
 /**
  * 年龄打分
  */
 private   Double ageScore(Integer age){
  if (age>=16&&age<=50){
   return 10.0;
  }else if(age<16){
   return age/2.0;
  }else if(age>50&&age<90){
   Double score=10.0;
   for (int i = 0; i < age; i++) {
    score -= 0.1;
   }
   return score;
  }else  {
   return 0.0;
  }
 }
 /**
  * 心率打分
  */
 private  Double heartScore(Integer heart1,Integer heart2){

  Double score = 0.0;
  if (heart1 != null) {
   if (heart1 >= 60 && heart1 <= 90) {
    score += 5;
   } else if (heart1 > 40 && heart1 < 60) {
    score += heart1 / 10.0;
   } else if (heart1 > 90 && heart1 < 140) {
    score += (200.0 - heart1) % 10.0 - 6.0;
   }
  }
  if (heart2!=null) {
   if (heart2 >= 60 && heart2 <= 90) {
    score += 5;
   } else if (heart2 > 40 && heart2 < 60) {
    score += heart2 / 10.0;
   } else if (heart2 > 90 && heart2 < 140) {
    score += (200.0 - heart2) % 10.0 - 6.0;
   }
  }
  return score;
 }

 /**
  * 基础疾病减分
  * @param disease
  * @return
  */
 private Double diseaseScore(String disease){
  if (disease==null){return 0.0;}
  Double score = 0.0;
  String []diseases = disease.split(",");
  for (String diseasea:diseases) {
   if (diseasea.equals("无")){return 0.0;}
   if (diseasea.contains("心")||diseasea.contains("炎")){
    score -=10.0;
   }else if (diseasea.contains("病")){
    score -=8.0;
   }else {
    score -=5.0;
   }
  }
  return score;
 }
}
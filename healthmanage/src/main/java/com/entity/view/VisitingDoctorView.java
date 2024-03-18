package com.entity.view;

import com.entity.VisitingDoctorEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 出诊医生
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-11 10:03:34
 */
@TableName("VisitingDoctor")
public class VisitingDoctorView  extends VisitingDoctorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public VisitingDoctorView(){
	}
 
 	public VisitingDoctorView(VisitingDoctorEntity VisitingDoctorEntity){
 	try {
			BeanUtils.copyProperties(this, VisitingDoctorEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

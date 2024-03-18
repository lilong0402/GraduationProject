package com.entity.view;

import com.entity.YuyueguahaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 预约挂号
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-11 10:03:34
 */
@TableName("yuyueguahao")
public class YuyueguahaoView  extends YuyueguahaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuyueguahaoView(){
	}
 
 	public YuyueguahaoView(YuyueguahaoEntity yuyueguahaoEntity){
 	try {
			BeanUtils.copyProperties(this, yuyueguahaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

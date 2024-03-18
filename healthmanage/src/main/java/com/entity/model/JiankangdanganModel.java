package com.entity.model;

import com.entity.JiankangdanganEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 健康档案
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-03-11 10:03:34
 */
public class JiankangdanganModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 诊断内容
	 */
	
	private String zhenduanneirong;
		
	/**
	 * 诊断结果
	 */
	
	private String zhenduanjieguo;
		
	/**
	 * 用药意见
	 */
	
	private String yongyaoyijian;
		
	/**
	 * 病历描述
	 */
	
	private String binglimiaoshu;
		
	/**
	 * 注意事项
	 */
	
	private String zhuyishixiang;
		
	/**
	 * 体检报名
	 */
	
	private String tijianbaoming;
		
	/**
	 * 就诊时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jiuzhenshijian;
		
	/**
	 * 医生账号
	 */
	
	private String yishengzhanghao;
		
	/**
	 * 医生姓名
	 */
	
	private String yishengxingming;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：诊断内容
	 */
	 
	public void setZhenduanneirong(String zhenduanneirong) {
		this.zhenduanneirong = zhenduanneirong;
	}
	
	/**
	 * 获取：诊断内容
	 */
	public String getZhenduanneirong() {
		return zhenduanneirong;
	}
				
	
	/**
	 * 设置：诊断结果
	 */
	 
	public void setZhenduanjieguo(String zhenduanjieguo) {
		this.zhenduanjieguo = zhenduanjieguo;
	}
	
	/**
	 * 获取：诊断结果
	 */
	public String getZhenduanjieguo() {
		return zhenduanjieguo;
	}
				
	
	/**
	 * 设置：用药意见
	 */
	 
	public void setYongyaoyijian(String yongyaoyijian) {
		this.yongyaoyijian = yongyaoyijian;
	}
	
	/**
	 * 获取：用药意见
	 */
	public String getYongyaoyijian() {
		return yongyaoyijian;
	}
				
	
	/**
	 * 设置：病历描述
	 */
	 
	public void setBinglimiaoshu(String binglimiaoshu) {
		this.binglimiaoshu = binglimiaoshu;
	}
	
	/**
	 * 获取：病历描述
	 */
	public String getBinglimiaoshu() {
		return binglimiaoshu;
	}
				
	
	/**
	 * 设置：注意事项
	 */
	 
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	
	/**
	 * 获取：注意事项
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
	}
				
	
	/**
	 * 设置：体检报名
	 */
	 
	public void setTijianbaoming(String tijianbaoming) {
		this.tijianbaoming = tijianbaoming;
	}
	
	/**
	 * 获取：体检报名
	 */
	public String getTijianbaoming() {
		return tijianbaoming;
	}
				
	
	/**
	 * 设置：就诊时间
	 */
	 
	public void setJiuzhenshijian(Date jiuzhenshijian) {
		this.jiuzhenshijian = jiuzhenshijian;
	}
	
	/**
	 * 获取：就诊时间
	 */
	public Date getJiuzhenshijian() {
		return jiuzhenshijian;
	}
				
	
	/**
	 * 设置：医生账号
	 */
	 
	public void setYishengzhanghao(String yishengzhanghao) {
		this.yishengzhanghao = yishengzhanghao;
	}
	
	/**
	 * 获取：医生账号
	 */
	public String getYishengzhanghao() {
		return yishengzhanghao;
	}
				
	
	/**
	 * 设置：医生姓名
	 */
	 
	public void setYishengxingming(String yishengxingming) {
		this.yishengxingming = yishengxingming;
	}
	
	/**
	 * 获取：医生姓名
	 */
	public String getYishengxingming() {
		return yishengxingming;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}

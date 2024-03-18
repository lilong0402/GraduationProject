package com.dao;

import com.entity.VisitingDoctorEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.VisitingDoctorVO;
import com.entity.view.VisitingDoctorView;


/**
 * 出诊医生
 * 
 * @author 
 * @email 
 * @date 2023-03-11 10:03:34
 */
public interface VisitingDoctorDao extends BaseMapper<VisitingDoctorEntity> {
	
	List<VisitingDoctorVO> selectListVO(@Param("ew") Wrapper<VisitingDoctorEntity> wrapper);
	
	VisitingDoctorVO selectVO(@Param("ew") Wrapper<VisitingDoctorEntity> wrapper);
	
	List<VisitingDoctorView> selectListView(@Param("ew") Wrapper<VisitingDoctorEntity> wrapper);

	List<VisitingDoctorView> selectListView(Pagination page,@Param("ew") Wrapper<VisitingDoctorEntity> wrapper);
	
	VisitingDoctorView selectView(@Param("ew") Wrapper<VisitingDoctorEntity> wrapper);
	

}

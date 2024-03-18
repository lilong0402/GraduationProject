package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.VisitingDoctorEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.VisitingDoctorVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.VisitingDoctorView;


/**
 * 出诊医生
 *
 * @author 
 * @email 
 * @date 2023-03-11 10:03:34
 */
public interface VisitingDoctorService extends IService<VisitingDoctorEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<VisitingDoctorVO> selectListVO(Wrapper<VisitingDoctorEntity> wrapper);
   	
   	VisitingDoctorVO selectVO(@Param("ew") Wrapper<VisitingDoctorEntity> wrapper);
   	
   	List<VisitingDoctorView> selectListView(Wrapper<VisitingDoctorEntity> wrapper);
   	
   	VisitingDoctorView selectView(@Param("ew") Wrapper<VisitingDoctorEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<VisitingDoctorEntity> wrapper);
   	

}


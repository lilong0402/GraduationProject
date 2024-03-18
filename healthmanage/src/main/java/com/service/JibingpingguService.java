package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JibingpingguEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JibingpingguVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JibingpingguView;


/**
 * 疾病评估
 *
 * @author 
 * @email 
 * @date 2023-03-11 10:03:34
 */
public interface JibingpingguService extends IService<JibingpingguEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JibingpingguVO> selectListVO(Wrapper<JibingpingguEntity> wrapper);
   	
   	JibingpingguVO selectVO(@Param("ew") Wrapper<JibingpingguEntity> wrapper);
   	
   	List<JibingpingguView> selectListView(Wrapper<JibingpingguEntity> wrapper);
   	
   	JibingpingguView selectView(@Param("ew") Wrapper<JibingpingguEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JibingpingguEntity> wrapper);
   	

}


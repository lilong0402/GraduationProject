package com.dao;

import com.entity.JibingpingguEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JibingpingguVO;
import com.entity.view.JibingpingguView;


/**
 * 疾病评估
 * 
 * @author 
 * @email 
 * @date 2023-03-11 10:03:34
 */
public interface JibingpingguDao extends BaseMapper<JibingpingguEntity> {
	
	List<JibingpingguVO> selectListVO(@Param("ew") Wrapper<JibingpingguEntity> wrapper);
	
	JibingpingguVO selectVO(@Param("ew") Wrapper<JibingpingguEntity> wrapper);
	
	List<JibingpingguView> selectListView(@Param("ew") Wrapper<JibingpingguEntity> wrapper);

	List<JibingpingguView> selectListView(Pagination page,@Param("ew") Wrapper<JibingpingguEntity> wrapper);
	
	JibingpingguView selectView(@Param("ew") Wrapper<JibingpingguEntity> wrapper);
	

}

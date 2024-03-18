package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JibingpingguDao;
import com.entity.JibingpingguEntity;
import com.service.JibingpingguService;
import com.entity.vo.JibingpingguVO;
import com.entity.view.JibingpingguView;

@Service("jibingpingguService")
public class JibingpingguServiceImpl extends ServiceImpl<JibingpingguDao, JibingpingguEntity> implements JibingpingguService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JibingpingguEntity> page = this.selectPage(
                new Query<JibingpingguEntity>(params).getPage(),
                new EntityWrapper<JibingpingguEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JibingpingguEntity> wrapper) {
		  Page<JibingpingguView> page =new Query<JibingpingguView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JibingpingguVO> selectListVO(Wrapper<JibingpingguEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JibingpingguVO selectVO(Wrapper<JibingpingguEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JibingpingguView> selectListView(Wrapper<JibingpingguEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JibingpingguView selectView(Wrapper<JibingpingguEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

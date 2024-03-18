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


import com.dao.VisitingDoctorDao;
import com.entity.VisitingDoctorEntity;
import com.service.VisitingDoctorService;
import com.entity.vo.VisitingDoctorVO;
import com.entity.view.VisitingDoctorView;

@Service("VisitingDoctorService")
public class VisitingDoctorServiceImpl extends ServiceImpl<VisitingDoctorDao, VisitingDoctorEntity> implements VisitingDoctorService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<VisitingDoctorEntity> page = this.selectPage(
                new Query<VisitingDoctorEntity>(params).getPage(),
                new EntityWrapper<VisitingDoctorEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<VisitingDoctorEntity> wrapper) {
		  Page<VisitingDoctorView> page =new Query<VisitingDoctorView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<VisitingDoctorVO> selectListVO(Wrapper<VisitingDoctorEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public VisitingDoctorVO selectVO(Wrapper<VisitingDoctorEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<VisitingDoctorView> selectListView(Wrapper<VisitingDoctorEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public VisitingDoctorView selectView(Wrapper<VisitingDoctorEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

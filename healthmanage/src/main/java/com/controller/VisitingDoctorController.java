package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.VisitingDoctorEntity;
import com.entity.view.VisitingDoctorView;

import com.service.VisitingDoctorService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 出诊医生
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-11 10:03:34
 */
@RestController
@RequestMapping("/VisitingDoctor")
public class VisitingDoctorController {
    @Autowired
    private VisitingDoctorService VisitingDoctorService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,VisitingDoctorEntity VisitingDoctor,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date chuzhenriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date chuzhenriqiend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			VisitingDoctor.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<VisitingDoctorEntity> ew = new EntityWrapper<VisitingDoctorEntity>();
                if(chuzhenriqistart!=null) ew.ge("chuzhenriqi", chuzhenriqistart);
                if(chuzhenriqiend!=null) ew.le("chuzhenriqi", chuzhenriqiend);

		PageUtils page = VisitingDoctorService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, VisitingDoctor), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,VisitingDoctorEntity VisitingDoctor, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date chuzhenriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date chuzhenriqiend,
		HttpServletRequest request){
        EntityWrapper<VisitingDoctorEntity> ew = new EntityWrapper<VisitingDoctorEntity>();
                if(chuzhenriqistart!=null) ew.ge("chuzhenriqi", chuzhenriqistart);
                if(chuzhenriqiend!=null) ew.le("chuzhenriqi", chuzhenriqiend);

		PageUtils page = VisitingDoctorService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, VisitingDoctor), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( VisitingDoctorEntity VisitingDoctor){
       	EntityWrapper<VisitingDoctorEntity> ew = new EntityWrapper<VisitingDoctorEntity>();
      	ew.allEq(MPUtil.allEQMapPre( VisitingDoctor, "VisitingDoctor")); 
        return R.ok().put("data", VisitingDoctorService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(VisitingDoctorEntity VisitingDoctor){
        EntityWrapper< VisitingDoctorEntity> ew = new EntityWrapper< VisitingDoctorEntity>();
 		ew.allEq(MPUtil.allEQMapPre( VisitingDoctor, "VisitingDoctor")); 
		VisitingDoctorView VisitingDoctorView =  VisitingDoctorService.selectView(ew);
		return R.ok("查询出诊医生成功").put("data", VisitingDoctorView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        VisitingDoctorEntity VisitingDoctor = VisitingDoctorService.selectById(id);
        return R.ok().put("data", VisitingDoctor);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        VisitingDoctorEntity VisitingDoctor = VisitingDoctorService.selectById(id);
        return R.ok().put("data", VisitingDoctor);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody VisitingDoctorEntity VisitingDoctor, HttpServletRequest request){
    	VisitingDoctor.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(VisitingDoctor);
        VisitingDoctorService.insert(VisitingDoctor);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody VisitingDoctorEntity VisitingDoctor, HttpServletRequest request){
    	VisitingDoctor.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(VisitingDoctor);
        VisitingDoctorService.insert(VisitingDoctor);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody VisitingDoctorEntity VisitingDoctor, HttpServletRequest request){
        //ValidatorUtils.validateEntity(VisitingDoctor);
        VisitingDoctorService.updateById(VisitingDoctor);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        VisitingDoctorService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<VisitingDoctorEntity> wrapper = new EntityWrapper<VisitingDoctorEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			wrapper.eq("yishengzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = VisitingDoctorService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}

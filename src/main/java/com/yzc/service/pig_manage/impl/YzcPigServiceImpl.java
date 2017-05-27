package com.yzc.service.pig_manage.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.dao.YzcPigMapper;
import com.common.entity.YzcPig;
import com.yzc.dao.pig_manage.YzcPigDao;
import com.yzc.service.pig_manage.YzcPigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/18.
 */
@Service
public class YzcPigServiceImpl extends ServiceImpl<YzcPigMapper , YzcPig> implements YzcPigService {
    @Autowired
    private YzcPigDao pigDao;

    @Override
    public Page<Map<String, Object>> getPigPageByParams(Page<Map<String, Object>> page , String startDate , String endDate , String ear_num , String pig_sex , Integer var_id) {
        page.setRecords(pigDao.getPigListByParams(page,startDate,endDate,ear_num,pig_sex,var_id));
        return page;
    }

    @Override
    public Page<Map<String, Object>> getSeedPigPage(Page<Map<String, Object>> page) {
        page.setRecords(pigDao.getSeedPigList(page));
        return page;
    }

    @Override
    public boolean validateEar(String ear_num) {
        boolean bool = true;
        List<YzcPig> pigList = selectList(new EntityWrapper<YzcPig>().eq("pig_ear_num",ear_num));
        if(pigList != null && pigList.size() > 0){
            bool = false;
        }
        return bool;
    }

    @Override
    public Map<String, Object> getPigById(int pig_id , String pig_sex) {
        return pigDao.getPigById(pig_id,pig_sex);
    }

    @Override
    public boolean delPigById(int pig_id) {
        YzcPig pig = selectById(pig_id);
        pig.setPig_is_dead(0);
        pig.setPig_out_time(new Date());
        return updateById(pig);
    }

    @Override
    public List<YzcPig> getPigList(String pig_sex) {
        List<YzcPig> pigList = null;
        if (pig_sex == null || "".equals(pig_sex)){
            pigList = selectList(new EntityWrapper<YzcPig>().eq("pig_is_dead",1));
        }else {
            pigList = selectList(new EntityWrapper<YzcPig>().eq("pig_sex",pig_sex).eq("pig_is_dead",1));
        }
        return pigList;
    }
}

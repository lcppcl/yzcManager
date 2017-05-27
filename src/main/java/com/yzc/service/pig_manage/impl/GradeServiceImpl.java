package com.yzc.service.pig_manage.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.dao.YzcClassMapper;
import com.common.dao.YzcGradeMapper;
import com.common.entity.YzcClass;
import com.common.entity.YzcGrade;
import com.yzc.dao.pig_manage.GradeDao;
import com.yzc.service.pig_manage.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/24.
 */
@Service
public class GradeServiceImpl extends ServiceImpl<YzcGradeMapper , YzcGrade> implements GradeService {
    @Autowired
    private GradeDao gradeDao;
    @Autowired
    private YzcClassMapper classMapper;

    @Override
    public Page<Map<String, Object>> getGradePage(Page<Map<String, Object>> page,String emp_name,String gra_name) {
        page.setRecords(gradeDao.getGradeList(page,emp_name,gra_name));
        return page;
    }

    @Override
    public Map<String, Object> getGradeInfo(int gra_id) {
        return gradeDao.getGradeInfo(gra_id);
    }

    @Override
    public boolean deleteGrade(int gra_id) {
        classMapper.delete(new EntityWrapper<YzcClass>().eq("cla_gra_id",gra_id));
        return deleteById(gra_id);
    }
}

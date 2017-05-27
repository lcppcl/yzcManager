package com.yzc.service.pig_manage.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.dao.YzcClassMapper;
import com.common.entity.YzcClass;
import com.yzc.dao.pig_manage.ClassesDao;
import com.yzc.service.pig_manage.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/24.
 */
@Service
public class ClassesServiceImpl extends ServiceImpl<YzcClassMapper , YzcClass> implements ClassesService {

    @Autowired
    private ClassesDao classesDao;

    @Override
    public Page<Map<String, Object>> getPageClass(Page<Map<String, Object>> page , String m_name , String cla_name , Integer gra_id) {
        page.setRecords(classesDao.getClassesList(page,m_name , cla_name , gra_id));
        return page;
    }

    @Override
    public Map<String, Object> getClassInfo(int id, String c_name) {
        return classesDao.getClassInfo(id,c_name);
    }

}

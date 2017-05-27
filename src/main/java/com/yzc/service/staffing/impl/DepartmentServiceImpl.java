package com.yzc.service.staffing.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.dao.YzcDepartmentMapper;
import com.common.entity.YzcDepartment;
import com.yzc.dao.staffing.DepartmentDao;
import com.yzc.service.staffing.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/17.
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<YzcDepartmentMapper , YzcDepartment> implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Page<Map<String, Object>> getDepartmentPage(Page<Map<String, Object>> page) {
        page.setRecords(departmentDao.getDepartmentListByPage(page));
        return page;
    }

    @Override
    public int deleteDeptById(int id) {
        int result = 0;
        YzcDepartment department = selectById(id);
        if(id != 1 && id != 2 && id != 3 && id != 4 && id != 5 && id != 6){
            if(department.getDept_pare_id() != -1){
                List<YzcDepartment> list = selectList(new EntityWrapper<YzcDepartment>().eq("dept_pare_id",department.getDept_id()));
                if(list != null && list.size() > 0){
                    for (YzcDepartment dept : list){
                        dept.setDept_state(0);
                        updateById(dept);
                    }
                }
            }
            department.setDept_state(0);
            boolean bool = updateById(department);
            if(bool){
                result = 1;
            }else {
                result = -1;
            }
        }else {
            result = -2;
        }
        return result;
    }
}

package com.yzc.service.staffing.impl;

import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.entity.YzcEmployee;
import com.common.dao.YzcEmployeeMapper;
import com.yzc.dao.staffing.EmployeeDao;
import com.yzc.service.staffing.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/16.
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<YzcEmployeeMapper , YzcEmployee> implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Page<Map<String, Object>> getEmployeePage(Page<Map<String, Object>> page, String content , Integer dept_id) {
        page.setRecords(employeeDao.getEmployeeList(page,content,dept_id));
        return page;
    }

    @Override
    public boolean batchUpdataToAdmin(List<Integer> ids) {
        boolean bool = false;
        for(Integer id : ids){
            YzcEmployee employee = selectById(id);
            employee.setEmp_manager(1);
            bool = updateById(employee);
        }
        return bool;
    }

    @Override
    public Map<String, Object> getEmployeeById(int emp_id) {
        return employeeDao.getEmployeeById(emp_id);
    }
}

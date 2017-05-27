package com.yzc.service.staffing;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.YzcEmployee;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/16.
 */
public interface EmployeeService extends IService<YzcEmployee> {


    /**
     * 分页查询(员工信息查询)
     */
    Page<Map<String, Object>> getEmployeePage(Page<Map<String, Object>> page , String content , Integer dept_id);

    /**
     * 批量提升管理员权限
     */
    boolean batchUpdataToAdmin(List<Integer> ids);

    /**
     * 通过员工id查询
     */
    Map<String, Object> getEmployeeById(int emp_id);

}

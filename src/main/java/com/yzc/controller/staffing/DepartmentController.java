package com.yzc.controller.staffing;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcDepartment;
import com.common.result.ResultInfo;
import com.yzc.service.staffing.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/17.
 */
@RestController
@RequestMapping("/staffing/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取部门分页
     */
    @RequestMapping("/getDepartmentPage")
    public Page<Map<String , Object>> getDepartmentPage(int current , int size){
        Page<Map<String , Object>> page = new Page<>(current,size);
        departmentService.getDepartmentPage(page);
        return page;
    }

    /**
     * 获取部门列表
     */
    @RequestMapping("/getDepartmentList")
    public List<YzcDepartment> getDepartmentList(Integer pid){
        List<YzcDepartment> departmentList = null;
        if(pid != null && pid != 0){
            departmentList = departmentService.selectList(new EntityWrapper<YzcDepartment>().eq("dept_pare_id",pid).eq("dept_state",1));
        }else {
            departmentList = departmentService.selectList(new EntityWrapper<YzcDepartment>().eq("dept_state",1).notIn("dept_id",6));
        }
        return departmentList;
    }

    /**
     * 根据部门id查询部门的信息
     */
    @RequestMapping("/getDeptById")
    public YzcDepartment getDeptById(int id){
        return departmentService.selectById(id);
    }

    /**
     * 新增或修改部门信息
     */
    @RequestMapping("/insertOrUpdateDept")
    public boolean insertOrUpdateDept(YzcDepartment department){
        return departmentService.insertOrUpdate(department);
    }

    /**
     * 删除部门信息
     */
    @RequestMapping("/deleteDeptById")
    public int deleteDeptById(int id){
        return departmentService.deleteDeptById(id);
    }
}

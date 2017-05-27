package com.yzc.controller.staffing;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcEmployee;
import com.common.result.ResultInfo;
import com.common.utils.MD5;
import com.yzc.service.staffing.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by wangfujie on 2017/4/17.
 */
@RestController
@RequestMapping("/staffing/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 分页显示用户
     */
    @RequestMapping("/getEmployeePage")
    public Page<Map<String, Object>> getEmployeePage(int current , int size , String content , Integer dept_id){
        Page<Map<String, Object>> page = new Page<>(current,size);
        employeeService.getEmployeePage(page,content,dept_id);
        return page;
    }

    /**
     * 禁用 / 启用员工账号
     */
    @RequestMapping("/closeOrOpen")
    public boolean closeOrOpen(int id,String op){
        YzcEmployee employee = employeeService.selectById(id);
        if("open".equals(op)){
            employee.setEmp_state(1);
        }else{
            employee.setEmp_state(0);
        }
        return employeeService.updateById(employee);
    }

    /**
     * 添加员工
     */
    @RequestMapping("/addEmployee")
    public boolean addEmployee(YzcEmployee employee){
        //随机生成用户账号
        Random r = new Random();
        int acc = r.nextInt(99999)+100000;
        String account = String.valueOf(acc);
        while(employeeService.selectOne(new EntityWrapper<YzcEmployee>().eq("emp_account",account)) != null){
            acc = r.nextInt(99999)+100000;
            account = String.valueOf(acc);
        }
        employee.setEmp_account(account);
        boolean bool = employeeService.insert(employee);
        return bool;
    }

    /**
     * 新增或修改
     */
    @RequestMapping("/insertOrUpdate")
    public boolean insertOrUpdate(YzcEmployee employee){
        String password = employee.getEmp_pwd();
        if(password != null && !"".equals(password)){
            employee.setEmp_pwd(MD5.getMD5(employee.getEmp_pwd()));
        }
        return employeeService.insertOrUpdate(employee);
    }

    /**
     * 根据员工id获取信息
     */
    @RequestMapping("/getEmployeeById")
    public Map<String, Object> getEmployeeById(int empId){
        return employeeService.getEmployeeById(empId);
    }

    /**
     * 检测账号是否可用
     */
    @RequestMapping("/checkEmpAccount")
    public boolean checkEmpAccount(String account){
        boolean bool = false;
        YzcEmployee employee = employeeService.selectOne(new EntityWrapper<YzcEmployee>().eq("emp_account",account));
        if(employee == null){
            bool = true;
        }
        return bool;
    }

    /**
     * 提升用户为管理员
     */
    @RequestMapping("/promoteToAdmin")
    public boolean promoteToAdmin(String idStr){
        boolean bool = false;
        if(idStr != null){
            String[] strIds = idStr.split(",");
            List<Integer> ids = new ArrayList<>();
            for(String id : strIds){
                ids.add(Integer.valueOf(id));
            }
            bool = employeeService.batchUpdataToAdmin(ids);
        }
        return bool;
    }

    /**
     * 获取列表
     */
    @RequestMapping("/getEmployeeList")
    public List<YzcEmployee> getEmployeeList(Integer deptId){
        List<YzcEmployee> employeeList = null;
        if(deptId == null || deptId == 0){
            employeeList = employeeService.selectList(null);
        }else {
            employeeList = employeeService.selectList(new EntityWrapper<YzcEmployee>().eq("emp_dept_id",deptId));
        }
        return employeeList;
    }

    /**
     * 修改密码
     */
    @RequestMapping("/changePassWord")
    public boolean changePassWord(YzcEmployee employee){
        String password = employee.getEmp_pwd();
        if(password != null && !"".equals(password)){
            employee.setEmp_pwd(MD5.getMD5(employee.getEmp_pwd()));
        }
        return employeeService.updateById(employee);
    }

}

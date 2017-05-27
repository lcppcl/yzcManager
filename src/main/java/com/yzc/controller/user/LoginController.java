package com.yzc.controller.user;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.common.entity.YzcEmployee;
import com.common.result.ResultInfo;
import com.common.utils.MD5;
import com.yzc.service.staffing.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangfujie on 2017/4/16.
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/checkLogin")
    public ResultInfo checkLogin(String account , String password , HttpServletRequest request){
        ResultInfo resultInfo = new ResultInfo(906);
        YzcEmployee employee = employeeService.selectOne(new EntityWrapper<YzcEmployee>().eq("emp_account",account));
        if(employee == null){
            resultInfo.setMessageCode(103);//用户不存在！
        }else{
            if(employee.getEmp_state() == 0){
                resultInfo.setMessageCode(107);//用户不存在！
                resultInfo.setMessage("该账号已禁用！");
            }else if(employee.getEmp_pwd().equals(MD5.getMD5(password))){
                request.getSession().setAttribute("employee",employee);
                resultInfo.setMessage("登录成功！");
                resultInfo.setResult(employee);
            }
            else{
                resultInfo.setMessageCode(104);//密码错误！
            }
        }
        return resultInfo;
    }

    @RequestMapping("/codeValidate")
    public String codeValidate(String code_input , HttpServletRequest request){
        String resultInfo = "";
        String codeSession = (String) request.getSession().getAttribute("codes");
        if(codeSession.equalsIgnoreCase(code_input)){
            resultInfo = "ok";
        }else{
            resultInfo = "error";
        }
        return  resultInfo;
    }

    /**
     * 注销
     */
    @RequestMapping("/logoutUser")
    public ResultInfo logoutUser(HttpServletRequest request){
        ResultInfo resultInfo = new ResultInfo(906);
        request.getSession().removeAttribute("employee");
        return resultInfo;
    }

    /**
     * 获取当前登陆用户信息
     */
    @RequestMapping("/getEmployee")
    public YzcEmployee getEmployee(HttpServletRequest request){
        YzcEmployee employee = (YzcEmployee) request.getSession().getAttribute("employee");
        return employee;
    }
}

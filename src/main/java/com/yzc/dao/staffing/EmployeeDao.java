package com.yzc.dao.staffing;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
  * 员工人员表 dao 接口
 */
@Repository
public interface EmployeeDao  {

    /**
     * 分页查询(员工信息查询)
     */
    List<Map<String, Object>> getEmployeeList(Pagination page , @Param("content") String content , @Param("dept_id") Integer dept_id);

    /**
     * 通过员工id查询
     */
    Map<String, Object> getEmployeeById( @Param("emp_id") int emp_id);
}
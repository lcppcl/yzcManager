package com.yzc.service.staffing;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.YzcDepartment;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/17.
 */
public interface DepartmentService extends IService<YzcDepartment> {

    /**
     * 获取部门列表
     */
    Page<Map<String , Object>> getDepartmentPage(Page<Map<String , Object>> page);

    /**
     * 删除部门,及其子集部门
     */
    int deleteDeptById(int id);

}

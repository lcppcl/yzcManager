package com.yzc.dao.staffing;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/30.
 */
@Repository
public interface DepartmentDao {

    /**
     * 获取部门列表
     */
    List<Map<String , Object>> getDepartmentListByPage(Pagination pagination);
}

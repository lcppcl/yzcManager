package com.yzc.dao.pig_manage;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/24.
 */
@Repository
public interface GradeDao {

    /**
     * 分页查询
     */
    List<Map<String , Object>> getGradeList(Pagination page,@Param("emp_name") String emp_name,@Param("gra_name") String gra_name);

    /**
     * 通过id查询
     */
    Map<String , Object> getGradeInfo(@Param("gra_id") int gra_id);
}

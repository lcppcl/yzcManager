package com.yzc.dao.pig_manage;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 */
@Repository
public interface DiseaseDao {

    /**
     * 获取病例记录（分页）
     */
    List<Map<String,Object>> getIllPage(Pagination page , @Param("ill_name") String ill_name , @Param("ear_num") String ear_num);

    /**
     * 通过id查询
     */
    Map<String,Object> getIllById(@Param("id") int id);

}

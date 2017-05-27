package com.yzc.dao.product_manage;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/20.
 */
@Repository
public interface ChildbirthDao {
    /**
     * 查询page
     */
    List<Map<String , Object>> getPageList(Pagination page , @Param("ear_num") String ear_num);

    /**
     * 通过id查询
     */
    Map<String , Object> getById(@Param("id") int id);
}

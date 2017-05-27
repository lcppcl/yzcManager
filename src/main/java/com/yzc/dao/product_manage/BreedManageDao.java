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
public interface BreedManageDao {

    /**
     * 查询配种记录
     */
    List<Map<String , Object>> getPageList(Pagination page , @Param("mo_ear_num") String mo_ear_num , @Param("fu_ear_num") String fu_ear_num);

    /**
     * 查询配种耳号
     */
    List<Map<String , Object>> getBreedEarNum();

    /**
     * 通过id查询
     */
    Map<String , Object> getBreedById(@Param("bre_id") int bre_id);
}

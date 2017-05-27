package com.yzc.dao.product_manage;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.common.entity.YzcBreedRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/20.
 */
@Repository
public interface PregnantDao {

    /**
     * 查询page
     */
    List<Map<String , Object>> getPageList(Pagination page , @Param("ear_num") String ear_num);

    /**
     * 通过id查询怀孕记录
     */
    Map<String , Object> getPregnantById(@Param("pre_id") int pre_id);

    /**
     * 通过怀孕id获取配种信息
     */
    Map<String , Object> getBreedInfoByPreId(@Param("pre_id") int pre_id);

}

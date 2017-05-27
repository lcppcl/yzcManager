package com.yzc.dao.pig_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/18.
 */
@Repository
public interface YzcPigDao {

    /**
     * 获取猪信息
     * @param page        分页
     * @param startDate   进场开始时间
     * @param endDate     进场结束时间
     * @param ear_num     耳号
     * @param pig_sex     猪性别
     * @param var_id      猪品种id
     */
    List<Map<String,Object>> getPigListByParams(Pagination page ,
                                                @Param("startDate") String startDate ,
                                                @Param("endDate") String endDate ,
                                                @Param("ear_num") String ear_num ,
                                                @Param("pig_sex") String pig_sex ,
                                                @Param("var_id") Integer var_id);

    /**
     * 获取育种猪
     */
    List<Map<String,Object>> getSeedPigList(Pagination page);

    /**
     * 通过id查询
     */
    Map<String , Object> getPigById(@Param("pig_id") int pig_id , @Param("pig_sex") String pig_sex);
}

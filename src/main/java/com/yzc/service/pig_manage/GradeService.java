package com.yzc.service.pig_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.YzcGrade;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/24.
 */
public interface GradeService extends IService<YzcGrade> {

    /**
     * 分页查询
     */
    Page<Map<String , Object>> getGradePage(Page<Map<String , Object>> page,String emp_name,String gra_name);

    /**
     * 通过id查询
     */
    Map<String , Object> getGradeInfo(int gra_id);

    /**
     * 通过id删除
     */
    boolean deleteGrade(int gra_id);

}

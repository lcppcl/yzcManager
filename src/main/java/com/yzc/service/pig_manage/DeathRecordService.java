package com.yzc.service.pig_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.YzcDeathRecord;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 */
public interface DeathRecordService extends IService<YzcDeathRecord> {

    /**
     * 分页查询
     */
    Page<Map<String , Object>> getDeathRecordPage(Page<Map<String , Object>> page , String startDate , String endDate , String ear_num);

    /**
     * 通过id查询信息
     */
    Map<String , Object> getDeathRecordById(int id);

    /**
     * 新增或修改死亡记录
     */
    boolean insertOrUpdateDeathRecord(YzcDeathRecord record);
}

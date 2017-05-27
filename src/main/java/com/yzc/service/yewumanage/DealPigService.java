package com.yzc.service.yewumanage;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.DealPigInfo;
import com.common.entity.YzcDealPig;
import org.apache.ibatis.annotations.Param;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/30.
 */
public interface DealPigService extends IService<YzcDealPig> {

    /*
    * 获取所有信息
    */
    Page<Map<String , Object>> getDealPigPage(Page<Map<String, Object>> page , String startDate, String endDate,String deal_type, String ear_num, String par_name);

    /*
     * 通过id获取信息
     */
    Map<String , Object> geDealPigById(@Param("deal_id") int deal_id);

    /**
     * 新增
     */
    boolean insertDealPigInfo(DealPigInfo dealPigInfo);
}

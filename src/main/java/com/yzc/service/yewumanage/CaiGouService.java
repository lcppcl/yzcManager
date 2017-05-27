package com.yzc.service.yewumanage;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.YzcCaiGouSubmit;
import com.common.entity.YzcOrders;
import com.common.entity.YzcPurchaseRecord;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/18.
 */
public interface CaiGouService extends IService<YzcPurchaseRecord> {

    /*
	 * 获取所有信息
	 */
    Page<Map<String , Object>> queryPurByName(Page<Map<String , Object>> page ,
                                                           String startDate,
                                                           String endDate,
                                                           String content
    );

    /*
     * 通过id获取订单信息
     *
     */
    Map<String , Object> getPurInfoById(int pur_id);

    /**
     * 新增采购信息
     */
    boolean insertCiaGouInfo(YzcCaiGouSubmit submit);
}

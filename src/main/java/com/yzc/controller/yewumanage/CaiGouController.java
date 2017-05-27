package com.yzc.controller.yewumanage;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcCaiGouSubmit;
import com.common.entity.YzcOrders;
import com.common.entity.YzcPurchaseRecord;
import com.common.result.ResultInfo;
import com.common.utils.UUIDBuild;
import com.yzc.service.yewumanage.CaiGouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/18.
 * 采购管理
 */
@RestController
@RequestMapping("/yewumanage/caigou")
public class CaiGouController {

    @Autowired
    private CaiGouService service;

    /**
     * 查询订单
     */
    @RequestMapping("/queryPurByName")
    public Page<Map<String , Object>> queryPurByName(int current , int size ,String startDate, String endDate, String content){
        Page<Map<String , Object>> page = new Page<>(current,size);
        service.queryPurByName(page,startDate,endDate,content);
        return page;
    }

    /**
     * 添加订单
     */
    @RequestMapping("/insertCiaGouInfo")
    public boolean insertCiaGouInfo(@RequestBody YzcCaiGouSubmit submit){
        String uuid = UUIDBuild.getUUID();
        YzcOrders orders = submit.getOrders();
        orders.setUuid(uuid);
        List<YzcPurchaseRecord> recordList = submit.getRecordList();
        BigDecimal order_sub = new BigDecimal(0);
        if(recordList != null && recordList.size() > 0){
            for (YzcPurchaseRecord record : recordList){
                record.setOrder_uuid(uuid);
                order_sub = order_sub.add(record.getPur_total());
            }
        }
        orders.setOrder_sub(order_sub);
        return service.insertCiaGouInfo(submit);
    }

    /**
     * 删除订单
     */
    @RequestMapping("/getPurInfoById")
    public boolean getPurInfoById(int pur_id){
        return service.deleteById(pur_id);
    }

    /**
     * 修改订单
     */
    @RequestMapping("/updatePur")
    public boolean updatePur(YzcPurchaseRecord record){
        return service.updateById(record);
    }

}

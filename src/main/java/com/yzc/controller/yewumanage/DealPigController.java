package com.yzc.controller.yewumanage;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.DealPigInfo;
import com.common.entity.YzcDealPig;
import com.common.entity.YzcOrders;
import com.common.utils.UUIDBuild;
import com.yzc.service.yewumanage.DealPigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/30.
 */
@RestController
@RequestMapping("/yewumanage/deal_pig")
public class DealPigController {
    @Autowired
    private DealPigService service;

    /**
     * 查询订单
     */
    @RequestMapping("/getDealPigPage")
    public Page<Map<String , Object>> getDealPigPage(int current , int size , String startDate, String endDate, String deal_type,String ear_num, String par_name){
        Page<Map<String , Object>> page = new Page<>(current,size);
        service.getDealPigPage(page,startDate,endDate,deal_type,ear_num,par_name);
        return page;
    }

    /**
     * 添加
     */
    @RequestMapping("/insertDealPigInfo")
    public boolean insertDealPigInfo(@RequestBody DealPigInfo pigInfo){
        String uuid = UUIDBuild.getUUID();
        YzcOrders orders = pigInfo.getOrders();
        orders.setUuid(uuid);
        List<YzcDealPig> dealPigList = pigInfo.getDealPigList();
        BigDecimal order_sub = new BigDecimal(0);
        if(dealPigList != null && dealPigList.size() > 0){
            for (YzcDealPig dealPig : dealPigList){
                dealPig.setOrder_uuid(uuid);
                Double total = Double.parseDouble(dealPig.getDeal_price()) * dealPig.getDeal_weight();
                order_sub =  order_sub.add(BigDecimal.valueOf(total));
            }
        }
        orders.setOrder_sub(order_sub);
        return service.insertDealPigInfo(pigInfo);
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteById")
    public boolean deleteById(int id){
        return service.deleteById(id);
    }

}

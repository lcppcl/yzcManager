package com.yzc.controller.count;

import com.yzc.service.count.TableCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/19.
 */
@RestController
@RequestMapping("/count")
public class TableCountController {

    @Autowired
    private TableCountService countService;

    /**
     * 客户交易来往统计
     */
    @RequestMapping("/getUserCountByDate")
    public List<Map<String,Object>> getUserCountByDate(String datemin,String datemax,String parname){
        List<Map<String,Object>> list = countService.getUserCountByDate(datemin, datemax, parname);
        return list;
    }

    /**
     * 猪类销售统计
     */
    @RequestMapping("/getPigSellCountByDate")
    public List<Map<String,Object>> getPigSellCountByDate(String datemin,String datemax,String parname){
        List<Map<String,Object>> list = countService.getPigSellCountByDate(datemin, datemax, parname);
        return list;
    }

    /**
     * 存栏统计
     */
    @RequestMapping("/getLivestockCountByDate")
    public List<Map<String,Object>> getLivestockCountByDate(String date){
        List<Map<String,Object>> list = countService.getLivestockCountByDate(date);
        return list;
    }

    /**
     * 月统计报表1
     */
    @RequestMapping("/getMonthCountTab1ByDate")
    public List<Map<String,Object>> getMonthCountTab1ByDate(String date){
        List<Map<String,Object>> list = countService.getMonthCountTab1ByDate(date);
        return list;
    }

    /**
     * 月统计报表2
     */
    @RequestMapping("/getMonthCountTab2ByDate")
    public List<Map<String,Object>> getMonthCountTab2ByDate(String date){
        List<Map<String,Object>> list = countService.getMonthCountTab2ByDate(date);
        return list;
    }
}

package com.yzc.controller.product_table;

import com.baomidou.mybatisplus.plugins.Page;
import com.yzc.service.product_table.ProductTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 */
@RestController
@RequestMapping("/product_table")
public class ProductTableController {
    @Autowired
    private ProductTableService tableService;

    /*
	 * 公猪生产成绩
	 */
    @RequestMapping("/boarPigProductQuery")
    public Page<Map<String , Object>> boarPigProductQuery(int current , int size , String ear_num , int grade_id,int class_id){
        Page<Map<String , Object>> page = new Page<>(current , size);
        tableService.boarPigProductQuery(page,ear_num,grade_id,class_id);
        return page;
    }

    /*
    * 母猪生产成绩
    */
    @RequestMapping("/sowPigProductQuery")
    public Page<Map<String , Object>> sowPigProductQuery(int current , int size , String ear_num , int grade_id,int class_id){
        Page<Map<String , Object>> page = new Page<>(current , size);
        tableService.sowPigProductQuery(page,ear_num,grade_id,class_id);
        return page;
    }

    /**
     * 存栏明细
     */
    @RequestMapping("/getClassDetail")
    public Page<Map<String , Object>> getClassDetail(int current , int size , String ear_num , int grade_id,int class_id){
        Page<Map<String , Object>> page = new Page<>(current , size);
        tableService.getClassDetail(page,ear_num,grade_id,class_id);
        return page;
    }

    /**
     * 猪群饲养成本
     */
    @RequestMapping("/getPigFeedsCost")
    public Page<Map<String , Object>> getPigFeedsCost(int current , int size , int grade_id){
        Page<Map<String , Object>> page = new Page<>(current , size);
        tableService.getPigFeedsCost(page,grade_id);
        return page;
    }

}

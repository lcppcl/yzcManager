package com.yzc.controller.product_analysis;

import com.yzc.service.product_analysis.ProductAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/19.
 */
@RestController
@RequestMapping("/product_analysis")
public class ProductAnalysisController {

    @Autowired
    private ProductAnalysisService analysisService;

    /**
     * 猪场价值评估
     */
    @RequestMapping("/getPigValue")
    public List<Map<String , Object>> getPigValue(String date){
        return analysisService.getPigValue(date);
    }

    /**
     * 死亡率分析
     */
    @RequestMapping("/getMortalityByDate")
    public List<Map<String , Object>> getMortalityByDate(String date){
        return analysisService.getMortalityByDate(date);
    }

    /**
     * 生产效率分析
     */
    @RequestMapping("/getProductivityByDate")
    public List<Map<String , Object>> getProductivityByDate(String type){
        return analysisService.getProductivityByDate(type);
    }

    /**
     * 受胎率分析
     */
    @RequestMapping("/getPregnancyByDate")
    public List<Map<String , Object>> getPregnancyByDate(String datemin, String datemax){
        return analysisService.getPregnancyByDate(datemin, datemax);
    }
}

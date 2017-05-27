package com.yzc.service.excel;

import java.util.Map;

/**
 * Created by wangfujie on 2017/5/9.
 */
public interface ExcelExportService {

    /**
     * 导出来往交易客户
     */
    String exportToPyUser(String exportData, String saveDir, String templatePath, Map<String, Object> map) throws Exception;

    /**
     * 导出月统计报表
     */
    String exportToMonthTable(String exportData, String saveDir, String templatePath, Map<String, Object> map) throws Exception;

    /**
     * 导出猪类销售统计
     */
    String exportToPigSeal(String exportData, String saveDir, String templatePath, Map<String, Object> map) throws Exception;

    /**
     * 导出存栏统计
     */
    String exportToLiveStock(String exportData, String saveDir, String templatePath, Map<String, Object> map) throws Exception;

    /**
     * 导出猪场价值评估
     */
    String exportToPigValue(String exportData, String saveDir, String templatePath, Map<String, Object> map) throws Exception;
}

package com.yzc.controller.excel;

import com.common.result.ResultInfo;
import com.common.utils.DateUtils;
import com.yzc.controller.BaseController;
import com.yzc.service.excel.ExcelExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangfujie on 2017/5/9.
 */
@RestController
@RequestMapping("/excel/export")
public class ExcelExportController extends BaseController {

    @Autowired
    private ExcelExportService exportService;

    /**
     * 来往客户统计
     */
    @RequestMapping("/exportToPyUser")
    public ResultInfo exportToPyUser(HttpServletRequest request, HttpServletResponse response, String exportData) throws Exception {
        String saveDir = request.getServletContext().getContextPath() + "/WEB-INF/lin_shi_file/";
        String templatePath = request.getServletContext().getContextPath()+"/WEB-INF/excelTmp/来往客户统计表.xlsx";
        // 对读取Excel表格标题测试
        Map map = new HashMap();
        map.put("create_time", DateUtils.getFormatString(new Date(), "yyyy年MM月dd日"));
        map.put("enterprise_name", "演示");
        String filePath = exportService.exportToPyUser(exportData, saveDir, templatePath, map);
        String fileName = "来往客户统计表.xlsx";
        outFile(response, request, filePath, fileName);
        deleteTmpFile(filePath);
        return null;
    }

    /**
     * 导出月统计报表
     */
    @RequestMapping("/exportToMonthTable")
    public ResultInfo exportToMonthTable(HttpServletRequest request, HttpServletResponse response, String exportData) throws Exception {
        String saveDir = request.getServletContext().getContextPath() + "WEB-INF/lin_shi_file/";
        String templatePath = request.getServletContext().getContextPath()+"WEB-INF/excelTmp/月统计报表.xlsx";
        // 对读取Excel表格标题测试
        Map map = new HashMap();
        map.put("create_time", DateUtils.getFormatString(new Date(), "yyyy年MM月dd日"));
        map.put("enterprise_name", "演示");
        String filePath = exportService.exportToMonthTable(exportData, saveDir, templatePath, map);
        String fileName = "月统计报表.xlsx";
        outFile(response, request, filePath, fileName);
        deleteTmpFile(filePath);
        return null;
    }

    /**
     * 导出猪类销售统计
     */
    @RequestMapping("/exportToPigSeal")
    public ResultInfo exportToPigSeal(HttpServletRequest request, HttpServletResponse response, String exportData) throws Exception {
        String saveDir = request.getServletContext().getContextPath() + "WEB-INF/lin_shi_file/";
        String templatePath = request.getServletContext().getContextPath()+"WEB-INF/excelTmp/猪类销售统计表.xlsx";
        // 对读取Excel表格标题测试
        Map map = new HashMap();
        map.put("create_time", DateUtils.getFormatString(new Date(), "yyyy年MM月dd日"));
        map.put("enterprise_name", "演示");
        String filePath = exportService.exportToPigSeal(exportData, saveDir, templatePath, map);
        String fileName = "猪类销售统计表.xlsx";
        outFile(response, request, filePath, fileName);
        deleteTmpFile(filePath);
        return null;
    }

    /**
     * 导出存栏统计
     */
    @RequestMapping("/exportToLiveStock")
    public ResultInfo exportToLiveStock(HttpServletRequest request, HttpServletResponse response, String exportData) throws Exception {
        String saveDir = request.getServletContext().getContextPath() + "WEB-INF/lin_shi_file/";
        String templatePath = request.getServletContext().getContextPath()+"WEB-INF/excelTmp/存栏统计表.xlsx";
        // 对读取Excel表格标题测试
        Map map = new HashMap();
        map.put("create_time", DateUtils.getFormatString(new Date(), "yyyy年MM月dd日"));
        map.put("enterprise_name", "演示");
        String filePath = exportService.exportToLiveStock(exportData, saveDir, templatePath, map);
        String fileName = "存栏统计表.xlsx";
        outFile(response, request, filePath, fileName);
        deleteTmpFile(filePath);
        return null;
    }

    /**
     * 导出猪场价值评估
     */
    @RequestMapping("/exportToPigValue")
    public ResultInfo exportToPigValue(HttpServletRequest request, HttpServletResponse response, String exportData) throws Exception {
        String saveDir = request.getServletContext().getContextPath() + "WEB-INF/lin_shi_file/";
        String templatePath = request.getServletContext().getContextPath()+"WEB-INF/excelTmp/猪场价值评估表.xlsx";
        // 对读取Excel表格标题测试
        Map map = new HashMap();
        map.put("create_time", DateUtils.getFormatString(new Date(), "yyyy年MM月dd日"));
        map.put("enterprise_name", "演示");
        String filePath = exportService.exportToPigValue(exportData, saveDir, templatePath, map);
        String fileName = "猪场价值评估表.xlsx";
        outFile(response, request, filePath, fileName);
        deleteTmpFile(filePath);
        return null;
    }
}

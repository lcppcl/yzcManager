package com.yzc.service.excel.impl;

import com.common.utils.DateUtils;
import com.yzc.service.excel.ExcelExportService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/5/9.
 */
@Service
public class ExcelExportServiceImpl implements ExcelExportService {


    @Override
    public String exportToPyUser(String exportData, String saveDir, String templatePath, Map<String, Object> map) throws Exception {
        String filePath = saveDir + "\\" + "来往交易客户统计表_" + DateUtils.getOrderNum() + DateUtils.getThree() + ".xlsx";
        List<Integer> cellList = new ArrayList<>();
        cellList.add(5);
        Workbook workbook = getWorkBook(exportData,map,templatePath,cellList);
        File savefile = new File(saveDir);
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    @Override
    public String exportToMonthTable(String exportData, String saveDir, String templatePath, Map<String, Object> map) throws Exception {
        String filePath = saveDir + "\\" + "月统计报表_" + DateUtils.getOrderNum() + DateUtils.getThree() + ".xlsx";
        TemplateExportParams params = new TemplateExportParams(templatePath);
        Workbook workbook = null;
        if(exportData != null && !"".equals(exportData)){
            JSONObject jsonObject = JSONObject.fromObject(exportData);
            JSONArray tableDataOne = jsonObject.getJSONArray("tableDataOne");
            JSONArray tableDataTwo = jsonObject.getJSONArray("tableDataTwo");
            int indexOne = 1;
            for (Object o : tableDataOne) {
                JSONObject jo = (JSONObject) o;
                jo.put("id", indexOne);
                indexOne++;
            }
            int indexTwo = 1;
            for (Object o : tableDataTwo) {
                JSONObject jo = (JSONObject) o;
                jo.put("id", indexTwo);
                indexTwo++;
            }
            map.put("tableDataOne",tableDataOne);
            map.put("tableDataTwo",tableDataTwo);
            workbook = ExcelExportUtil.exportExcel(params, map);

            Sheet sheetOne = workbook.getSheetAt(0);
            //公式
            Row row1 = sheetOne.getRow((2 + indexOne));
            row1.getCell(1).setCellValue(indexOne);//添加合计一行的序号
            row1.getCell(3).setCellFormula("SUM(D4:D"+(indexOne+2)+")");
            row1.getCell(4).setCellFormula("SUM(E4:E"+(indexOne+2)+")");
            row1.getCell(5).setCellFormula("SUM(F4:F"+(indexOne+2)+")");
            row1.getCell(6).setCellFormula("SUM(G4:G"+(indexOne+2)+")");
            row1.getCell(7).setCellFormula("SUM(H4:H"+(indexOne+2)+")");
            row1.getCell(8).setCellFormula("SUM(I4:I"+(indexOne+2)+")");

//            Sheet sheetTwo = workbook.getSheetAt(1);
//            //公式
//            Row row2 = sheetTwo.getRow((2 + indexTwo));
//            row2.getCell(1).setCellValue(indexTwo);//添加合计一行的序号
//            row1.getCell(3).setCellFormula("SUM(D4:D"+(indexOne+2)+")");
//            row1.getCell(4).setCellFormula("SUM(E4:E"+(indexOne+2)+")");
//            row1.getCell(5).setCellFormula("SUM(F4:F"+(indexOne+2)+")");
//            row1.getCell(6).setCellFormula("SUM(G4:G"+(indexOne+2)+")");
//            row1.getCell(7).setCellFormula("SUM(H4:H"+(indexOne+2)+")");
//            row1.getCell(8).setCellFormula("SUM(I4:I"+(indexOne+2)+")");
//            row1.getCell(9).setCellFormula("SUM(J4:J"+(indexOne+2)+")");
//            row1.getCell(10).setCellFormula("SUM(K4:K"+(indexOne+2)+")");
        }
        File savefile = new File(saveDir);
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    @Override
    public String exportToPigSeal(String exportData, String saveDir, String templatePath, Map<String, Object> map) throws Exception {
        String filePath = saveDir + "\\" + "猪类销售统计表_" + DateUtils.getOrderNum() + DateUtils.getThree() + ".xlsx";
        List<Integer> cellList = new ArrayList<>();
        cellList.add(5);
        cellList.add(6);
        cellList.add(7);
        Workbook workbook = getWorkBook(exportData,map,templatePath,cellList);
        File savefile = new File(saveDir);
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    @Override
    public String exportToLiveStock(String exportData, String saveDir, String templatePath, Map<String, Object> map) throws Exception {
        String filePath = saveDir + "\\" + "存栏统计表_" + DateUtils.getOrderNum() + DateUtils.getThree() + ".xlsx";
        List<Integer> cellList = new ArrayList<>();
        cellList.add(4);
        cellList.add(5);
        Workbook workbook = getWorkBook(exportData,map,templatePath,cellList);
        File savefile = new File(saveDir);
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    @Override
    public String exportToPigValue(String exportData, String saveDir, String templatePath, Map<String, Object> map) throws Exception {
        String filePath = saveDir + "\\" + "猪场价值评估表_" + DateUtils.getOrderNum() + DateUtils.getThree() + ".xlsx";
        Workbook workbook = getWorkBook(exportData,map,templatePath,null);
        File savefile = new File(saveDir);
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    private Workbook getWorkBook(String exportData,Map<String, Object> map,String templatePath,List<Integer> cellList){
        String[] cellStr = {"A","B","C","D","E","F","G","H","I","J","K"};
        Workbook workbook = null;
        TemplateExportParams params = new TemplateExportParams(templatePath);
        if(exportData != null && !"".equals(exportData)){
            JSONArray jsonArray = JSONArray.fromObject(exportData);
            int index = 1;
            for (Object o : jsonArray) {
                JSONObject jo = (JSONObject) o;
                jo.put("id", index);
                index++;
            }
            map.put("exportData",jsonArray);
            workbook = ExcelExportUtil.exportExcel(params, map);
            if(cellList != null && cellList.size() > 0){
                //公式
                Sheet sheet = workbook.getSheetAt(0);
                Row row = sheet.getRow((2 + index));
                row.getCell(1).setCellValue(index);//添加合计一行的序号
                for (Integer cell : cellList){
                    row.getCell(cell).setCellFormula("SUM("+cellStr[cell]+"4:"+cellStr[cell]+(index+2)+")");
                }
            }
        }
        return workbook;
    }
}

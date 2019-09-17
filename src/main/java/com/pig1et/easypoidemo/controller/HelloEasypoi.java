package com.pig1et.easypoidemo.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.pig1et.easypoidemo.vo.ExcelImportVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/easypoi")
public class HelloEasypoi {

    @GetMapping("/sayHello")
    public String HelloWorld(){
        return "HelloWorld";
    }

    @GetMapping("/import/{filePath}")
    public String importExcel(@PathVariable("filePath") String filePath){

        System.out.println(filePath);

        filePath = "C:/Users/dell/Downloads/房源发布.xlsx";
        ImportParams importParams = new ImportParams();
        // 设置开启数据校验
        importParams.setNeedVerify(true);
        List<ExcelImportVO> list =  ExcelImportUtil.importExcel(new File(filePath), ExcelImportVO.class, importParams);


        return list.toString();
    }

}

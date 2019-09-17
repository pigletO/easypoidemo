package com.pig1et.easypoidemo.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.pig1et.easypoidemo.vo.ExcelImportVO;
import com.pig1et.easypoidemo.vo.ExcelImportVO2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/easypoi")
public class HelloEasypoi {

    @GetMapping("/sayHello")
    public String HelloWorld(){
        return "HelloWorld";
    }

    @GetMapping("/import")
    public String importExcel(@RequestParam("file") MultipartFile file){

        ImportParams importParams = new ImportParams();
        // 设置开启数据校验
        importParams.setNeedVerify(true);
        // 启用数据校验导入excel
        ExcelImportResult<ExcelImportVO> list = null;
        try {
            list = ExcelImportUtil.importExcelMore(file.getInputStream(), ExcelImportVO.class, importParams);
            //ExcelImportResult<ExcelImportVO2> list2 =  ExcelImportUtil.importExcelMore(file.getInputStream(), ExcelImportVO2.class, importParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("是否存在校验错误 : {}", list.isVerfiyFail());
        log.info("导入的正确excel数据 : {}", list.getList());
        //log.info("导入的正确的excel数据 : {}", list2.getList());
        log.info("错误的数据行号为 : {}", list.getFailList().stream().filter(e->e.getRowNum() != 0).map(e->e.getRowNum()).collect(Collectors.toList()));
        log.info("错误信息为 : {}", list.getFailList().stream().filter(e->e.getErrorMsg() != null).map(e->e.getErrorMsg()).collect(Collectors.toList()));
        log.info("错误的数据 : {}",list.getFailList());
        //log.info("错误的数据2 : {}",list2.getFailList());

        return list.toString();
    }

}

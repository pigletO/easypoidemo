package com.pig1et.easypoidemo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 此类实现IExcelModel接口，启用数据校验时，将返回全部解析后的数据
 * 实现IExcelDataModel接口，启用数据校验并出错时，返回错误行号
 * @Author pig1otO
 */
@Data
public class ExcelImportVO implements Serializable, IExcelModel, IExcelDataModel {

    /**
     * name属性标识excel的列明，isImportField标识是否为必填项，orderNum列排序,importFormat转换时间类型的格式
     */
    @Excel(name = "房源名称（房源维护中的名称）*")
    @NotNull(message = "房源名称不能为空！")
    private String column1;

    @Excel(name = "产品名称（房源维护中的产品名称）*", isImportField = "true", orderNum = "1")
    private String column2;

    @Excel(name = "适用范围 *", isImportField = "true", orderNum = "2")
    private String column3;

    @Excel(name = "绿云房型码", orderNum = "3")
    private String column4;

    @Excel(name = "绿云房价码", orderNum = "4")
    private String column5;

    @Excel(name = "数量（库存总数）*", isImportField = "true", orderNum = "5")
    private String column6;

    @Excel(name = "起始时间*", isImportField = "true", orderNum = "6", importFormat = "yyyy/MM/dd")
    private String column7;

    @Excel(name = "结束时间*", isImportField = "true", orderNum = "7", importFormat = "yyyy/MM/dd")
    private String column8;

    @Excel(name = "销售价*", isImportField = "true", orderNum = "8")
    private String column9;

    @Excel(name = "结算价", orderNum = "9")
    private String column10;

    @Excel(name = "盛行权", orderNum = "10")
    private String column11;

    @Excel(name = "盛行权加价", orderNum = "11")
    private String column12;

    @Excel(name = "抽佣率%(0-100之间)", orderNum = "12")
    private String column13;

    @Excel(name = "荣盛币立减价", orderNum = "13")
    private String column14;

    @Excel(name = "是否允许退*", isImportField = "true", orderNum = "14")
    private String column15;

    @Excel(name = "是否上架*", isImportField = "true", orderNum = "15")
    private String column16;

    @Excel(name = "保留房数*", isImportField = "true", orderNum = "16")
    private String column17;

    /**
     * 错误信息，必须为errorMsg
     */
    private String errorMsg;

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private int rowNum;
    @Override
    public int getRowNum() {
        return rowNum;
    }

    @Override
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }
}

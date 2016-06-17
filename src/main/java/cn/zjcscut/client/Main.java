package cn.zjcscut.client;

import cn.zjcscut.bean.Fruit;
import cn.zjcscut.jxls.ExcelUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/6/17 15:12
 */
public class Main {

    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("苹果", 20.0f));
        list.add(new Fruit("桔子", 30.0f));
        String templateFileName = "template.xlsx";
        String resultFileName = "result.xlsx";
        new ExcelUtil().createLocalExcel(null, templateFileName, list, resultFileName, "D:/export/excel");
    }
}

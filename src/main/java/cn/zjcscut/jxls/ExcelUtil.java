package cn.zjcscut.jxls;

/**
 * @author zhangjinci
 * @version 2016/6/17 15:12
 */

import net.sf.jxls.transformer.XLSTransformer;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Excel生成类.
 */
public class ExcelUtil {

//    private static final String TEMPLATE_LOCATION = "template" + File.separator;
//    private static final String EXPORT_LOCATION = "d:/" + "export" + File.separator;

    /**
     * 根据模板生成本地Excel文件.
     *
     * @param templateFileName 模板文件.
     * @param list             模板中存放的数据.
     * @param resultFileName   生成的文件.
     */
    public void createLocalExcel(String templateFileLocation, String templateFileName, List<?> list, String resultFileName, String resultFileLocation) {
        try {
            //创建XLSTransformer对象
            XLSTransformer transformer = new XLSTransformer();

            String path = null;
            String destFilePath = null;
            String srcFilePath = null;
            URL url = Thread.currentThread().getContextClassLoader().getResource("");
            if (url != null) {
                path = url.getPath();
            }
            if (StringUtils.isNotEmpty(templateFileLocation)) {
                srcFilePath = templateFileLocation + "/" + templateFileName;
            } else {
                srcFilePath = path + templateFileName;
            }
            if (StringUtils.isNotEmpty(resultFileLocation)) {
                destFilePath = resultFileLocation;
                File file = new File(resultFileLocation);
                if (!file.exists() && !file.isDirectory()) { //如果输出文件夹不存在，新建一个
                    file.mkdir();
                }
                destFilePath = resultFileLocation + "/" + resultFileName;
            } else {
                destFilePath = path + resultFileName;
            }
            Map<String, Object> map = new HashMap<>();
            map.put("list", list);
            //生成Excel文件
            transformer.transformXLS(srcFilePath, map, destFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //重载方法，成的Excel在项目的classpath
    public void createLocalExcel(String templateFileName, List<?> list, String resultFileName) {
        createLocalExcel(null, templateFileName, list, resultFileName, null);
    }
}

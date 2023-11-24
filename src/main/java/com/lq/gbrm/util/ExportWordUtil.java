package com.lq.gbrm.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.Map;
@Component
public class ExportWordUtil {
    private Configuration configuration;
    private String encoding;
    private String mb;
    private String exportPath = "D:\\test\\";

    /**
     * 构造函数
     * 配置模板路径
     */
    public ExportWordUtil() {
        this.encoding ="UTF-8";
        configuration = new Configuration();
        configuration.setDefaultEncoding(encoding);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates");
    }

    /**
     * 获取模板
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Template getTemplate(String name) throws Exception {
        return configuration.getTemplate(name);
    }

    /**
     * 导出word文档到指定目录
     * @param fileName
     * @param tplName
     * @param data
     * @throws Exception
     */
//    public void exportDocFile(String fileName, String tplName, Map<String, Object> data) throws Exception {
//        //如果目录不存在，则创建目录
//        File exportDirs = new File(exportPath);
//        if (!exportDirs.exists()) {
//            exportDirs.mkdirs();
//        }
//        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(exportPath + fileName), encoding));
//        getTemplate(tplName).process(data, writer);
//    }

    /**
     * 导出word文档到客户端
     * @param response
     * @param fileName
     * @param tplName
     * @param data
     * @throws Exception
     */
    public void exportDoc(HttpServletResponse response, String fileName, String tplName, Map<String, Object> data) throws Exception {
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment; filename=" +  URLEncoder.encode(fileName , "UTF-8"));
        response.setHeader("filename", URLEncoder.encode(fileName , "UTF-8")) ;
        // 把本地文件发送给客户端
        Writer out = response.getWriter();
        Template template = getTemplate(tplName);
        template.process(data, out);
        out.close();
    }
}

package xyz.lihang.blog.common.tool;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class JsonPares {
    private static Logger log = Logger.getLogger(JsonPares.class.getName());

    public static String readFileToString (String jsonPath){
        FileInputStream fis = null;
        log.info("加载Json文件到内存中FilePath:" + jsonPath );
        try {
            fis = new FileInputStream(jsonPath);
            return IOUtils.toString(fis,"UTF-8");
        }catch (IOException e){
            log.info(e.getMessage());
        }finally {
            if(fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
}

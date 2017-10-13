package xyz.lihang.blog.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.lihang.blog.model.LoginUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class JsonPares<T> {
    private static Logger log = LoggerFactory.getLogger(JsonPares.class);

    private static  Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();


    public static <T>T pares(String jsonPath,Type type){
        log.info("读取缓存列表" + type );
        JsonReader reader = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        log.info("加载Json文件到内存中FilePath:" + jsonPath );
        try {
            fis = new FileInputStream(new File(jsonPath));
            isr = new InputStreamReader(fis,"UTF-8");
            reader = new JsonReader(isr);
            reader.setLenient(true);
            T t = gson.fromJson(reader, type);
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(isr!=null){
                    isr.close();
                }
                if(fis!=null){
                    fis.close();
                }
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        return null;
    }
}

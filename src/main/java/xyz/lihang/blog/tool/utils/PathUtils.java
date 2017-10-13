package xyz.lihang.blog.tool.utils;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class PathUtils {
    /**
     * 获取classess路径
     *
     * E:\\...\\WEB-INF\\classes
     *
     * @return
     */
    public static String getClassesPath (){
        try {
            URI uri = Thread.currentThread().getContextClassLoader().getResource("/").toURI();
            File file = new File(uri);
            return  file.getPath();
        }catch (URISyntaxException e){
            throw  new RuntimeException(e);
        }
    }

    /**
     * 获取web项目根路径
     *
     * file:/.../blog-0.0.1-SNAPSHOT/
     *
     * @return
     */
    public static String getWebRootPath (){
        try {
            URI uri = Thread.currentThread().getContextClassLoader().getResource("/").toURI();
            File file = new File(uri).getParentFile().getParentFile();
            return  file.getPath();
        }catch (URISyntaxException e){
            throw  new RuntimeException(e);
        }
    }

}

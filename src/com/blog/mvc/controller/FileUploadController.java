package com.blog.mvc.controller;

import java.io.File;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.blog.mvc.utils.FileUtils;
import com.blog.mvc.utils.RenderJson;

@RequestMapping(value="/admin/fileUpload")
@Controller
public class FileUploadController extends BaseController {
	
	Log log = LogFactory.getLog(getClass());
	
	/**
	 * 允许的图片文件白名单
	 */
	public String[] images = {".png", ".jpg", ".jpeg", ".gif", ".bmp"};
	
	public String uploadPath = "/upload/";
	
	public FileUploadController(){
		try{
			File file = new File(rootPath + uploadPath);
			if(!file.exists()){
				file.mkdirs();
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	@RequestMapping("/image")
	@ResponseBody
	public RenderJson image (@RequestParam("file") CommonsMultipartFile file){
		try{
			System.out.println("fileName："+file.getOriginalFilename());
			//是否在白名单
			String suffix  = FileUtils.parseSuffix(file.getOriginalFilename());
			if(!FileUtils.isWhiteList(suffix, images)){
				throw new RuntimeException("文件后缀不是白名单中" + file.getOriginalFilename());
			}
			String fileName = uploadPath + UUID.randomUUID().toString() +suffix;
		    String path= rootPath +  fileName;
		    log.info(path);
	        File newFile=new File(path);
	        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
	        newFile.createNewFile();
	        file.transferTo(newFile);
			return RenderJson.Instance().SUCCESS().setMessage("上传成功").setObj(fileName);
		}catch(Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return RenderJson.Instance().ERROR().setMessage("操作失败,请检查文件");
		
	}
	
	
	public static void main(String[] args) {
	}
}

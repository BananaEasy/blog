package xyz.lihang.blog.web.controller;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xyz.lihang.blog.common.tool.annotation.RenderJsonInvok;
import xyz.lihang.blog.common.tool.utils.FileUtils;
import xyz.lihang.blog.service.exception.MyException;
import xyz.lihang.blog.common.tool.utils.PathUtils;
import xyz.lihang.blog.common.tool.utils.RenderJson;


@Controller
@RequestMapping(value="/admin/fileUpload")
public class FileUploadController extends BaseController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 允许的图片文件白名单
	 */
	public String[] images = {".png", ".jpg", ".jpeg", ".gif", ".bmp"};
	
	public String uploadPath =  "/upload/";
	
	public FileUploadController(){
		try{
			File file = new File(PathUtils.getWebRootPath() + uploadPath);
			if(!file.exists()){
				file.mkdirs();
			}
			log.info("文件上传功能创建成功:"  + file.getPath());
		}catch(Exception e){
			log.error("文件上传功能创建失败" +e.getMessage());
		}
	}

	@RenderJsonInvok(errorMsg = "操作失败,请检查文件")
	@RequestMapping("/image.action")
	@ResponseBody
	public RenderJson image (@RequestParam("file") MultipartFile file) throws Exception{
			log.info("文件上传:fileName："+file.getOriginalFilename());
			//是否在白名单
			String suffix  = FileUtils.parseSuffix(file.getOriginalFilename());
			if(!FileUtils.isWhiteList(suffix, images)){
				throw new MyException("文件后缀不是白名单中" + file.getOriginalFilename());
			}
			String fileName = uploadPath + UUID.randomUUID().toString() +suffix;
		    String path= PathUtils.getWebRootPath() +  fileName;
		    log.info(path);
	        File newFile=new File(path);
	        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
	        newFile.createNewFile();
	        file.transferTo(newFile);
			return RenderJson.Instance().SUCCESS().setMessage("上传成功").setObj(fileName);
	}
}

package com.alex.springmvc.form.example;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests.
 */
@Controller
public class FileUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private FileModel file;
	
	@Autowired
	@Qualifier("fileUploadValidator")
	//自动装载FileUploadValidator类进入到validator
	private Validator validator;
	
	@InitBinder
	//加载验证器
	private void initBind(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	/**
	 * 引向/views/form/fileUpload.jsp中
	 * 
	 * @return
	 */
	@RequestMapping(value="/fileUploadPage",method=RequestMethod.GET)
	public ModelAndView fileUploadPage(){
		return new ModelAndView("form/fileUpload", "command", file);
	}
	
	/**
	 * /views/form/fileUpload.jsp提交后跳转到该页面
	 * 
	 * @param file
	 * @param modelMap
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/fileUploadPage",method=RequestMethod.POST)
	public String fileUpload(@ModelAttribute("fileModel") @Validated FileModel file,BindingResult bindingResult,ModelMap modelMap) throws IOException{
		
		//获取验证的错误信息
		if(bindingResult.hasErrors()){
			logger.info("no file");
			return "form/fileUpload";
		}
		
		logger.info("fetching file");
		
		MultipartFile multipartFile = file.getFile();
		String uploadPath = context.getRealPath("")+File.separator +"upload"+File.separator;
		uploadPath = "C:\\tool\\eclipse_jee_luna_win32\\test_workspace_server\\upload\\";
		//上传路径为绝对路径
		logger.info("uploadPath："+uploadPath);
		//文件拷贝（文件的转化为字节数组，然后通过输出流将文件写入到路径中）
		FileCopyUtils.copy(file.getFile().getBytes(), new File(uploadPath+file.getFile().getOriginalFilename()));
		String fileName = multipartFile.getOriginalFilename();
		modelMap.addAttribute("fileName", fileName);
		return "form/successUploadFile";
	}
	
	/**
	 * @return 页面使用的对象
	 */
	@ModelAttribute("fileModel")
	public FileModel createFileModel(){
		return new FileModel();
	}
	
}

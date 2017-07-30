package com.alex.springmvc.filedownload.example;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileDownloadController {
	
	//内部文件名，放在classpath下面
	private static final String INTERNAL_FILE="irregular-verbs-list.pdf";
	//外部文件名，放在系统的绝对路径下面
	private static final String EXTERNAL_FILE_PATH="C:\\tool\\eclipse_jee_luna_win32\\test_workspace_server\\testdownload\\Spring4MVCAngularJSExample.zip";
	
	/**
	 * 输入http://localhost:8080/SpringMVC/downloadindex或者http://localhost:8080/SpringMVC/downloadindex1都可以跳转到
	 * /views/download/downloadPage.jsp
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/downloadindex","/downloadindex1"}, method = RequestMethod.GET)
	public String getHomePage(ModelMap model) {
		return "download/downloadPage";
	}

	/*
	 * Download a file from 
	 *   - inside project, located in resources folder.
	 *   - outside project, located in File system somewhere. 
	 */
	/**
	 * 按照type的类型进行下载
	 * 
	 * @param response
	 * @param type
	 * @throws IOException
	 */
	@RequestMapping(value="/downloadindex/download/{type}", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @PathVariable("type") String type) throws IOException {
	
		File file = null;
		
		if(type.equalsIgnoreCase("internal")){
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();//获取内部资源
			file = new File(classloader.getResource(INTERNAL_FILE).getFile());
		}else{
			file = new File(EXTERNAL_FILE_PATH);//外部文件资源
		}
		
		if(!file.exists()){
			String errorMessage = "Sorry. The file you are looking for does not exist";
			System.out.println(errorMessage);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}
		//查找MIME类型下载文件的内容。可以是application/pdf, text/html,application/xml,image/png等等。
		String mimeType= URLConnection.guessContentTypeFromName(file.getName());
		if(mimeType==null){
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}
		
		System.out.println("mimetype : "+mimeType);
		//将内容类型与上述发现的MIME类型响应（HttpServletResponse）。
        response.setContentType(mimeType);
        
        //为响应设置内容处理标头。//随着“附件”文件将下载。可能会显示一个“另存为”基于浏览器的设置对话框。
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));

        
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));//通过“内联”浏览器将尝试显示内容到浏览器中（图片，PDF，文本，...）。对于其他内容类型，文件将直接下载。
        //针对以上找到MIME类型设置内容长度。
        response.setContentLength((int)file.length());

		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));//从InputStream中复制字节响应到 OutputStream。

        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
	}

}
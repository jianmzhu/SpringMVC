package com.alex.springmvc.multiaction.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 	MultiActionController为过期类，可以使用AbstractController和SimpleController
 * 
 * 
 * 	在使用Spring提供的控制器时，AbstractController和SimpleFormController是应用得最多的。
 * 	AbstractController是最基本的Controller，可以给予用户最大的灵活性。
 * 	SimpleFormController则用于典型的表单编辑和提交。
 * 	在一个需要增,删,改，查的需求中，增加和修改扩展SimpleFormController完成，删除和查询则扩展AbstractController完成。
 *  但是像上面那样完成某一业务对象的增，删，改，查，都属于一类相关的业务。
 *  把一类相关的操作分布到不同的类去完成，违返“高内聚”的设计原则。
 *  这样四个业务操作需要四个类来完成，造成太多的类文件，难以维护和配置。 
 *  所以Spring借鉴Struts的DispatchAction提供了类似功能的MultiActionController。
 *  可以实现不同的请求路径对应MultiActionController中的不同方法，这样就可以把相关的操作都在一个类的相关方法中完成。
 *  这样使得这个类具有“高内聚”，也利于系统的维护，还避免了重复代码。
 * 
 * @author xiaoming
 *
 */
@SuppressWarnings("deprecation")
public class UserController extends MultiActionController{
	/**
	 * 对应页面有test名字的映射
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView test(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView modelAndView = new ModelAndView("multiaction/test");
		modelAndView.addObject("message","Test!!!!");
		return modelAndView;
	}
	
	/**
	 * 对应页面有add名字的映射
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView modelAndView = new ModelAndView("multiaction/add");
		modelAndView.addObject("message","Add!!!!");
		return modelAndView;
	}
	
	/**
	 * 对应页面有remove名字的映射
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView remove(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView modelAndView = new ModelAndView("multiaction/remove");
		modelAndView.addObject("message","Remove!!!!");
		return modelAndView;
	}
}

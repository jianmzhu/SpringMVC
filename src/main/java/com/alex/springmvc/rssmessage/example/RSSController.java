package com.alex.springmvc.rssmessage.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RSSController {

	/**
	 * 通过http://localhost:8080/SpringMVC/rssfeed跳转到该控制器
	 * 然后跳转到视图rssViewer（参见servlet-context.xml中的RSS源配置）
	 * 
	 * <beans:bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
	 * 	    <beans:property name="order" value="4"/>
	 * </beans:bean>
	 * <beans:bean id="rssViewer" class="com.alex.springmvc.rssmessage.example.RSSFeedViewer" />
	 * 
	 * @return
	 */
	@RequestMapping(value = "/rssfeed", method = RequestMethod.GET)
	public ModelAndView getFeedInRss() {
		List<RSSMessage> items = new ArrayList<RSSMessage>();
		RSSMessage content = new RSSMessage();
		content.setTitle("Spring教程");
		content.setUrl("http://www.yiibai/spring");
		content.setSummary("Spring tutorial summary...");
		content.setCreatedDate(new Date());
		items.add(content);
		RSSMessage content2 = new RSSMessage();
		content2.setTitle("Spring MVC教程");
		content2.setUrl("http://www.yiibai/spring_mvc");
		content2.setSummary("Spring MVC tutorial summary...");
		content2.setCreatedDate(new Date());
		items.add(content2);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("rssViewer");
		mav.addObject("feedContent", items);
		return mav;
	}
}
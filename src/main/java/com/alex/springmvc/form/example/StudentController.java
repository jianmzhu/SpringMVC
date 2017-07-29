package com.alex.springmvc.form.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests.
 */
@Controller
public class StudentController {

	private static final Logger logger = LoggerFactory
			.getLogger(StudentController.class);
	@Autowired
	private Student student;

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Autowired
	@Qualifier("studentValidator")
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@InitBinder
	private void initBind(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	/**
	 * 这里的第一个服务方法student()，我们已经在ModelAndView对象中传递了一个名为“command”的空对象，
	 * 因为如果在JSP中使用<form：form>标签，spring框架需要一个名为“command”的对象文件。
	 * 所以当调用student()方法时，它返回student.jsp视图。
	 * 
	 * @return ModelAndView
	 *         $1:page的名字，$2:model.addAttribute里面的name，$3:model.addAttribute里面的value
	 * 
	 *         跳转到/WEB-INF/views/form/student.jsp
	 */
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student() {
		System.out.println(student);
		return new ModelAndView("form/student", "command", student);
	}
	
	@RequestMapping(value = "/studentValidator", method = RequestMethod.GET)
	public ModelAndView studentValidator() {
		System.out.println(student);
		return new ModelAndView("form/studentValidator", "command", student);
	}

	/**
	 * 第二个服务方法addStudent()将在 /SpringMVC/addStudent上的POST方法提交时调用。
	 * 将根据提交的信息准备模型对象。最后，将从服务方法返回“result”视图，这将最终渲染result.jsp视图。
	 * 
	 * @ModelAttribute("studentModel")Student 
	 *                                        student为student.jsp页面的student对象，是一个新对象
	 *                                        ，与student()方法中的command对象的student无关
	 * 
	 * @param student
	 * @param model
	 * @return 跳转到/WEB-INF/views/form/result.jsp
	 */
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("studentModel") Student student,
			Model model) {
		logger.info(student.toString());
		model.addAttribute("name", student.getName());
		model.addAttribute("id", student.getId());
		model.addAttribute("age", student.getAge());
		model.addAttribute("password", student.getPassword());
		model.addAttribute("address",
				student.getAddress().replace("\n", "<br/>"));
		model.addAttribute("isMaster", student.getIsMaster() ? "是" : "否");
		model.addAttribute("restLessons", student.getRestLessons());
		model.addAttribute("gender", student.getGender());
		model.addAttribute("favoriteNumber", student.getFavoriteNumber());
		model.addAttribute("country", student.getCountry());
		model.addAttribute("skills", student.getSkills());		
		model.addAttribute("hiddenId", student.getHiddenId());
		return "form/result";
	}
	
	/**
	 * 第二个服务方法addStudent()将在 /SpringMVC/addStudent上的POST方法提交时调用。
	 * 将根据提交的信息准备模型对象。最后，将从服务方法返回“result”视图，这将最终渲染result.jsp视图。
	 * 
	 * @ModelAttribute("studentModel")Student 
	 *                                        student为student.jsp页面的student对象，是一个新对象
	 *                                        ，与student()方法中的command对象的student无关
	 * 
	 * @param student
	 * @param model
	 * @return 跳转到/WEB-INF/views/form/result.jsp
	 */
	@RequestMapping(value = "/addStudentValidator", method = RequestMethod.POST)
	public String addStudentValidator(@ModelAttribute("studentModel") @Validated Student student,
			BindingResult bindingResult,
			Model model) {
		logger.info(student.toString());
		
		if(bindingResult.hasErrors()){
			return "form/studentValidator";
		}
		
		model.addAttribute("name", student.getName());
		model.addAttribute("id", student.getId());
		model.addAttribute("age", student.getAge());
		model.addAttribute("password", student.getPassword());
		model.addAttribute("address",
				student.getAddress().replace("\n", "<br/>"));
		model.addAttribute("isMaster", student.getIsMaster() ? "是" : "否");
		model.addAttribute("restLessons", student.getRestLessons());
		model.addAttribute("gender", student.getGender());
		model.addAttribute("favoriteNumber", student.getFavoriteNumber());
		model.addAttribute("country", student.getCountry());
		model.addAttribute("skills", student.getSkills());		
		model.addAttribute("hiddenId", student.getHiddenId());
		return "form/result";
	}
	
	/**
	 * 页面上的studentValidator.jsp需要一个student对象，初始化页面由本类的studentValidator()提供，
	 * 但addStudentValidator()返回的时候可能报错要重新返回studentValidator.jsp页面，则需要一个这样子的对象提供。
	 * 
	 * @return
	 */
	@ModelAttribute("studentModel")
	public Student createStudent(){
		return new Student();
	}

	/**
	 * @return 返回前台用${restLessonList}来获取list，一般用于多选框上item直接赋值${restLessonList}
	 *         如<form:checkboxes items="${restLessonList}" path="restLessons"/>
	 */
	@ModelAttribute("restLessonList")
	public List<String> getRestLessons() {
		List<String> restLessonList = new ArrayList<String>();
		restLessonList.add("chinese");
		restLessonList.add("English");
		restLessonList.add("Math");
		restLessonList.add("music");
		return restLessonList;
	}

	/**
	 * @return 
	 *         返回前台用${favoriteNumberList}来获取list，一般用于多项单选按钮上item直接赋值${restLessonList
	 *         } 如<form:buttonRadios items="${favoriteNumberList}"
	 *         path="favoriteNumber"/>
	 */
	@ModelAttribute("favoriteNumberList")
	public List<String> getFavoriteNumber() {
		List<String> favoriteNumberList = new ArrayList<String>();
		favoriteNumberList.add("1");
		favoriteNumberList.add("2");
		favoriteNumberList.add("3");
		favoriteNumberList.add("4");
		return favoriteNumberList;
	}

	/**
	 * @return 返回前台用${countryList}来获取Map，一般用于下拉列表中item直接赋值${countryList}
	 *         如<form:select path="country"> <form:option value=""
	 *         label="==请选择=="/> <form:options items="${countryList}"/>
	 *         </form:select>
	 */
	@ModelAttribute("countryList")
	public Map<String, String> getCountryList() {
		Map<String, String> countryList = new HashMap<String, String>();
		countryList.put("US", "United States");
		countryList.put("CH", "China");
		countryList.put("SG", "Singapore");
		countryList.put("MY", "Malaysia");
		return countryList;
	}

	/**
	 * @return 返回前台用${skillsList}来获取Map，一般用于下拉列表中item直接赋值${skillsList}
	 *         如<form:select path="skills" items="${skillsList}" multiple="true"/>
	 */
	@ModelAttribute("skillsList")
	public Map<String, String> getSkillsList() {
		Map<String, String> skillsList = new HashMap<String, String>();
		skillsList.put("Hibernate", "Hibernate");
		skillsList.put("Spring", "Spring");
		skillsList.put("Apache Hadoop", "Apache Hadoop");
		skillsList.put("Struts", "Struts");
		return skillsList;
	}
}

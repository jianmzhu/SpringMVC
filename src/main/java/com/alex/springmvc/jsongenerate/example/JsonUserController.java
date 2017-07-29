package com.alex.springmvc.jsongenerate.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/JsonGenerateUser")
public class JsonUserController {
	
   @RequestMapping(value="/{name}", method = RequestMethod.GET)
   //@PathVariable String name取路径里面的http://localhost:8080/SpringMVC/JsonGenerateUser/{name}中{name}的值
   //@ResponseBody用来返回JsonUser对象解析成Json的结果，JsonUser对象无需注明值，spring自动进行协议转换
   //需要用到以下三个jar包
   // jackson-databind-2.8.9.jar
   // jackson-annotations-2.8.0.jar
   // jackson-core-2.8.9.jar
   public @ResponseBody JsonUser getUser(@PathVariable String name) {
      JsonUser user = new JsonUser();
      user.setName(name);
      user.setId(1);
      List<String> list = new ArrayList<String>();
      list.add("1");
      list.add("2");
      list.add("3");
      user.setTestList(list);
      user.setYuans(7.8);
      Map<String, String> map = new HashMap<String, String>();
      map.put("test", "1234");
      user.setTestMap(map);
      return user;
   }
}

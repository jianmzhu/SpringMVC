package com.alex.springmvc.xmlgenerate.example;

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
@RequestMapping("/XmlGenerateUser")
public class XmlUserController {

   @RequestMapping(value="/{name}", method = RequestMethod.GET)
   //@PathVariable String name取路径里面的http://localhost:8080/SpringMVC/XmlGenerateUser/{name}中{name}的值
   //@ResponseBody用来返回XmlUser对象解析成xml的结果，XmlUser对象里面的元素需要在set的时候加上@XmlElement才会使该值域生效
   public @ResponseBody XmlUser getUser(@PathVariable String name) {
      XmlUser user = new XmlUser();
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

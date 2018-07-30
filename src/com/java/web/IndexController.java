package com.java.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.bean.Result;
import com.java.bean.User;
import com.java.service.DepotService;
import com.java.service.UserService;

@Controller
public class IndexController
{
	@Autowired
	private UserService userService;
	
	// 对一些请求的拦截    在 spring-web.xml 进行配置会去/WEB-INF/jsp/的路径下寻找对应的jsp文件。
	@RequestMapping("/")
	public String main() {
		return "login";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/depots")
	public String first() {
		return "depots";
	}

	@RequestMapping("/products")
	public String product() {
	    return "products";
	}
	
	@RequestMapping("/depotitems")
	public String depotitem() {
	    return "depotitems";
	}
	
	// 执行登陆的请求
	@RequestMapping(value = "/tologin", method = RequestMethod.POST)
	@ResponseBody
	public Result<User> tologin(@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getPassword();

		Result<User> ret = new Result<>();
		User rs = userService.selectUser(username);      // 通过用户名查询用户信息。
		if (rs.getPassword().equals(password)) {
			ret.setCode(200);
			ret.setMessage("SUCCESS");
		}else {
			ret.setCode(206);
			ret.setMessage("FAILED");
		}
		ret.setData(user);
		
		System.out.println(ret);
		return ret;
	}
}

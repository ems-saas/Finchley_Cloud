package com.tiansu.saas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 *
 * @author Alexlin
 * Date:2018/9/18
 * Time:19:25
 */
@RestController
@RefreshScope

public class TestController {

	@Value("${env}")
	private String env;

	@GetMapping("/getEnv")
	public String showEnv(){
		return env;
	}





}

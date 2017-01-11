package org.william.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.william.service.IDubboStudyService;
import org.william.util.LoggerUtil;

@Controller
public class ConsumerController {
	
	@Autowired
	private IDubboStudyService callDubboService;
	
	
	@RequestMapping(value="/ping",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String ping(){
		LoggerUtil.info(this, "----consumer started!!!");
		return "consumer started";
	}
	

	@RequestMapping(value="/callDubboService",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String callDubboService(){
		LoggerUtil.info(this, "begin to call william dubbo service!!!");
		//IDubboStudyService callBubboSevice =(IDubboStudyService) SpringContextUtil.getBean("huaweiDubboStudyInterfaceService");
		String rsp =  callDubboService.dubboStudyMethod();
		LoggerUtil.info(this, "----END---call william dubbo service!!!");
		return rsp;
	}
	

}

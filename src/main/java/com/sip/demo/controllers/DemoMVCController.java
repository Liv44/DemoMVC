package com.sip.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoMVCController {
	@GetMapping("/display")
	public String displayMessage() 
	{
		return "message.html";
	}
}

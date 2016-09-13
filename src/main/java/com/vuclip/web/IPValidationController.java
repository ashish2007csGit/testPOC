package com.vuclip.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vuclip.model.UserVO;
import com.vuclip.service.IPValidationService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IPValidationController {
	
	private static final Logger logger = LoggerFactory.getLogger(IPValidationController.class);
	
	@Autowired
	IPValidationService iPValidationService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * return the Validation message from service basis on User IP
	 */
	@RequestMapping(value = "/dvs.do", method = RequestMethod.GET)
	public ModelAndView validateDVSUser(HttpServletRequest request,HttpServletResponse response) {
		UserVO user = new UserVO();
		user.setUserRemoteIP(request.getRemoteAddr());
		String rurl = request.getParameter("rurl");
		String validateDVSUserResponse = iPValidationService.validateDVSUser(user);
		 return new ModelAndView("redirect:"+ rurl+"?success="+validateDVSUserResponse);
		 //return new ModelAndView("redirect:" + "http://www.yahoo.com/search?p=vuclip&fr=yfp-t-704");
	}
	
	
}

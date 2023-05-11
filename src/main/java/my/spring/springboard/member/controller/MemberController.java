package my.spring.springboard.member.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.springboard.member.service.MemberService;
import my.spring.springboard.member.vo.MemberVO;

@Controller
@RequestMapping(value = "/member")
@SessionAttributes(value = {"loginMember"})
public class MemberController {

	Logger log = LogManager.getLogger("case3");

	@Autowired
	private MemberService service;

	@ModelAttribute(value = "loginMember")
	public MemberVO createMember() {
		return new MemberVO();
	}

	// 회원가입 post
	@PostMapping(value = "/register")
	public String postRegister(MemberVO member) throws Exception {
		log.info("post register");

		service.register(member);

		return "redirect:/resources/login.html";
	}

	@PostMapping(value = "/login")
	public String login(MemberVO member) {
		log.info("post login");
		log.info(member);

		MemberVO login = service.login(member);
		
		if(login == null) {
			return "redirect:/resources/login.html";
		}else {
			log.debug(login);
			return "articleList";
		}
		
	}
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(HttpSession session) throws Exception{
//		
//		session.invalidate();
//		
//		return "redirect:/";
//	}
}

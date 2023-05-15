package my.spring.springboard.post.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import my.spring.springboard.post.vo.CommentVO;

@Controller
public class CommentController {
	
	Logger log = LogManager.getLogger("case3");

	@PostMapping("comment")
	public CommentVO insertComment(CommentVO comment, Model model) {
		log.debug(comment);
		
		return null;
	}
}

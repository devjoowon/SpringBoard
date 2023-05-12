package my.spring.springboard.post.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.springboard.post.service.PostService;
import my.spring.springboard.post.vo.PostVO;

@Controller
@RequestMapping(value = "/post")
//@SessionAttributes(value = {})
public class PostController {
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private PostService service;
	
	// 게시글 목록 보기
	@GetMapping(value = "/postList")
	public String selectPostList(Model model){
		
		List<PostVO> postList = service.selectPostList();
		model.addAttribute("postList", postList);
		
		return "postList";
	}
	
	// 게시글 세부사항 조회
	@GetMapping(value = "/postDetail")
	public String selectPostById(PostVO post, Model model) {
		
		PostVO postDetail = service.selectPostById(post);
		
		log.debug(post);
		
		model.addAttribute("postDetail",postDetail);
		
		
		
		return "postDetail";
	}
}

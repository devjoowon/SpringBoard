package my.spring.springboard.post.service;

import java.util.List;

import my.spring.springboard.post.vo.PostVO;

public interface PostService {
	
	public List<PostVO> selectPostList();
	
	public PostVO selectPostById(PostVO post);
}

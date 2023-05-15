package my.spring.springboard.post.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.spring.springboard.post.dao.PostDAO;
import my.spring.springboard.post.vo.PostVO;

@Service
public class PostServiceImpl implements PostService {
	
	private Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private PostDAO postDao;
	
	// 게시글 목록 보기
	@Override
	public List<PostVO> selectPostList() {

		return postDao.selectPostList();
	}

	// 게시글 세부사항 조회
	@Override
	public PostVO selectPostById(PostVO post) {
		PostVO result = postDao.selectPostById(post);
		result.setComments(postDao.selectCommentsByPostId(post.getPostId()));
		
		return result;
	}
	
}

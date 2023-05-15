package my.spring.springboard.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.spring.springboard.post.vo.CommentVO;
import my.spring.springboard.post.vo.PostVO;

@Repository
public class PostDAOImpl implements PostDAO {

	private Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private SqlSession session;
	
	// 게시글 목록 보기
	@Override
	public List<PostVO> selectPostList() {
		
		return session.selectList("myPost.selectPostList");
	}
	
	// 게시글 세부사항 조회
	@Override
	public PostVO selectPostById(PostVO postVo) {
		
		PostVO post = session.selectOne("myPost.selectPostById", postVo);
		
		log.debug(post);
		
		return post;
	}
	
	@Override
	public List<CommentVO> selectCommentsByPostId(int postId) {
		List<CommentVO> comments = session.selectList("myPost.selectCommentsByPostId", postId);
		
		return comments;
	}
	
	
	
}

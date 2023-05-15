package my.spring.springboard.post.dao;

import java.util.List;

import my.spring.springboard.post.vo.CommentVO;
import my.spring.springboard.post.vo.PostVO;

public interface PostDAO {
	
	// 게시글 목록
	public List<PostVO> selectPostList();
	
	// 게시글 세부사항 조회 (게시글 목록에서 게시글 제목 클릭 시 접속되는 화면)
	public PostVO selectPostById(PostVO postVo);
	
	public List<CommentVO> selectCommentsByPostId(int postId);
	// 게시글 작성 (이미지 첨부 기능 추가)
	
	
	// 게시글 수정
	
	// 게시글 삭제 
}

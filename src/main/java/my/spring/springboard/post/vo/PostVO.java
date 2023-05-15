package my.spring.springboard.post.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostVO {
	
	private int postId;
	private String postTitle;
	private String postWriter;
	private String postContent;
	private Date postDate;
	private int postLikeNum;
	private int postDislikeNum;
	private List<CommentVO> comments;
}

package my.spring.springboard.post.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {
	
	private int commentId;
	private String userId;
	private int postId;
	private String content;
}

/**
 * 
 */

function updateReply(postId, user_id) {
	let comment = $('#comment-input').val();
	if(user_id =="" || user_id ==undefined || user_id==null){
		 	alert("세션이 만료되었습니다. 로그인으로 돌아갑니다. ")
  			window.location.replace("./login.html");
		  	return
	}

 	if (comment == null || comment == "") {
		alert('댓글 내용을 입력해주세요 ')
		return;
	}
 	
 	
	$.ajax({
		url: '/springboard/comment',
		type: 'POST',
		data: {
			postId,
			userId: user_id,
			content: comment
		},
		success: function(result) {
			const newComment = `
			      <div class="d-flex flex-row mb-2" id="comment">
			        <img src="https://i.imgur.com/9AZ2QX1.jpg" width="40" class="rounded-image">
			        <div class="d-flex flex-column ml-2">
			          <span class="name">${result["comment"].userId} : </span> 
			        </div>
			        <div class="comment-text" id="commentContent">
			          ${result['comment'].content}
			        </div>
			      </div>
			    `;

		    $('#comment-list').append(newComment);
			$('#comment-input').val("");
		},
		error: function() {
			alert('에러 !');
		}
	})
}
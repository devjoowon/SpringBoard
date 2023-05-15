<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html lang="en">
<head>

<meta charset="utf-8">
<title>게시글 보기</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">

<link href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="./css/postdetail.css" rel="stylesheet">
<link href="./css/postlist.css" rel="stylesheet">
<script src="./js/postlist.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
	<script src="/springboard/resources/js/comment.js"></script>
<script src="./js/like.js"></script>
</head>


<body id="body-pd">

	<div class="wrapper d-flex">
		<div class="sidebar">
			<ul>
				<li><a href="/springboard/post/postList"><i class="fas fa-home"></i>게시글 목록</a></li>
				<li><a href="/springboard/post/postNew"><i class="fas fa-file"></i>새 글 작성 </a></li>
			</ul>

		</div>

		<div class="container-fluid" style="margin-left: 250px">
			<div class="row d-flex justify-content-center">
				<main class="col-md-10">
					<div
						class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
						<h1 class="h2">${postDetail.postTitle}</h1>
					</div>

					<div class="container-fluid" id="contentBox">
						${postDetail.postContent}
					</div>
					<hr>
					<div class="container-fluid" style="min-height: 10px";>
						<div class="d-flex flex-row icons d-flex align-items-center">
							<c:if test="${isLikeChecked}">
								<button type="submit" id="likeButton"
									style="border: none; background: none; color: gray"
									onclick="cancelLike(${postDetail.postId}, '${loginId}')">
									<i class="fa fa-heart"></i>
								</button>
							</c:if>
							<c:if test="${not isLikeChecked}">
								<button type="submit" id="likeButton"
									style="border: none; background: none; color: gray"
									onclick="addLike(${postDetail.postId}, '${loginId}')">
									<i class="fa fa-thumbs-o-up" style="color: red"></i>
								</button>
							</c:if>
							<div id="postLikeNum">
								좋아요 ${postDetail.postLikeNum}
							</div>
							<c:if test="${not isLikeChecked}">
								<button type="submit" id="likeButton"
									style="border: none; background: none; color: gray"
									onclick="addLike(${postDetail.postId}, '${loginId}')">
									<i class="fa fa-thumbs-o-down" style="color: red"></i>
								</button>
							</c:if>
							<div id="postDislikeNum">
								싫어요 ${postDetail.postDislikeNum}
							</div>
						</div>
					</div>
					
					<hr>
					
					<div class="comments">
								<div id = "comment-list">
									<c:forEach var="comment" items="${commentList}">
										<div class="d-flex flex-row mb-2" id="comment">
											<img src="https://i.imgur.com/9AZ2QX1.jpg" width="40"
												class="rounded-image">
											<div class="d-flex flex-column ml-2">
												<span class="name">${comment.userId} : </span> 
											</div>
											<div class="comment-text" id="commentContent">
												${comment.content}
											</div>
										</div>
									</c:forEach>										
								</div>

								<div class="comment-input">
									<input type="text" id="comment-input" class="form-control">
									<div class="fonts">
										<button type="submit"
											style="border: none; background: none; color: gray"
											onclick="updateReply('${postDetail.postId}', '${loginMember.memberId}')">
											<i class="fa fa-reply"></i>
										</button>
									</div>
								</div>

							</div>
					
				</main>
			</div>
		</div>
	</div>

</body>
</html>






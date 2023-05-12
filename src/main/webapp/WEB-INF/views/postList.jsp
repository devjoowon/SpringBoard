<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">

<link href="./css/postlist.css" rel="stylesheet">
</head>
<body>
	<header
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">
			${loginMember.memberName} 님 안녕하세요 </a>

		<div class="navbar-nav">
			<div class="nav-item text-nowrap">
				<a class="nav-link px-3" href="/dashboard/post-create.jsp">새 글
					작성</a>
			</div>
		</div>
	</header>

	<div class="container-fluid">
		<div class="row d-flex justify-content-center">


			<main class="col-md-10">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">자유 게시판</h1>
				</div>

				<div class="table-responsive">
					<table class="table table-striped table-sm">
						<thead>
							<a>
								<tr>
									<th scope="col">게시글 번호</th>
									<th scope="col">게시글 제목</th>
									<th scope="col">작성자</th>
									<th scope="col">작성일</th>
									<th scope="col">좋아요</th>
									<th scope="col">싫어요</th>
								</tr>
							</a>
						</thead>
						<tbody>

							<c:forEach var="vo" items="${postList}">
								<tr>

									<td><c:out value="${vo.postId}" /></td>
									<td><a href="/springboard/post/postDetail?postId=${vo.postId}">
											<c:out value="${vo.postTitle}" />
									</a></td>
									<td><c:out value="${vo.postWriter}" /></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd"
											value="${vo.postDate}" /></td>
									<td><c:out value="${vo.postLikeNum}" />
									<td><c:out value="${vo.postDislikeNum}" />
								</tr>

							</c:forEach>

						</tbody>
					</table>
				</div>
			</main>
		</div>
	</div>
</body>
</html>
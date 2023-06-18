<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:useBean id="toDay" class="java.util.Date" />

<!doctype html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- include_common_top -->
<jsp:include page="../common/include_common_top.jsp" />
<!-- include_common_top -->
<link rel="stylesheet" href="css/shop/qna.css">

<script type="text/javascript">
function openWriteAnswerModal() {
	$('#writeAnswerModal').modal('show');
}

function openAlert(){
    Swal.fire({
        icon: 'warning',
        title: '답변이 완료된 글 입니다.',
        text: '답변이 완료된 글은 조작할 수 없습니다!',
        confirmButtonColor: '#3085d6',
        confirmButtonText: '확인'
    });
}
</script>


</head>

<body>
	<!-- Preloader -->
	<div id="preloader">
		<div class="spinner-grow" role="status">
			<span class="sr-only">Loading...</span>
		</div>
	</div>

	<!-- Header Area -->
	<jsp:include page="../common/include_common_header.jsp" />
	<!-- Header Area End -->

	<!-- Breadcumb Area -->
	<div class="breadcumb_area">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<h5>Board</h5>
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="index">Home</a></li>
						<li class="breadcrumb-item active">Question Detail</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcumb Area -->
	<div class="shortcodes_area section_padding_100">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="shortcodes_title mb-30">
						<h4>Question</h4>
					</div>
					<c:set var="qNo" value="${question.qNo}"></c:set>
					<div class="shortcodes_content">
						<div class="table-responsive">
							<table class="table mb-0 table-bordered">
								<thead>
									<tr>
										<th scope="col" class="question_title" style="vertical-align: middle;">${question.qTitle}</th>
										<th scope="col" class="question_writer" style="vertical-align: middle;">${question.uNickName}</th>
										<c:set var="dateString" value="${question.qInsertDate}" />
										<fmt:parseDate var="date" value="${dateString}"
											pattern="yyyy-MM-dd HH:mm:ss" />
										<fmt:formatDate var="formattedDate" value="${date}"
											type="date" pattern="yyyy년-MM월-dd일" />
										<fmt:formatDate var="formattedDate2" value="${date}"
											type="date" pattern="HH시:mm분" />
										<th scope="col" class="board_date" style="vertical-align: middle;">${formattedDate}<br />${formattedDate2}</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td id="board_content_td" colspan="3">${question.qContent}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div id="qna_btn_container">
			       	<c:choose>
					    <c:when test="${question.qAnswerd}">
							<c:if test="${question.uid eq SUID}">
								<input class="btn btn-warning btn-sm" type="button" value="수정" onclick="openAlert()" />&nbsp;&nbsp;
								<input class="btn btn-danger btn-sm" type="button" value="삭제" onclick="openAlert()" />&nbsp;&nbsp;
	                    	</c:if>
							<c:if test="${SUID == 'admin'}">
							<input class="btn btn-primary btn-sm" type="button" value="답변 달기" onclick="openAlert()" />&nbsp;&nbsp;
							</c:if>
					    </c:when>
					    <c:otherwise>
					    	<c:if test="${question.uid eq SUID}">
								<input class="btn btn-warning btn-sm" type="button" value="수정" onclick="openModifyModal()" />&nbsp;&nbsp;
								<input class="btn btn-danger btn-sm" type="button" value="삭제" onclick="deleteBoard()" />&nbsp;&nbsp;
	                    	</c:if>
							<c:if test="${SUID == 'admin'}">
							<input class="btn btn-primary btn-sm" type="button" value="답변 달기" onclick="openWriteAnswerModal()" />&nbsp;&nbsp;
							</c:if>
					    </c:otherwise>
					</c:choose>
					<a href="question_list"><input class="btn btn-secondary btn-sm" type="button" value="목록" /></a>&nbsp;&nbsp;
					</div>
				</div>
			</div>
			
			<!------------------------------- Answer ------------------------------->
			<div class="row">
				<div class="col-12">
					<div class="shortcodes_title mb-30">
						<h4>Answer</h4>
					</div>
					<c:set var="aNo" value="${answer.aNo}"></c:set>
					<div class="shortcodes_content">
						<div class="table-responsive">
							<table class="table mb-0 table-bordered">
								<thead>
									<tr>
										<c:if test="${not empty answer}">
										<th scope="col" class="question_title" style="vertical-align: middle;">${answer.aTitle}</th>
										<th scope="col" class="question_writer" style="vertical-align: middle;">관리자</th>
										<c:set var="dateString" value="${answer.aInsertDate}" />
										<fmt:parseDate var="date" value="${dateString}"
											pattern="yyyy-MM-dd HH:mm:ss" />
										<fmt:formatDate var="formattedDate" value="${date}"
											type="date" pattern="yyyy년-MM월-dd일" />
										<fmt:formatDate var="formattedDate2" value="${date}"
											type="date" pattern="HH시:mm분" />
										<th scope="col" class="board_date" style="vertical-align: middle;">${formattedDate}<br />${formattedDate2}</th>
										</c:if>
									</tr>
								</thead>
								<tbody>
									<tr>
									<c:if test="${not empty answer}">
										<td id="answer_content_td" colspan="3">${answer.aContent}</td>
									</c:if>
									<c:if test="${empty answer}">
										<td id="answer_content_td" colspan="3">아직 답변이 달리지 않았습니다. 😢</td>
									</c:if>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<c:if test="${not empty answer}">
					<div id="qna_btn_container">
						<c:if test="${SUID == 'admin'}">
							<input class="btn btn-warning btn-sm" type="button" value="수정" onclick="openModifyModal()" />&nbsp;&nbsp;
							<input class="btn btn-danger btn-sm" type="button" value="삭제" onclick="deleteBoard()" />&nbsp;&nbsp;
                    	</c:if>
					</div>
					</c:if>
				</div>
			</div>
			<!------------------------------- Answer ------------------------------->
		</div>
	</div>
	
	<!------------------------------- writeAnswerModal Start ------------------------------->
	<div class="modal" id="writeAnswerModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="container">
				<h5 class="mb-3" style="display: inline-block; text-align: center;">Answer</h5>
				<form id="qna_answer_form" action="write_answer?qNo=${qNo}" method="post">
						<div class="form-group">
							<label for="aid">작성자 : ${SUNICKNAME}</label>
						</div>
						<div class="form-group">
							<label for="aInsertDate">작성일자 : <fmt:formatDate value='${toDay}'
									pattern='yyyy-MM-dd' /></label>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="aTitle" name="aTitle" placeholder=" title">
						</div>
						<div class="form-group">
							<textarea id="a_content_area" name="aContent" placeholder=" content"></textarea>
						</div>
					<div class="button-container">
						<input type="hidden" id="hidden_qNo" name="qNo" value="${qNo}">
						<button type="button" class="btn btn-primary btn-sm answer_btn new_write">Answer</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-secondary btn-sm" id="cmCancelBtn" data-dismiss="modal">Cancle</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>
	<!------------------------------- writeAnswerModal End ------------------------------->
	


	<!-- Footer Area -->
	<jsp:include page="../common/include_common_bottom.jsp" />
	<!-- Footer Area -->

	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<jsp:include page="../common/include_common_script.jsp" />
	<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
	<script src="js/shop/qna.js"></script>

</body>

</html>
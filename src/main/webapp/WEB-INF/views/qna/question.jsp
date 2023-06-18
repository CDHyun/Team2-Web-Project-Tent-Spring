<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="toDay" class="java.util.Date" />

<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- include_common_top -->
	<jsp:include page="../common/include_common_top.jsp"/>
    <!-- include_common_top -->
    <link rel="stylesheet" href="css/shop/question.css">
	<script type="text/javascript">
	
    var viewedQnas = []; // 조회한 Q&A 번호를 저장할 배열
    
    function toggleQnaContent(element) {
        var contentDiv = $(element).next('.qna-content');
        contentDiv.slideToggle(function() {
            if (contentDiv.is(':visible')) {
                increaseViewCount($(element).closest('tr'));
            } else {
                decreaseViewCount($(element).closest('tr'));
            }
        });
    }
    
    function increaseViewCount(row) {
        var qNo = row.find('th').text();
        if (viewedQnas.includes(qNo)) return; // 이미 조회한 Q&A인 경우 더 이상 증가하지 않도록 처리
        
        var viewCountCell = row.find('td:last-child');
        var viewCount = parseInt(viewCountCell.text());
        viewCountCell.text(viewCount + 1);
        
        viewedQnas.push(qNo); // 조회한 Q&A 번호를 배열에 추가
        
        // viewCount 증가를 서버에 요청
        $.ajax({
            url: "increaseQuestionViewCount", // 서버의 증가시키는 기능을 처리하는 URL
            method: "POST",
            data: { qNo: qNo }, // 서버에 전달할 데이터 (여기서는 qNo를 전달)
            success: function(result) {
            	if(result == 1){
	                console.log("View count increased successfully.");
            	}
            },
            error: function() {
                console.log("Error occurred while increasing view count.");
            }
        });
    }
    
    function decreaseViewCount(row) {
        var qNo = row.find('th').text();
        var index = viewedQnas.indexOf(qNo);
        if (index > -1) {
            viewedQnas.splice(index, 1); // 조회한 Q&A 번호를 배열에서 제거
        }
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
  	<jsp:include page="../common/include_common_header.jsp"/>
    <!-- Header Area End -->
    
    <!-- Breadcumb Area -->
    <div class="breadcumb_area">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <h5>Board</h5>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.do">Home</a></li>
                        <li class="breadcrumb-item active">Board</li>
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
                        <h4>QnA board</h4>
                    </div>
                    <div class="shortcodes_content">
                        <div class="table-responsive">
                            <table class="table mb-0 table-bordered">
                                <thead>
                                    <tr>
                                        <th scope="col" class="board_no">번호</th>
                                        <th scope="col" class="board_title">제목</th>
                                        <th scope="col" class="board_writer">작성자</th>
                                        <th scope="col" class="board_date">날짜</th>
                                        <th scope="col" class="board_count">조회수</th>
                                    </tr>
                                </thead>
                                <tbody id="qna_list_tbody">
                                
                                	<!-- board start -->
									<c:forEach var="qna" items="${qnaList}">
									    <tr>
									        <th scope="row">${qna.qNo}</th>
									        <td>
									            <a href="#" onclick="toggleQnaContent(this);">${qna.qTitle}</a>
									            <div class="qna-content" style="display: none;">${qna.qContent}</div>
									        </td>
									        <td style="text-align: center;">${qna.uNickName}</td>
									        <c:set var="dateString" value="${qna.qInsertDate}" />
									        <fmt:parseDate var="date" value="${dateString}" pattern="yyyy-MM-dd HH:mm:ss" />
									        <fmt:formatDate var="formattedDate" value="${date}" type="date" pattern="yyyy년-MM월-dd일" />
									        <td style="text-align: center;">${formattedDate}</td>
									        <td style="text-align: center;">${qna.qViewCount}</td>
									    </tr>
									</c:forEach>
                                   <!-- board end -->
                                </tbody>
                            </table>
						
                        </div>
                    </div>
                    <div style="text-align: right;">
						<a href="question_write_form"><input type="button" class="btn btn-secondary btn-sm" value="게시글작성" /></a>
                    </div>
                </div>
            </div>
            <%-- 
            <div class="row justify-content-center">
                <div class="col-12 col-lg-9">
                    <!-- Shop Pagination Area -->
                    <div class="shop_pagination_area mt-5">
                        <nav aria-label="Page navigation">
                            <ul class="pagination pagination-sm justify-content-center">

                            	<c:if test="${qnaList.pageMaker.prevPage > 0}">  
	            					<li class="page-item">
	                                    <button class="page-link" onclick="changeQnaList(${data.pageMaker.prevPage});"><i class="fa fa-angle-left" aria-hidden="true"></i></button>
	                               	 </li>
                                </c:if>
                                <c:forEach var="no" begin="${qnaList.pageMaker.blockBegin}" end="${qnaList.pageMaker.blockEnd}">
									<c:if test="${qnaList.pageMaker.curPage == no}">
										<li class="page-item active"><button class="page-link" href="#">${no}</button></li>
									</c:if>
									<c:if test="${qnaList.pageMaker.curPage != no}">
										<li class="page-item"><button class="page-link page" onclick="changeQnaList(${no})">${no}</button></li>
									</c:if>
                                </c:forEach>
                                <c:if test="${qnaList.pageMaker.curPage < qnaList.pageMaker.totPage}">  
	                                <li class="page-item">
				                        <button class="page-link" onclick="changeQnaList(${qnaList.pageMaker.nextPage});"><i class="fa fa-angle-right" aria-hidden="true"></i></button>
			                    	 </li>
                                </c:if>

                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
             --%>
            
            
         </div>
    </div>     
            
    <!-- Footer Area -->
 	<jsp:include page="../common/include_common_bottom.jsp"/>
    <!-- Footer Area -->

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
	<jsp:include page="../common/include_common_script.jsp"/>
	<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
	<script src="js/shop/question.js?after" defer></script>

</body>

</html>
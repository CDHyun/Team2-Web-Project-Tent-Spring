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
    <link rel="stylesheet" href="css/shop/board.css">

	<script type="text/javascript">
	
	 
	function write() {
		var form = document.qna_write_form;
		var qContent = form.qContent.value;
		var qTitle = form.qTitle.value;
		if(qContent == "" || qTitle == ""){
			Toast.fire({ icon: 'warning', title: "필수 입력값을 입력하지 않았습니다.\n 제목과 내용을 모두 입력해주세요" });
			return;
		}
		if($("#q_title_txt").val() == "" || CKEDITOR.instances.q_content_area.getData() == ""){
			Toast.fire({ icon: 'warning', title: "필수 입력값을 입력하지 않았습니다.\n 제목과 내용을 모두 입력해주세요" });
			return;
		}
		/* $("#qna_write_form").attr("action", "qna_write.do");
		$("#qna_write_form").submit(); */
		form.submit();
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
                        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
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
                        <h4>QnA Write</h4>
                    </div>
                    <div class="shortcodes_content">
                        <div class="table-responsive">
                        	<form action="write_question" id="qna_write_form" name="qna_write_form" method="post">
	                            <table class="table mb-0 table-bordered">
	                                <thead>
	                                    <tr>
	                                        <th scope="col" class="board_title"  style="vertical-align: middle;">
	                                        	<input type="text" name="qTitle" id="q_title_txt" placeholder=" title" style=" height: 100%; width: 100%"/>
	                                        </th>
	                                        <th scope="col" class="board_date" style="vertical-align: middle;"><fmt:formatDate value='${toDay}' pattern='yyyy-MM-dd' /></th>
	                                        <th scope="col" class="board_writer" style="vertical-align: middle;">${SUNICKNAME}</th>
	                                        <th scope=col class="board_writer" style="vertical-align: middle;">
	                                        	<select name="qCgNo" style="vertical-align: middle;">
	                                        		<option value="1">문의</option>
	                                        	</select>
	                                        </th>
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                    <tr>
	                                        <td id="qna_content_td" colspan="4">
	                                        	<textarea name="qContent" id="q_content_area" placeholder=" content"></textarea>
	                                        </td>
	                                    </tr>
	                                </tbody>
	                            </table>
                			</form>
                      				<input type="hidden" name="pageno" value="${pageno}" />
                      				<input type="hidden" name="uid" value="${SUID}" />
                        </div>
                    </div>
                    	<div id="qna_btn_container" style="text-align: right;">
							<input class="btn btn-secondary btn-sm qna_btn new_write" type="button" value="등록"/>
							<input class="btn btn-secondary btn-sm qna_btn list" type="button" pageno="${pageno}" value="목록" />
                    	</div>
                </div>
            </div>
            
         </div>
    </div>     
            
    <!-- Footer Area -->
 	<jsp:include page="../common/include_common_bottom.jsp"/>
    <!-- Footer Area -->

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
	<jsp:include page="../common/include_common_script.jsp"/>
	<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
	<script src="js/shop/question.js"></script>

</body>

</html>
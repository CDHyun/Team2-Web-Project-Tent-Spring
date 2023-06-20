<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
     integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
     
     <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />

     
<script type="text/javascript">
	function reply(rrNo,ppCode){
		var rNo = rrNo;
		var pCode = ppCode;
		
		var url = "product_detail?rNo=" + encodeURIComponent(rNo) + "&pCode=" + encodeURIComponent(pCode);
    	window.location.href = url;
	}

</script>

<style>
.material-symbols-outlined {
  font-variation-settings:
  'FILL' 0,
  'wght' 400,
  'GRAD' 0,
  'opsz' 48
}
</style>


<title>리뷰관리</title>
</head>
<body>

<!-- Header Start -->
  <div class="header">
  <jsp:include page="adminSidebar.jsp" />
</div>
  <!-- Header End -->
  	<h3 class="container">Review</h3>
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">No</th>
						<!--  <th style="background-color: #eeeeee; text-align: center;">번호</th>-->
						<th style="background-color: #eeeeee; text-align: center;">상품</th>
						<th style="background-color: #eeeeee; text-align: center;">색상</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">내용</th>
						<th style="background-color: #eeeeee; text-align: center;">별점</th>
						<th style="background-color: #eeeeee; text-align: center;">리뷰답변</th>
					</tr>
				</thead>
					<c:forEach items="${list}" var="dto" varStatus="st">
    					<tr>
      						<td>${st.index+1}</td>
      						<!--<td>${dto.rNo}</td>-->
      						<td>${dto.pName}</td>
     						<td>${dto.pColor}</td>
      						<td>${dto.rTitle}</td>
      						<td>${dto.rContent}</td>
      						<!-- <td>${dto.rScore}</td> -->
      						<td>
      						<c:forEach begin="1" end="${dto.rScore}">
								<span class="material-symbols-outlined">
								star
								</span>
							</c:forEach>
							</td>
      						<td><input type="button" value="reply" class="btn btn-info" size="5" onclick="reply('${dto.rNo}','${dto.pCode}')"></td>
    					</tr>
  					</c:forEach>
			</table>	
		</div>
	</div>

</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
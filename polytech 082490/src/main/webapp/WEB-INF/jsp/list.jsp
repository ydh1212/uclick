<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*,java.net.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>

<meta charset="EUC-KR">
<title></title>

<script>
       document.getElementByName("check").value
       document.getElementByName("keyword").text
       
//        document.getElementByName("check2").value
//        document.getElementByName("keyword2").text
   </script>


<title>list</title>
</head>
<body>

<!-- <div id="search" style="text-align: center;"> -->
<!--   <form id="searchForm" action="./list" method="get" style="margin: 0;padding: 0;"> -->
<!--    <p style="margin: 0;padding: 0;"> -->
<%--     <input type="hidden" name="boardCd" value="${boardCd }" /> --%>
<!--     <input type="text" name="searchWord" size="15" maxlength="30" /> -->
<!--     <input type="button" value="검색" /> -->
<!--    </p>  -->
<!--   </form> -->
<!--  </div> -->



	<form method="post" name="fm" action="searchList">


		<select name="check">
			<option value="checkname">이름</option>
			<option value="checkphone">전화번호</option>
		</select> <input type="text" size="16" name="keyword"> <input type="submit" value="검색">
<!-- 		<br> -->
<!-- 		<select name="check2"> -->
<!-- 			<option value="checkname2">성별</option> -->
<!-- 			<option value="checkphone2">나이</option> -->
<!-- 		</select> <input type="text" size="16" name="keyword2"> <input type="submit" value="검색"> -->
<!-- 		</br> -->
	</form>
</head>
<body>

	<table border="1">
		<tr>
			<td width=150><p align=center>이름</p></td>
			<td width=50><p align=center>성별</p></td>
			<td width=100><p align=center>나이</p></td>
<!-- 			<td width=500><p align=center>전화번호</p></td> -->

		</tr>
		<tbody align="center">
			<c:forEach items="${member}" var="member">
				<tr>
					<td><a href="view?id=${member.id}">${member.name}</td>
					<td>${member.sex}</td>
					<td>${member.age}</td>
					<c:forEach items="${member.phoneList}" var="phone">
                         
<%-- 						<td>${phone.no}</td> --%>
<!--                         <tr> -->
<!--                         <td> -->
<!--                         <td> -->
<!--                         <td> -->
					</c:forEach>

				</tr>
			</c:forEach>
	</table>
	<table width=100>
		<td width=100></td>
		</tr>
	</table>
	<td><input type="button" value="신규" onclick=location.href='insert'></td>

	</p>
	</form>
	</div>
</body>


</html>


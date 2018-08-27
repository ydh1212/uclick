
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*,java.net.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>

</head>
<body>

<FORM METHOD="post" name="fm2" action="phoneDelete" >
<input type=hidden name=mid value="${id.get().getId() }">
</FORM>
	<table border="1">
		<tbody align="center">
			<tr>
				<td height="45" width="100"><b>번호</b>
				<td width="600">${id.get().getId() }</td>
			<tr>
				<td height="45"><b>이름</b>
				<td width="600">${id.get().getName() }</td>
			</tr>

			<tr>
				<td height="45"><b>성별</b>
				<td>${id.get().getSex() }</td>
			</tr>
			<tr>
				<td height="45"><b>나이</b>
				<td>${id.get().getAge() }</td>
			</tr>
		
			
			<c:forEach items="${id.get().getPhoneList()}" var="phone">
                
				<td height="45"><input type=button value="삭제" onclick=location.href='phoneDelete?id=${phone.id }'>
				                
				<b>전화번호</b>
				<td>${phone.no}</td>
				<tr>
				
				

			</c:forEach>
			<FORM METHOD="post" name="fm" action="phoneInsert" >
			<tr>
				<input type=hidden name=id value="${id.get().getId() }">
				<td><input type=submit value="전화번호 추가" onclick=location.href='list.html'></td>
				<td><input type=text name=no size=70 maxlength=70 value=""></td>
				
			</tr>
	</table>

	<table width=550>
		<tr>
			<td width=600></td>
			
			</FORM>
			<td><input type=button value="목록" onclick=location.href='list.html'></td>
			<td><input type=button value="수정" onclick=location.href='update?id=${id.get().getId() }'></td>
			<td><input type=button value="삭제" onclick=location.href='delete?id=${id.get().getId() }'></td>


		</tr>
	</table>
</body>
</html>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*,java.net.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>


<meta charset="EUC-KR">
<title></title>

</head>
<body>

	<table border="1">
		<tr>
			<td width=150><p align=center>이름</p></td>
			<td width=50><p align=center>성별</p></td>
			<td width=100><p align=center>나이</p></td>
			<td width=500><p align=center>전화번호</p></td>
		</tr>
		<tbody align="center">
			<c:forEach items="${users}" var="name">
				<tr>
					 <td><a href="view?id=${name.id}">${name.name}</td>
					<td>${name.sex}</td>
					<td>${name.age}</td>
					<c:forEach items="${name.phoneList}" var="phone">
						<td>${phone.no}</td>
						<tr>
						<td>
						<td>
						<td>

					</c:forEach>

				</tr>
			</c:forEach>
	</table>


	<table width=100>

		<td width=100></td>
		</tr>
	</table>
	 <td><input type="button" value="신규" onclick= location.href='insert'></td>
	<div id="search" style="text-align: center;">
  <form id="searchForm" action="searchList" method="get" style="margin: 0;padding: 0;">
   <p style="margin: 0;padding: 0;">
    <input type="text" name="name" size="15" maxlength="30"  />
    <input type="submit" value="검색"  />
   </p> 
  </form>
 </div>
</body>
</html>


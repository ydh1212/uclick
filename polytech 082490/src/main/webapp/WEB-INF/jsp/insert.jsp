
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*,java.net.*"%>


<html>
<head>
<SCRIPT LANGUAGE="JavaScript">
function submitForm(mode){
fm.action = "save.html";
fm.submit();
}
</SCRIPT>


</head>
<body>
	<c:forEach items="${member}" var="gongji">
		<FORM METHOD="post" name="fm" action="save.html">
			<table width=650 border=1 cellspacing=0 cellpadding=5>
				<tr>
					<td><b>번호</b></td>
					<td><input type=text name=id readonly>
				</tr>
				<tr>
					<td><b>이름</b></td>
					<td><input type=text name=name size=70 maxlength=70 required></td>
				</tr>
				<tr>
					<td><b>전화번호 1</b></td>
					<td><input type=text name=no size=70 maxlength=70></td>
				</tr>



				<tr>
					<td><b>성별</b></td>
					<td><select name="sex">
							<option value="남자">남자</option>
							<option value="여자">여자</option>
					</select></td>
				<tr>
					<td><b>나이</b></td>
					<td><input type=text name=age size=70 maxlength=70 required>
					</td>
				</tr>
			</table>
	</c:forEach>
	<table width=650>
		<tr>
			<td width=600></td>
			<td><input type=button value="취소" onClick=location.href='list.html'></td>
			<td><button type="submit">쓰기</td>
			</button>
		</tr>
	</table>
	</form>
</body>
</html>
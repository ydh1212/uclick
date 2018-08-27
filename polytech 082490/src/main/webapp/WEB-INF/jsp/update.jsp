 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <%@ page contentType="text/html; charset=utf-8" %>
    <%@ page import="java.sql.*,javax.sql.*,java.io.*,java.net.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<SCRIPT LANGUAGE="JavaScript">
function submitForm(mode){
fm.action = "editForm";
fm.submit();
}
</SCRIPT>


</head>
<body>
 
<FORM METHOD="post" name="fm" action="editForm" >
<table width=650 border=1 cellspacing=0 cellpadding=5>
<tr>
 <td><b>번호</b></td>
 <td><input type=text name=id value=${id.get().getId() } readonly>
 
 </tr>
 <tr>
  <td><b>이름</b></td>
 <td><input type=text name=name value=${id.get().getName() } size=70 maxlength=70  required></td>
 </tr>
 <tr>
 <c:forEach items="${id.get().getPhoneList()}" var="phone">
 <td><b>전화번호</b></td>
 <td><input type=text name=no  size=70 maxlength=70 value=${phone.no }>
 </td>
 </tr>
 

 <input type=hidden name=pid value=${phone.id } readonly>
 </c:forEach>

 
  <tr>
 <td><b>성별</b></td>
 <td><input type=text name=sex value=${id.get().getSex() } size=70 maxlength=70 readonly>
 </td>
  <tr>
 <td><b>나이</b></td>
 <td><input type=text name=age value=${id.get().getAge() } size=70 maxlength=70 readonly>
 </td>
 </tr>
</table>

<table width=650>
<tr>
 <td width=600></td>
 <td><input type=button value="취소" onClick=location.href='list.html'></td>
  <td><button type="submit">쓰기</td></button>
</tr>
</table>
</FORM>
</body>
</html>
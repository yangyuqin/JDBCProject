<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id = "db" class="com.yyq.bean.DatabaseBean"/>
<!DOCTYRE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>测试数据库连接</title>
  </head>
  <body>
    <c:choose>
        <c:when test="${db.connectedOK}">连接成功！</c:when>
        <c:otherwise>连接失败！</c:otherwise>
    </c:choose>
  </body>
</html>

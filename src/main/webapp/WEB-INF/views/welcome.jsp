<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>HelloWorld page</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <%--<link rel="stylesheet" type="text/style" href="/resources/css/style.css" title="style">--%>
</head>
<body>
Greeting : ${greeting}

<h3>Request Scope (key==values)</h3>
<%
    java.util.Enumeration<String> reqEnum = request.getAttributeNames();
    while (reqEnum.hasMoreElements()) {
        String s = reqEnum.nextElement();
        out.print(s);
        out.println("==" + request.getAttribute(s));
%><br />
<%
    }
%>

</body>
</html>
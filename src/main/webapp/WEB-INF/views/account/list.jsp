<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach items="${ requestScope.accounts }" var="a">
			<tr>
				<td>${a.accountId }</td>
				<td>${a.email }</td>
				<td>${a.nickName }</td>
				<td>
					<a href="/u/account?id=${a.accountId }&_method=delete">删除</a>|
					<a href="/u/account?id=${a.accountId }">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
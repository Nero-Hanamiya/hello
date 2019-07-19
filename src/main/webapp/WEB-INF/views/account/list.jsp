<%@page import="com.hwadee.hello.domain.Account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<% 
		List<Account> accounts = (List<Account>)request.getAttribute("accounts");
		for( Account account : accounts  ){
	%>
			<tr>
				<td> <%= account.getAccountId() %> </td>
				<td><%= account.getEmail() %></td>
				<td><%= account.getNickName() %></td>
				<td>
					<a href="/u/account?id=<%=account.getAccountId()%>&_method=delete">删除</a>|
					<a href="/u/account?id=<%=account.getAccountId()%>">修改</a>
				</td>
			</tr>

	<%} %>
	</table>
</body>
</html>
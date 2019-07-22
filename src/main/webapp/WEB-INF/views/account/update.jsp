<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- html注释 -->
	<%-- jsp注释 --%>

	<form action="/u/account" method="post">
		<input type="hidden" name="accountId" value="${account.accountId }">
		<input type="hidden" name="_method" value="PUT"/>
		Email:<input type="text" name="email" value="${account.email }" /><br/>
		NickName:<input type="text" name="nickName" value="${account.nickName }"/><br/>
		<input type="submit" value="修改"/>
	</form>
	
	
</body>
</html>
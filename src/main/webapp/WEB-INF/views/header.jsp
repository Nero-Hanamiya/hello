<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<ul>
		<li>${ 6 div 2 } </li>
		<li>${ param.id }</li>
		<li>${ param["id"] }</li>
		<li>${ (3 + 2) * 5 }</li>
		<li>${ not empty param.name }</li>
		<li>${ requestScope.abc }</li>
		<li>${ paramValues.a[1] }</li>
		<li>${ header.Accept }</li>
		<li>${ cookie.JSESSIONID.value }</li>
		<li>${ account.nickName }</li>
		<li><c:out value="${3 + 2 }"></c:out> </li>
		<li><c:out value="<script>alert('hello');</script>" default="1" escapeXml="true"></c:out> </li>
		<c:if test="${ empty requestScope.abcdef }">
		<li>有abcdef</li>
		</c:if>
		<c:choose>
			<c:when test="${ empty requestScope.abc }">
			
			</c:when>
			<c:when test="${ empty requestScope.abcd }">
			
			</c:when>
			<c:otherwise>
			
			</c:otherwise>
		</c:choose>
		<c:forEach begin="1" end="10" step="2" var="i">
			${ i }	<br/>
		</c:forEach>
	</ul>
</div>
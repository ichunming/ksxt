<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<%@ include file="common/head.jsp"%>

<body>
	<div data-role="page">
		<!-- Navi部 -->
		<div data-role='header' data-theme='a'>
			<a href='#' onclick="backToKCTop()" data-role='button' class='ui-btn-left'
				data-icon='back' data-ajax="false" id='back'>返回</a>
			<h1>模拟考试</h1>
		</div>
		<div class="divMsg">
			<span> <c:if test="${msg != null}">
					<c:out value="${msg.content}"></c:out>
				</c:if>
			</span>
		</div>
		<c:if test="${sjList != null}">
	        <div data-role="content">
	            <ul data-role="listview" data-theme="b">
	               <c:forEach var="sj" items="${sjList}" >
		               <li><a href="/kaoshi/shiti/get?stId=${sj.firstStId}"
	                        class="ui-btn ui-btn-icon-right ui-icon-carat-r" data-ajax="false"><c:out value="${sj.name}"></c:out></a></li>
	               </c:forEach>
	            </ul>
	        </div>
		</c:if>
	</div>
</body>
</html>
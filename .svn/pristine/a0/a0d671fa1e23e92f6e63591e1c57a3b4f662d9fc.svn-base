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
			<h1>成绩结果</h1>
		</div>
		<div data-role="content">
			<!-- submit form -->
			<form method='post' action='' id='submitForm' data-ajax='false'></form>

			您最后得分是<c:out value="${score}"></c:out>分！

			<div data-role="fieldcontain" class="ui-grid-a ">
				<div class="ui-block-a">
					<a href="#" onclick="backToSJList()" data-role="button" id="back"
						class="right" data-theme="a" data-ajax="false">返回试题库</a>
				</div>
				<div class="ui-block-b">
					<a href="/kaoshi/review" data-role="button" id="registerButton"
						class="right" data-theme="a" data-ajax="false">回顾</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
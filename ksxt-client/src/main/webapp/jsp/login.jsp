<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<%@ include file="common/head.jsp"%>

<body>
	<div data-role="page">
		<!-- Navi部 -->
		<div data-role='header' data-theme='a'>
			<h1>用户登录</h1>
		</div>

		<div data-role="content">
			<!-- submit form -->
			<form method='post' action='/user/login' id='submitForm' data-ajax='false'>
				<div class="divMsg">
					<span>
					   <c:if test="${msg != null}">
					       <c:out value="${msg.content}"></c:out>
					   </c:if>
					</span>
				</div>
				<div data-role="fieldcontain">
					<label for="name" class="labTitle">用户名：</label> <input type="text"
						name="username" id="userName" maxlength="12" value="${userForm.username}" placeholder="用户名或手机号"/>
				</div>
				<div data-role="fieldcontain">
					<label for="password" class="labTitle">密码：</label> <input
						type="password" name="password" id="password"
						maxlength="12" value="${userForm.password}" placeholder="密码"/>
				</div>
				<div data-role="fieldcontain" class="ui-grid-a ">
					<div class="ui-block-a">
						<button type="submit" data-role="button" id="loginbtn"
							class="right" data-theme="a" data-ajax="false">登录</button>
					</div>
					<div class="ui-block-b">
						<a href="/user/register" data-role="button" id="registerButton"
							class="right" data-theme="a" data-ajax="false">注册</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<%@ include file="common/head.jsp"%>

<body>
<div data-role="page">
  <!-- Navi部 -->
  <div data-role='header' data-theme='a'>
  <a href='/' data-role='button' class='ui-btn-left' data-icon='back' data-ajax="false" id='ButtonLeft'>返回</a>
<h1>用户注册</h1>
</div>
  <div data-role="content">
    <!-- submit form -->
    <form method='post' action='/user/register' onsubmit="return check()" id='submitForm' data-ajax='false'>
       <div class="divMsg">
          <span>
            <c:if test="${msg != null}">
                <c:out value="${msg.content}"></c:out>
            </c:if>
          </span>
       </div>
       <div data-role="fieldcontain">  
            <label for="name" class="labTitle">用户名：</label>  
            <input type="text" name="username" id="userName" maxlength="12" value="${userForm.username}" placeholder="1到12个字符"/>
        </div>
        <div data-role="fieldcontain">
            <label for="password" class="labTitle">密码：</label>  
            <input type="password" name="password" id="password" maxlength="12" value="${userForm.password}" placeholder="6到12位数字和字母组合"/>
        </div>
        <div data-role="fieldcontain">
            <label for="mobile" class="labTitle">手机号：</label>  
            <input type="text" name="mobile" id="mobile" maxlength="16" value="${userForm.mobile}" placeholder="真实手机号"/>  
        </div>
        <div data-role="fieldcontain" class="ui-grid-a ">
            <button type="submit" data-role="button" id="loginbtn" class="right" data-theme="a" data-ajax="false">申请注册</button>
        </div>
    </form>
  </div>
</div>
</body>
<script type="text/javascript">
var check = function() {
	return $(".divMsg span").text().trim() == "";
}

$("#userName").blur(function() {
	var username = $("#userName").val();
	
	if(checkUsername()) {
		var data = {
	        username:username,
	    };
		
		apiCheck(API_CHECK_USERNAME, data);
	}
});

$("#password").blur(function() {
	checkPwd();
});

$("#mobile").blur(function() {
	var mobile = $("#mobile").val();
	
	if(checkMobile()) {
		var data = {
	        mobile:mobile,
	    };
		
		apiCheck(API_CHECK_MOBILE, data);
	}
});
</script>
</html>
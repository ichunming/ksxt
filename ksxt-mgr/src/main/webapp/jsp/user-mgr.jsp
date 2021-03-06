<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="common/head.jsp"%>
<html lang="zh-CN">
<body>
    <div class="body">
      <%@ include file="common/menu.jsp"%>
      <div class="content">
        <%@ include file="common/message.jsp"%>
	        <form action="#" id="user-mgr-form" method="post">
	          <div style="display:none">
	               <div>  
                        <input type="text" name="uid" id="uid"/>
                    </div>
			       <div>  
			            <input type="text" name="username" id="userName" maxlength="12"/>
			        </div>
			        <div>
			            <input type="password" name="password" id="password" maxlength="12"/>
			        </div>
			        <div>
			            <input type="text" name="mobile" id="mobile" maxlength="16"/>  
			        </div>
	          </div>
	          <div class="users">
	            <div class="users-header">
	              <span class="users-header-id">ID</span>
	              <span class="users-header-name">用户名</span>
	              <span class="users-header-mobile">手机号</span>
	              <span class="users-header-pswd">密码</span>

                  <c:if test="${pageInfo != null}">
                  <c:choose>
                      <c:when test="${uids != null}">
                          <span><button type="submit" onclick="return pass(${pageInfo.pageNum}, '${uids}')">本页通过</button></span>
                      </c:when>
                      <c:otherwise>
                          <span><button disabled="disabled">本页通过</button></span>
                      </c:otherwise>
                  </c:choose>
                  <span><button type="submit" onclick="return passAll(${pageInfo.pageNum})">全部通过</button></span>
                  </c:if>
	              <span><button id="btn-add-user" type="submit" onclick="return add()">添加用户</button></span>
	            </div>
	            
	            <div id="user-list">
	            <c:if test="${pageInfo != null}">
	            <c:forEach var="user" items="${pageInfo.list}" varStatus="vs">
	                <div class="users-list">
	                  <span class="users-id">${vs.index + 1}</span>
	                  <input style="display:none" class="users-id" id="uid${vs.index}" value="${user.id}"></input>
	                  <input class="users-name" id="userName${vs.index}" value="${user.username}" maxlength="12" ></input>
	                  <input class="users-mobile" id="mobile${vs.index}" value="${user.mobile}" maxlength="16" ></input>
	                  <input class="users-pswd" id="password${vs.index}" value="******" maxlength="12" ></input>
	                  <c:choose>
	                   <c:when test="${user.status == 0}">
	                       <span class="users-pass"><button type="submit" onclick="return pass(${pageInfo.pageNum}, ${user.id})">通过</button></span>
	                   </c:when>
	                   <c:otherwise>
	                       <span class="users-pass"><button disabled="disabled">已通过</button></span>
	                   </c:otherwise>
	                  </c:choose>
	                  <span class="users-save"><button type="submit" onclick="return update(${pageInfo.pageNum}, ${vs.index})">保存</button></span>
	                  <span class="users-delete"><button type="submit" onclick="return del(${pageInfo.size == 1 ? pageInfo.pageNum - 1 : pageInfo.pageNum}, ${user.id})">删除</button></span>
	                </div>
	            </c:forEach>
	            </c:if>
	            </div>
	            
	            <c:if test="${pageInfo != null}">
	            <div class="page-nav">
	              <c:choose>
	                  <c:when test="${pageInfo.pageNum == pageInfo.firstPage}">
	                      <button disabled="disabled">上一页</button>
	                  </c:when>
	                  <c:otherwise>
	                      <button type="submit" onClick="return toPage(${pageInfo.prePage});">上一页</button>
	                  </c:otherwise>
	              </c:choose>
	              <span><c:out value="${pageInfo.pageNum}"></c:out> / <c:out value="${pageInfo.pages}"></c:out></span>
	              <c:choose>
                      <c:when test="${pageInfo.pageNum == pageInfo.lastPage}">
                          <button disabled="disabled">下一页</button>
                      </c:when>
                      <c:otherwise>
                          <button type="submit" onClick="return toPage(${pageInfo.nextPage});">下一页</button>
                      </c:otherwise>
                  </c:choose>
	            </div>
	            </c:if>
	          </div>
	        </form>
        
      </div>
    </div>
</body>
<%@ include file="common/foot.jsp"%>
<script type="text/javascript">
var toPage = function(page) {
	$("#user-mgr-form").attr("action", "/user/mgr/" + page);
	return true;
};
var pass = function(page, uid) {
	$("#user-mgr-form").attr("action", "/user/mgr/pass/" + page + "/" + uid);
    return true;
};
var passAll = function(page) {
    $("#user-mgr-form").attr("action", "/user/mgr/pass/" + page);
    return true;
};
var del = function(page, uid) {
	$("#user-mgr-form").attr("action", "/user/mgr/delete/" + page + "/" + uid);
    return true;
};
var update = function(page, index) {
	$("#uid").val($("#uid" + index).val());
	$("#userName").val($("#userName" + index).val());
	$("#mobile").val($("#mobile" + index).val());
	$("#password").val($("#password" + index).val());
	
	if(!(checkUsername() && checkMobile() && checkPwd())) {
		return false;
	}
	
	$("#user-mgr-form").attr("action", "/user/mgr/update/" + page);
    return true;
};
var save = function(page, index) {
    $("#userName").val($("#userName" + index).val());
    $("#mobile").val($("#mobile" + index).val());
    $("#password").val($("#password" + index).val());
    
    if(!(checkUsername() && checkMobile() && checkPwd())) {
        return false;
    }
    
    $("#user-mgr-form").attr("action", "/user/mgr/save/" + page);
    return true;
};
var add = function() {
	$("#btn-add-user").attr("disabled", "disabled");
	$("#user-list").append('<div class="users-list"><span class="users-id">*</span>&nbsp;<input style="display:none" class="users-id" id="uid99"></input><input class="users-name" id="userName99" value="" maxlength="12" ></input>&nbsp;<input class="users-mobile" id="mobile99" value="" maxlength="16" ></input>&nbsp;<input class="users-pswd" id="password99" value="" maxlength="12" ></input>&nbsp;<span class="users-pass"><button disabled="disabled">通过</button></span>&nbsp;<span class="users-save"><button type="submit" onclick="return save(1, 99)">保存</button></span>&nbsp;<span class="users-delete"><button disabled="disabled">删除</button></span></div>');
	return false;
};
</script>
</html>
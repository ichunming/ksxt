<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp"%>
<html lang="zh-CN">
<body>
    <div class="body">
        <%@ include file="menu.jsp"%>
        <div class="content">
            <!-- server error -->
	        <div class="divMsg alert alert-dismissible" role="alert">
	            <c:choose>
	                <c:when test="${msg != null}">
	                    <c:out value="${msg}" />
	                </c:when>
	                <c:otherwise>
	                                                        服务器Hold不住了...( ° △ ° )
	                </c:otherwise>
	            </c:choose>
	        </div>
        </div>
    </div>
</body>
</html>
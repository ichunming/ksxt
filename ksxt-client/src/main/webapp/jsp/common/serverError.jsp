<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../common/head.jsp"%>
<html lang="zh-CN">
<body>
	<!-- 主体 -->
	<div class="container body-contain">
		<!-- server error -->
		<div class="alert alert-danger alert-dismissible page-503" role="alert">
            <c:choose>
                <c:when test="${msg != null}">
                    <c:out value="${msg}" />
                </c:when>
                <c:otherwise>
                                                        服务器内部错误...( ° △ ° )
                </c:otherwise>
            </c:choose>
		</div>
	</div>
	<%@ include file="../common/foot.jsp"%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<%@ include file="common/head.jsp"%>

<body>
<div data-role="page">
    <!-- Navi部 -->
    <div data-role='header' data-theme='a'>
      <a href='/kecheng/list' data-role='button' class='ui-btn-left' data-icon='back' data-ajax="false" id='ButtonLeft'>返回</a>
      <h1>课程首页</h1>
    </div>
    <div data-role="content">
        <ul data-role="listview" data-theme="b">
            <li><a href="#" class="ui-btn ui-btn-icon-right ui-icon-carat-r"><c:out value="${kc.title}"></c:out>考试大纲</a></li>
            <li><a href="#" class="ui-btn ui-btn-icon-right ui-icon-carat-r">章节练习</a></li>
            <li><a href="/kaoshi/shijuan/list?kcId=${kc.id}" data-ajax="false" class="ui-btn ui-btn-icon-right ui-icon-carat-r">模拟考试</a></li>
        </ul>
    </div>
</div>
</body>
</html>
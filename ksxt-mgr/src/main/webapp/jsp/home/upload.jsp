<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../common/head.jsp"%>
<%@ include file="../common/nav.jsp"%>
<html lang="zh-CN">
<body>
    <%@ include file="../common/message.jsp"%>
    <div class="upload">
        <p>上传文件</p>
        <form action="/tiku/save" method="post" enctype ="multipart/form-data">
            <input type="text" name="name" />
            <input type="text" name="kcId" />
            <input type="file" name="file" />
            <button type="sumbit">提交</button>
        </form>
    </div>
	<%@ include file="../common/foot.jsp"%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- start message -->
<c:choose>
    <c:when test="${msg != null}">
	    <div class="alert ${msg.clz} alert-dismissible" role="alert">
		    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		        <span aria-hidden="true">&times;</span>
		    </button>
		    
		    <c:out value="${msg.content}" />
	    </div>
    </c:when>
</c:choose>
<!-- end message -->
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
			<a href='#' onclick="backToSJList()" data-role='button' class='ui-btn-left'
				data-icon='back' data-ajax="false" id='back'>返回</a>
			<h1>单选题</h1>
		</div>
		<form action="" method="post">
			<div data-role="content">
				<c:out value="${no}"></c:out>
				.
				<c:out value="${tm.subject}"></c:out>
				<br />
				<c:if test="${tm.image != null}">
					<img src="${tm.imgage}" />
				</c:if>
				   
				<fieldset data-role="controlgroup">
					<c:if test="${tm.optionA != null && tm.optionA != ''}">
						<input type="radio" name="choice" id="radio-choice-v-2a"
							value="A" />
						<label for="radio-choice-v-2a"><c:out value="tm.optionA"></c:out></label>
					</c:if>
					<c:if test="${tm.optionB != null && tm.optionB != ''}">
						<input type="radio" name="choice" id="radio-choice-v-2b"
							value="B" />
						<label for="radio-choice-v-2b"><c:out value="tm.optionB"></c:out></label>
					</c:if>
					<c:if test="${tm.optionC != null && tm.optionC != ''}">
						<input type="radio" name="choice" id="radio-choice-v-2c"
							value="C" />
						<label for="radio-choice-v-2c"><c:out value="tm.optionC"></c:out></label>
					</c:if>
					<c:if test="${tm.optionD != null && tm.optionD != ''}">
						<input type="radio" name="choice" id="radio-choice-v-2d"
							value="D" />
						<label for="radio-choice-v-2d"><c:out value="tm.optionD"></c:out></label>
					</c:if>
				</fieldset>
			</div>

            <c:choose>
                <c:when test="${log != null}">
			        <div style="background-color: rgb(226, 236, 244);" data-role="content">
                        <div>你的答案：<c:out value="${log.answer}"></c:out></div>
                        <div>正确答案：<c:out value="${tm.answer}"></c:out></div>
                        <div>解析：<c:out value="${tm.analysis}"></c:out></div>
			        </div>
                
		            <div data-role="footer" data-theme='a' data-position="fixed"
		                role="contentinfo" class="ui-footer ui-footer-fixed">
		                <h2>footer</h2>
		                <a href="/kaoshi/shiti/review" data-role='button' class='ui-btn-right'
		                    data-icon='footer-button-right ui-btn-icon-right ui-icon-carat-r'
		                    data-ajax="false" id='ButtonLeft'>下一题</a>
		            </div>
                </c:when>
                <c:otherwise>
		            <div data-role="footer" data-theme='a' data-position="fixed"
		                role="contentinfo" class="ui-footer ui-footer-fixed">
		                <h2>footer</h2>
		                <a href="/kaoshi/shiti/answer/commit?stId=${tm.id}" data-role='button' class='ui-btn-right'
		                    data-icon='footer-button-right ui-btn-icon-right ui-icon-carat-r'
		                    data-ajax="false" id='ButtonLeft'>下一题</a>
		            </div>
                </c:otherwise>
            </c:choose>
		</form>
	</div>
</body>
</html>
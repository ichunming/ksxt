<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="common/head.jsp"%>
<html lang="zh-CN">
<body>
	<div class="body">
		<%@ include file="common/menu.jsp"%>
		<div class="content">
			<%@ include file="common/message.jsp"%>
			    <form action="#" id="tk-mgr-form" method="post">
			      <c:if test="${kcList != null}">
				      <div class="upload">
				        <div class="upload-line">
					        <span class="upload-left"><label>题库名称</label><input type="text" id="upTkName" name="upTkName"></span>
					        <span class="upload-right">
						        <label>课程</label>
						        <input type="text" id="upKcId" name="upKcId" style="display:none" />
					            <select id="upload-kcId" class="kcs-status">
					                <c:forEach var="kc" items="${kcList}" varStatus="vs">
					                    <option value="${kc.id}"><c:out value="${kc.title}"></c:out></option>
					                </c:forEach>
			                    </select>
		                    </span>
	                    </div>
	                    <div class="upload-line"><span class="upload-left"><label>题库文件</label><input type="file" name="file" /></span><span class="upload-btn"><button id="btn-add-tk" type="submit" onclick="return upload()">上传题库</button></span></div>
				      </div>
			      </c:if>
	              <div style="display:none">
                    <div>
                        <input type="text" name="tkId" id="tkId"/>
                    </div>
	              </div>
	              <div class="tks">
	                <div id="tk-list">
	                   <c:if test="${pageInfo != null}">
	                    <div class="tks-header">
	                      <span class="tks-header-id">ID</span>
	                      <span class="tks-header-kc-name">课程名称</span>
	                      <span class="tks-header-tk-name">题库名称</span>
	                    </div>
		                <c:forEach var="tk" items="${pageInfo.list}" varStatus="vs">
		                    <div class="tks-list">
		                      <span class="tks-tk-id">${vs.index + 1}</span>
		                      <input style="display:none" class="tks-tk-id" id="tkId${vs.index}" value="${tk.tkId}"></input>
		                      <input class="tks-kc-name" id="kcName${vs.index}" value="${tk.kcName}" disabled="disabled" ></input>
		                      <input class="tks-tk-name" id="tkName${vs.index}" value="${tk.tkName}" disabled="disabled" ></input>
		                      <c:choose>
			                       <c:when test="${tk.status == 0}">
			                           <span class="tks-distr"><button type="submit" onclick="return distr(${tk.tkId})">生成试卷</button></span>
			                           <span class="tks-del"><button type="submit" onclick="return del(${pageInfo.size == 1 ? pageInfo.pageNum - 1 : pageInfo.pageNum}, ${tk.tkId})">删除</button></span>
			                       </c:when>
			                       <c:otherwise>
			                           <span class="tks-distr"><button disabled="disabled">已生成</button></span>
			                           <span class="tks-del"><button disabled="disabled">删除</button></span>
			                       </c:otherwise>
			                  </c:choose>
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
var del = function(page, tkId) {
	$("#tkId").val(tkId);
	$("#tk-mgr-form").attr("action", "/tiku/mgr/delete/" + page);
    return true;
};
var upload = function() {
    $("#upKcId").val($("#upload-kcId").find("option:selected").val());
    
    if(!checkTk()) {
        return false;
    }

    $("#tk-mgr-form").attr("enctype", "multipart/form-data");
    $("#tk-mgr-form").attr("action", "/tiku/mgr/save/1");
    return true;
};
var checkTk = function() {
    var title = $("#upTkName").val();
    
    if(title.trim() == "") {
        $(".divMsg span").text("题库名称不能为空");
        return false;
    }
    if(title.trim().length > 100) {
        $(".divMsg span").text("题库名称最大长度为100");
        return false;
    }
    return true;
};
var toPage = function(page) {
    $("#tk-mgr-form").attr("action", "/tiku/mgr/view/" + page);
    return true;
};
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<%@ include file="common/head.jsp"%>

<body>
<div data-role="page">
  <!-- Navi部 -->
  <div data-role='header' data-theme='a'>
<a href="/user/logout" data-role='button' class='ui-btn-right' data-icon='action' data-iconpos='right' data-ajax="false" id='ButtonRight'>登出</a>
<h1>课程一览</h1>
</div>
  <div data-role="content">
     <div id="image">
        <section class="regular slider">
        <div>
        <a href="#"><img src="/static/image/1.jpg"/></a>
        </div>
        <div>
        <a href="#"><img src="/static/image/1.jpg"/></a>
        </div>
        <div>
        <a href="#"><img src="/static/image/1.jpg"/></a>
        </div>
        <div>
        <a href="#"><img src="/static/image/1.jpg"/></a>
        </div>
        </section>
     </div>
     <div class="doDction">
        <div class="ui-grid-a ">
            <c:forEach var="kc" items="${kcList}" varStatus="vs">
                <c:choose>
                    <c:when test="${vs.index % 2 == 0}">
                        <div class="ui-block-a">
                           <a href="/kecheng/view?kcId=${kc.id}" data-role="button" data-theme="a" class="right" data-ajax='false' >${kc.title}</a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="ui-block-b">
                         <a href="/kecheng/view?kcId=${kc.id}" data-role="button" data-theme="a"  class="left" data-ajax='false' >${kc.title}</a>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
     </div>
</div> 
</div> 
</body>
<script>
    $(document).ready(function(){     
	     if($(".regular").html().trim() == '') {
	         $(".regular").append("<div><img src='/makita/images/pictures/Default.jpg'/></div>");
	     };
	     
	     $("img").on("error",function(){
	         this.src='/makita/images/pictures/NotFound.jpg';
	         $(this).unbind();
	     });
	
	     $(".regular").slick({
	        dots: true,
	        infinite: true,
	        autoplay:true,
	        slidesToShow: 1,
	        slidesToScroll: 1
	     });
     });
</script>
</html>
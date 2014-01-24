<%@include file="includes/taglib_includes.jsp"%>

<div class="alert alert-success" style="padding: 5px; margin: 10px;">

    Results:<br/>
    <c:forEach items="${searchResults}" var="so">
        <div style="margin: 10px;">
            <a href="${so.link}">${so.link}</a>                
            
        </div>
    </c:forEach>
</div>
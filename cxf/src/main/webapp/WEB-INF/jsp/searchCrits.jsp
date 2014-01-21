<%@include file="includes/taglib_includes.jsp"%>

<div class="alert alert-info" style="padding: 5px; margin: 10px;">
<h4>New Criteria</h4>

Cities:
<select name="critCity">
    <c:forEach items="${cities}" var="city">
        <option value="${city.id}">${city.cityName}</option>
    </c:forEach>
</select>

<span style="padding-left: 5px;">Category:
   <select name="critCat">
    <c:forEach items="${cats}" var="cat">
        <option value="${cat.categoryName}">${cat.categoryName}</option>
    </c:forEach>
    </select>
</span>
&nbsp;&nbsp;

<span style="padding-left: 5px;">Keyword:
    <input type="text" name="keyword" value="" />
</span>
&nbsp;&nbsp;
<span class="btn btn-primary" style="padding-left: 10px;">Submit</span>
</div>

<div class="alert alert-success" style="padding: 5px; margin: 10px;">

    Saved Criteria:<br/>
    <c:forEach items="${searchCrits}" var="crit">
        <c:out value="${crit.name}" />
    </c:forEach>
</div>


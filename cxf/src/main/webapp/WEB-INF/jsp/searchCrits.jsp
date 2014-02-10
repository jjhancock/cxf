<%@include file="includes/taglib_includes.jsp"%>

<script type="text/javascript">
    function submitForm() {
        alert("submitForm()?");
        var hasErrors = false;
        if (!$("#cityId").val())
        {
            $("#cityId").addClass("ui-state-error");
            hasErrors = true;
        }        
        if (!$("#category").val())
        {
            $("#category").addClass("ui-state-error");
            hasErrors = true;
        }
        if (!$("#keyword").val())
        {
            $("#keyword").addClass("ui-state-error");
            hasErrors = true;   
        }        
        
        alert("hasErrors = " + hasErrors);
        if (hasErrors == false)
        {
            // clear all errors
            $("input, text").removeClass("ui-state-error");
            var searchCrit = {
                cityId: $("#cityId").val(),
                category: $("#category").val(),
                keyword: $("#keyword").val()
            };
    
            $.ajax({
                url: 'rest/searchCrit/new',
                type: 'POST',
                contentType: 'application/json; charset=utf-8',
                dataType: 'json',
                async: true,
                success: function (response, textStatus, jqXHR) {
                    console.log("success = " + response.success);
                    console.log("message = " + response.message);
                                        
                    $("#city").val("");
                    $("#cat").val("");
                    $("#keyword").val("");                    
                },
                data: JSON.stringify(searchCrit)
            });
        }
    }
</script>


<div class="alert alert-info" style="padding: 5px; margin: 10px;">
<h4>New Criteria</h4>

Cities:
<select name="cityId" id="cityId">
    <c:forEach items="${cities}" var="city">
        <option value="${city.id}">${city.cityName}</option>
    </c:forEach>
</select>

<span style="padding-left: 5px;">Category:
   <select name="category" id="category">
    <c:forEach items="${cats}" var="cat">
        <option value="${cat.categoryName}">${cat.categoryName}</option>
    </c:forEach>
    </select>
</span>
&nbsp;&nbsp;
<br/><br/>
<span style="padding-left: 5px;">Keyword:
    <input class="form-control input-sm" type="text" name="keyword" id="keyword" value="" style="width: 25%;"/>
</span>
<br/>
&nbsp;&nbsp;
<a href="#" onclick="submitForm();"><span class="btn btn-primary" style="margin-left:-5px;">Submit</span></a>
</div>

<div class="alert alert-success" style="padding: 5px; margin: 10px;">

    Saved Criteria:<br/>
    <c:forEach items="${searchCrits}" var="crit">
        <div style="margin: 10px;">
            <a href="viewCriteriaResults.do?critId=${crit.id}">
                <c:out value="${crit.category}" /> <c:out value="${crit.keyword}" /> <c:out value="${crit.city.cityName}" /><br/>
            </a>
        </div>
    </c:forEach>
</div>


<%@include file="includes/taglib_includes.jsp"%>

<script type="text/javascript">
    function submitForm() {
        
        var hasErrors = false;
        if (!$("#critCity").val())
        {
            $("#critCity").addClass("ui-state-error");
            hasErrors = true;
        }        
        if (!$("#critCat").val())
        {
            $("#critCat").addClass("ui-state-error");
            hasErrors = true;
        }
        if (!$("#critKeyword").val())
        {
            $("#critKeyword").addClass("ui-state-error");
            hasErrors = true;   
        }        
        
        if (hasErrors == false)
        {
            // clear all errors
            $("input, text").removeClass("ui-state-error");
            var searchCrit = {
                city: $("#critCity").val(),
                category: $("#critCat").val(),
                keyword: $("#critKeyword").val()
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
                                        
                    $("#critCity").val("");
                    $("#critCat").val("");
                    $("#critKeyword").val("");                    
                },
                data: JSON.stringify(searchCrit)
            });
        }
    }
</script>


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
<br/><br/>
<span style="padding-left: 5px;">Keyword:
    <input class="form-control input-sm" type="text" name="critKeyword" value="" style="width: 25%;"/>
</span>
<br/>
&nbsp;&nbsp;
<a href="#" onclick="submitForm(); return false;"><span class="btn btn-primary" style="padding-left: 10px;">Submit</span></a>
</div>

<div class="alert alert-success" style="padding: 5px; margin: 10px;">

    Saved Criteria:<br/>
    <c:forEach items="${searchCrits}" var="crit">
        <c:out value="${crit.category}" /> <c:out value="${crit.keyword}" /> <c:out value="${crit.cities}" />
    </c:forEach>
</div>


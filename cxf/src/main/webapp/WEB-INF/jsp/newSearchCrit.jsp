<%@include file="../../includes/taglib_includes.jsp"%>
<html>
<body>
<h2>new employee</h2>

	<form method="POST" action="cxf/rest/searchConfig/save">	
	    <input type="hidden" name="id" value="1" />
	    <label>SearchCrit Name:</label> <input type="text" name="name" value="" /><br/><br/>
	    <label>SearchCrit Keyword:</label> <input type="text" name="keyword" value="" /><br/><br/>	    
	    <input type="submit"/>	
	</form>
	
	Cities:<br/><br/>
	<c:forEach items="${command.cities}" var="city" >
	
	</c:forEach>

</body>
</html>

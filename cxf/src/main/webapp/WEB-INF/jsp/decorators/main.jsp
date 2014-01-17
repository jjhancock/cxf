<%@include file="../../../includes/taglib_includes.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- Auto zoom for handhelds -->
<meta name="viewport" content="width=device-width, initial-scale=1.0" /> 

<title>CXF App</title>
<meta name="robots" content="noindex,nofollow" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/jquery-ui-1.8.23.custom.css" />
<script type='text/javascript'
    src='<c:url value="js/jquery-1.8.1.min.js"/>'></script>  
<script type='text/javascript'
    src='<c:url value="js/bootstrap.min.js"/>'></script>
</head>

<body>           
    <c:import url="/WEB-INF/jsp/decorators/header.jsp" />        
    <div id="container" style="align: center;">
        <br />        
        <decorator:body />        
            <c:import url="/WEB-INF/jsp/decorators/footer.jsp" />
    </div>
</body>
</html>

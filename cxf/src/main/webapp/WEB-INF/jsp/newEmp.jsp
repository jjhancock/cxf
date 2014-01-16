<%@include file="../../includes/taglib_includes.jsp"%>

<script type="text/javascript">
    function submitForm() {
    	
    	var hasErrors = false;
    	if (!$("#firstName").val())
    	{
    	    $("#firstName").addClass("ui-state-error");
    		hasErrors = true;
    	}
    	
    	if (!$("#lastName").val())
    	{
            $("#lastName").addClass("ui-state-error");
            hasErrors = true;
    	}
    	if (!$("#email").val())
    	{
            $("#email").addClass("ui-state-error");
            hasErrors = true;   
    	}
    	
    	if (!$("#userId").val())
    	{
            $("#userId").addClass("ui-state-error");
            hasErrors = true;
    	}
    	if (!$("#password").val())
    	{
            $("#password").addClass("ui-state-error");
            hasErrors = true;
    	}
    	
    	if (!$("#password2").val())
    	{
            $("#password2").addClass("ui-state-error");
            hasErrors = true;
    	}        
    	
    	if (hasErrors == false)
    	{
	        var user = {
	            firstName: $("#firstName").val(),
	            lastName: $("#lastName").val(),
	            userId: $("#userId").val(),
	            password: $("#password").val(),
	            password2: $("#password2").val(),
	            emailAddress: $("email").val()
	        };
	
	        $.ajax({
	            url: 'rest/user/new',
	            type: 'POST',
	            contentType: 'application/json; charset=utf-8',
	            dataType: 'json',
	            async: true,
	            success: function (data) {
	                alert("success = " + data.msg);
	            },
	            data: JSON.stringify(user)
	        });
    	}
    }
</script>
    
<div class="row" style="margin-top:20px; padding:5px;">    
    <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
    <form>
	    <h2>New User</h2>       
	    <input type="hidden" name="id" value="1" />
	    <label>First Name</label> <input type="text" name="firstName" id="firstName" class="form-control input-lg" value="" required /><br/>
	    <label>Last Name</label> <input type="text" name="lastName" id="lastName" class="form-control input-lg" value="" required /><br/>
	    <label>Email Address</label><input type="email" name="email" id="email" class="form-control input-lg" required placeholder="Email Address" /><br/>       
	    <label>Username</label> <input type="text" name="userId" id="userId" class="form-control input-lg" value="" required /><br/>
	    <label>Password</label> <input type="password" name="password" id="password" class="form-control input-lg" value="" required /><br/>
	    <label>Password2</label> <input type="password" name="password2" id="password2" class="form-control input-lg" value="" required /><br/>
	      
	    <input class="btn btn-success btn-lg btn-block" onclick="submitForm();return false;" value="Save" /><br/><br/>
    </form>  
    </div>
</div>

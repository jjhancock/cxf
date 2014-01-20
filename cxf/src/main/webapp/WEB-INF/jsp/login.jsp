<%@include file="../../../includes/taglib_includes.jsp" %>


<div class="row" style="margin-top: 20px margin-left:20px; margin-bottom:20px;">
    
	<div
		class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
		<form role="form" action="<c:url value='j_spring_security_check'/>" method="POST">
			<fieldset>			         
				<h2>
				    <span style="color: red"><c:out value="${param.login_error ? 'Invalid Credentials' : ''}" /></span><br/>
				    Please Sign In</h2>
				<div class="form-group">
					<input type="text" name="j_username" id="j_username"
						class="form-control input-lg" placeholder="User Id">
				</div>
				<div class="form-group">
					<input type="password" name="j_password" id="j_password"
						class="form-control input-lg" placeholder="Password">
				</div>
				<span class="button-checkbox">
					<button type="button" class="btn" data-color="info">Remember
						Me</button> <input type="checkbox" name="remember_me" id="remember_me"
					checked="checked" class="hidden"> <a href=""
					class="btn btn-link pull-right">Forgot Password?</a>
				</span>
				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
						<input type="submit" class="btn btn-lg btn-success btn-block"
							value="Sign In">
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
						<a href="" class="btn btn-lg btn-primary btn-block">Register</a>
					</div>
				</div>
			</fieldset>
		</form><br/><br/><br/><br/>
	</div>
</div>
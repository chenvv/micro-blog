<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<meta name="keywords" content="MicroBlog" /> 
<meta name="description" content="MicroBlog by vivian" /> 
<title>MicroBlog register page</title> 
<link rel="shortcut icon" href="images/favicon.ico" /> 
<script type="text/javascript">
var etuser='{"siteurl":"<s:url value='' forceAddSchemeHostAndPort='true'/>","pubdir":"<s:url value='' forceAddSchemeHostAndPort='true'/>","setok":"-1","my_uid":"","user_name":"","nickname":"","space":""}';var stalk='';var shorturl='http://goo.gl';
</script> 
<script type="text/javascript" src="js/jquery.js"></script> 
<script type="text/javascript" src="js/common.js"></script> 
<script type="text/javascript" src="js/extends.js"></script> 
<script type="text/javascript" src="js/ye_dialog.js"></script> 
<link rel="stylesheet" type="text/css" href="css/highslide/highslide.css" /> 
<link rel="stylesheet" type="text/css" href="css/style.css" /> 
<!--[if lte IE 6]>
<style type="text/css">
#header .left{filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='image',src='images/logo.png');background:none;cursor:pointer}
#header .topmenubg{filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='image',src='images/topmenu.png');background:none;}
#navbg {filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true', sizingMethod='scale',src='images/headbg.png');background:none;}
#sidebar .homestabs .menu li .arrHover{filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true,sizingMethod=image,src='images/sidemenuArr_over.png');background:none;}
#sidebar .homestabs .menu li .arrCurt{filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true,sizingMethod=image,src='images/sidemenuArr.png');background:none}
#sidebar .sect {filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true,sizingMethod=scale, src='images/dot.png');background:none;}
.newst {filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true,sizingMethod=image,src='images/newst.png');background:none;}
</style>
<![endif]--> 
</head> 
 
<body>
<div id="container" class="newlook"> 
	<div id="header2"> 
		<a href="Main"><div class="left"></div></a> 
	</div> 
	<div class="clearline"></div> 
	<div id="register"> 
		<div class="indexh" style="margin-bottom:20px"> 
			<div class="tabon">Sign Up</div> 
			<div class="taboff"><a href="Login_Show">Already signed up? Sign in.</a></div> 
			<div class="taboff"><a href="Reset">Forget Password?</a></div> 
		</div> 
		<table border="0" style="width:90%;margin-left:40px"> 
		<tr><td valign="top"> 
		<h3 class="tt">Join the Conversation</h3> 
				<form method="post" action="##" class="lf"> 
		<table class="regtb"> 
			<tr> 
				<th><label class="label_input" for="username">Username</label></th> 
				<td height="50px" width="210px"><input tabindex="2" type="text" id="username" name="username" class="input_text" value="" maxlength="20"/></td> 
				<td>4 ~ 20 characters</td> 
			</tr> 
			<!--
			<tr height="30px"> 
				<td></td> 
				<td colspan="2"><span class="grey">Your URL http://127.0.0.1/<span id="wbadd"></span></span></td> 
			</tr> 
			-->
			<tr> 
				<th><label class="label_input" for="email">Email</label></th> 
				<td height="50px"><input tabindex="4" type="text" id="email" name="email" class="input_text" value="" /></td> 
				<td>Note: You will find your password by email when you forgot it.</td> 
			</tr> 
			<tr> 
				<th><label class="label_input" for="password">Password</label></th> 
				<td height="50px"><input tabindex="5" type="password" id="password" name="password" class="input_text" value="" maxlength="20" style="ime-mode:disabled" onpaste="return false;"/></td> 
				<td>4 ~ 20 characters (be tricky!)</td> 
			</tr> 
			<tr> 
				<th><label class="label_input" for="repassword">Confirm</label></th> 
				<td height="50px"><input tabindex="6" type="password" id="repassword" name="repassword" class="input_text" value="" maxlength="20" style="ime-mode:disabled" onpaste="return false;"/></td> 
				<td>Confirm your password</td> 
			</tr> 
			<tr> 
				<td></td> 
				<td height="50px" colspan="2">
				<input tabindex="7" type="button" class="button1" value="Create" onclick="check_register();"/>
				</td> 
			</tr> 
		</table> 
		<input type="hidden" name="__hash__" value="cc4596e00e9073792a6fd48debe75700" /></form> 
		</td></tr> 
		</table> 
	</div> 
	<script type="text/javascript"> 
	$("#username").keyup(function(){
		$('#username').val($('#username').val().replace(/\s/ig,""));
		$('#wbadd').html($('#username').val());
		$('#username').val($('#username').val().slice(0,12));
		$('#wbadd').html($('#username').val().slice(0,12));
	});
	$("#mailadres").keyup(function() {$('#mailadres').val($('#mailadres').val().replace(/\s/ig,""));});
	$("#password1").keyup(function() {$('#password1').val($('#password1').val().replace(/\s/ig,""));});
	$("#password2").keyup(function() {$('#password2').val($('#password2').val().replace(/\s/ig,""));});
	</script> 

	<div id="footer">Powered by vivian.&copy; 2011</div> 
</div> 
<div class="gotop"><button onclick="indextop();" title="Back to top"><span>Back to top</span></button></div> 
</body> 
</html>
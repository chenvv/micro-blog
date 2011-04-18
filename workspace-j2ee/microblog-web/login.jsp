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
	<div id="login"> 
		<div class="indexh" style="margin-bottom:20px"> 
			<div class="taboff"><a href="Register_Show">Create Your Account</a></div> 
			<div class="tabon">Sign in</div> 
			<div class="taboff"><a href="Reset">Forget Password?</a></div> 
		</div> 
		<form class="vf lf" style="margin-top:50px"> 
			<p> 
				<label class="label_input" for="loginname">Username</label> 
				<input tabindex="1" type="text" id="username" name="username" class="input_text" value="" /> 
			</p> 
			<p> 
				<label class="label_input" for="password">Password</label> 
				<input tabindex="2" type="password" id="password" name="password" class="input_text" value="" maxlength="20" /> 
			</p> 
			<p> 
				<label class="label_check" for="rememberMe"> 
				<input tabindex="3" type="checkbox" name="rememberMe" id="rememberMe" class="checkbox" value="on" />&nbsp;&nbsp;Remember me
				</label> 
			</p> 
			<p class="act">
				<input tabindex="4" type="button" class="button1" value="Sign in" onclick="submit_login();" /> 
			</p> 
			<input type="hidden" name="__hash__" value="840b6cc1e2605b11aa142026080385cb" />
		</form> 
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
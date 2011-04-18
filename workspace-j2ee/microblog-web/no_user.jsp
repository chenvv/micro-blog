<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="keywords" content="MicroBlog" /> 
<meta name="description" content="MicroBlog by vivian" /> 
<title>MicroBlog my top page</title> 
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" type="text/css" href="css/highslide.css" />
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
<style type="text/css">body {}</style>
</head>

<body>
<div id="container" class="newlook">
<s:if test="resultMsg=='login'">
<div id="navbg"></div>
</s:if>
<div id="header">
	<s:if test="resultMsg=='login'">
    <div id="navigation">
        <ul>
            <li ><a href="Hall">Hall</a></li>
            <li ><a href="Topten">Topten</a></li>
            <li ><a href="Friends">Friends</a></li>
            <li ><a href="Invite">Invite</a></li>
            <li class="fright"><a href="Login_Logout">Sign out</a></li>
            <li class="fright "><a href="Message/inbox">Messages</a> | </li>
            <li class="fright "><a href="Setting/Themes">Themes</a></li>
            <li class="fright "><a href="Setting_Show">Settings</a></li>
            <li class="fright "><a href="testcxm/profile">testcxm</a></li>
        </ul>
    </div>
    </s:if>
    <a href="Main"><div class="left"></div></a>
    <s:if test="resultMsg=='login'">
    <div class="topmenubg"></div>
    <div class="topmenu">
        <ul>
            <li class="selected"><a href="testcxm">Home</a> | </li>
            <li ><a href="testcxm/profile">My Blog</a> | </li>
            <li ><a href="testcxm/following">Friends</a></li>
            <li>
                <div id="searchr">
                    <select id="commonsearch" class="select"><option value="talk">Blog</option><option value="user">User</option></select>
                    <input type="text" id="searchr-input" name="q" value="Search" onfocus="this.value=''" onkeydown= "if(event.keyCode==13){dosearch()}"/>
                    <input type="button" id="searchr-submit" value="Find" onclick="dosearch();" />
                </div>
            </li>
        </ul>
    </div>
    </s:if>
</div>
<div class="ad1"></div>
<div class="clearline"></div>
<div class="error"> 
    <h2>Sorry, the profile you are trying to visit does not exist.</h2> 
    <p>Please check the user name is correct.</p>
    <br/><p> 
    <p><a href="Main">Click here</a> to return home.</p> 
    <p>Will return in 5 seconds.</p>
</div> 
<script type="text/javascript">
    $("#contentbox").focus(function(){$("#contentbox").css({border: "1px solid #7bd6f6" });});
    $("#contentbox").blur(function(){$("#contentbox").css({border: "1px solid #b3b3b3" });});
    $("#contentbox").focus();
        $("#lookmore").val('a');
</script>
<div id="footer">Powered by vivian.&copy; 2011</div>
</div>
<div class="gotop"><button onclick="indextop();" title="Back to top"><span>Back to top</span></button></div> 
</body>
</html>
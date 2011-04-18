<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="keywords" content="MicroBlog" /> 
<meta name="description" content="MicroBlog by vivian" /> 
<title>MicroBlog my top page</title> 
<script type="text/javascript">
var etuser='{"siteurl":"<s:url value='' forceAddSchemeHostAndPort='true'/>","pubdir":"<s:url value='' forceAddSchemeHostAndPort='true'/>","setok":"-1","my_uid":"","user_name":"","nickname":"","space":""}';var stalk='';var shorturl='http://goo.gl';
</script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/extends.js"></script>
<script type="text/javascript" src="js/ye_dialog.js"></script>
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
<div id="navbg"></div>
<div id="container" class="newlook">
<div id="header">
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
            <li class="fright "><a href="<s:property value='myaccount.accountName'/>/profile">
            	<s:property value='myaccount.accountName'/>
            </a></li>
        </ul>
    </div>
    <a href="Main"><div class="left"></div></a>
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
</div>
<div class="ad1"></div>
<div class="clearline"></div>
<table id="columns">
<tr>
<td id="main">
    <div id="infohead">
        <div class="hometip">What's happening?</div>
        <textarea id="contentbox" class="input_text headtextarea" onkeydown="javascript:return ctrlEnter_st(event);"></textarea>
        <div class="sendbox">
        <div class="fright">
            <div class="sendtip"><span class="sendsp"><span id="nums">140</span></span></div>
            <input type="button" class="sendbutton" onclick="sendTalk()" value=""/>
        </div>
        </div>
    </div>
    <div class="contenter">
        <div class="ad3"></div>
        <div class="hometitle">
            <span class="mine">All</span>
        </div>
        <div id="stream" class="message">
            <ol class="wa">
                <s:if test="bloglist.size==0">
                	<li class="unlight" id="nonemsg">No blog.</li>
                </s:if>
                <s:iterator value="bloglist">
                <li class="unlight">
                	<a href="<s:property value='account.accountName'/>" title="<s:property value='account.accountName'/>" class="avatar">
                	<s:if test="account.iconUrl==null"><img src="images/default.jpg" alt="<s:property value='account.accountName'/>" /></s:if>
                	<s:else><img src="<s:property value='account.iconUrl'/>" alt="<s:property value='account.accountName'/>" /></s:else>
                	</a>
                	<div class="">
	                	<div class="content">
	                		<a href="<s:property value='account.accountName'/>" class="author "><s:property value='account.accountName'/></a>
	                		<h6>:</h6>
	                		<span id="cont99"><s:property value='content'/></span>
	                	</div>
	                	<span class="stamp fleft"><s:property value='createTime'/></span>
	                	<span class="stamp op" style="float:right;white-space:nowrap">
	                		<a href="javascript:void(0)" onclick="retwit('99')">Foward</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	                		<a href="javascript:void(0)" onclick="replyajax('99')">Reply</a>&nbsp;&nbsp;|&nbsp;
	                		<a class="fav" href="javascript:void(0)" onclick="dofavor('99')" title="Favorite">Favorite</a>
	                	</span>
	                	<div class="clearline"></div>
	                	<span id="reply_99" class="replyspan"></span>
                	</div>
                </li>
				</s:iterator>
            </ol>
        </div>
    </div>
</td>
<td id="sidebar" rowspan="2">
	<div class="contenter">
		<div class="sect first-sect" style="margin-bottom:0px">
			<div class="fleft" style="width:60px">
				<a href="Setting/face" title="Change Face">
				<s:if test="myaccount.iconUrl==null">
				<img src="images/default.jpg" width="50px" height="50px" alt="<s:property value='myaccount.accountName'/>" class="imgborder"/>
				</s:if>
				<s:else>
				<img src="<s:property value='myaccount.iconUrl'/>" width="50px" height="50px" alt="<s:property value='myaccount.accountName'/>" class="imgborder"/>
				</s:else>
				</a>
			</div>
			<div class="fleft">
				<div class="sidename"><span class=""><a href="<s:property value='myaccount.accountName'/>/profile"><s:property value='myaccount.accountName'/></a></span></div>
				<div><a href="Setting_Show">Input your location.</a></div>
			</div>
			<table class="sidetable">
				<tr style="line-height:100%">
					<td class="tz"><a href="testcxm/follower"><p><b><s:property value='myaccount.followedCount'/></b></p><p>Followers</p></a></td>
					<td class="st"><a href="testcxm/following"><p><b><s:property value='myaccount.followCount'/></b></p><p>Following</p></a></td>
					<td class="gb"><a href="testcxm/mine"><p><b id="mymsgnum"><s:property value='myaccount.blogCount'/></b></p><p>Blogs</p></a></td>
				</tr>
			</table>
		</div>
		<div class="homestabs">
			<ul class="menu">
				<li><a href="testcxm" class="home curt">Home</a><b class="arr arrCurt"></b></li>
				<li><a href="testcxm/at" class="at">@Mentions</a><b class="arr"></b></li>
				<li><a href="testcxm/favorite" class="favor">Favorite</a><b class="arr"></b></li>
				<li><a href="Comments" class="comments">Replies</a><b class="arr"></b></li>
			</ul>
		</div>
		<div class="clearline"></div>
		<div class="sect ">
			<h2><span class="fleft">Populer User</span><span class="right">Followers</span><span class="clearline"></span></h2>
			<ul class="ulist">
				<s:iterator value="userlist" status="stat">
				<li><span class="fleft"><div class="top3"><s:property value="#stat.index+1"/></div><a href="<s:property value='accountName'/>"><s:property value='accountName'/></a></span><span class="num"><s:property value='followedCount'/></span><span class="clearline"></span></li>
				</s:iterator>
			</ul>
			<a class="morebottom" href="Topten">More&#187;</a>
		</div>
	</div>
</td>
</tr>
<tr>
<td height="36px">
    <div id="indexpage" class="page"></div>
</td>
</tr>
</table>
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
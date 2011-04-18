<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<meta name="keywords" content="MicroBlog" /> 
<meta name="description" content="MicroBlog by vivian" /> 
<title>MicroBlog main page</title> 
<script type="text/javascript">
var etuser='{"siteurl":"<s:url value='' forceAddSchemeHostAndPort='true'/>","pubdir":"<s:url value='' forceAddSchemeHostAndPort='true'/>","setok":"-1","my_uid":"","user_name":"","nickname":"","space":""}';var stalk='';var shorturl='http://goo.gl';
</script> 
<link rel="shortcut icon" href="images/favicon.ico" /> 
<link rel="stylesheet" type="text/css" href="css/welcome.css" /> 
<script type="text/javascript" src="js/jquery.js"></script> 
<script type="text/javascript" src="js/common.js"></script> 
<script type="text/javascript" src="js/extends.js"></script> 
<script type="text/javascript" src="js/ye_dialog.js"></script> 
</head> 
 
<body>
<div class="main"> 
    <a href="Main"><div class="header"></div> </a>
    <div class="rightbox"> 
        <div class="rightbox_1"> 
            <form>
            <table border="0" width="200px">
                <tr> 
                    <td height="100px" valign="top"><a href="Register_Show" class="btn-reg">Sign in</a></td> 
                </tr> 
                <tr> 
                    <td height="40px" valign="top"> 
                    <input tabindex="1" type="text" name="username" id="username" class="input_text" value="Input your name" style="width:185px" onfocus="if($(this).val()=='Input your name'){$(this).val('')}" onblur="if($(this).val()==''){$(this).val('Input your name')}"/> 
                    </td> 
                </tr> 
                <tr> 
                    <td height="90px" valign="top"> 
                    <input tabindex="2" type="password" name="password" id="password" class="input_text" value="******" maxlength="20" style="width:185px" onfocus="if($(this).val()=='******'){$(this).val('')}" onblur="if($(this).val()==''){$(this).val('******')}"/> 
                    <div style="margin-top:15px"> 
                        <label class="label_check" for="rememberMe"> 
                        <input tabindex="3" type="checkbox" name="rememberMe" id="rememberMe" value="on" class="checkbox"/>&nbsp;&nbsp;Remember me&nbsp;&nbsp;&nbsp;
						<br/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="Reset" id="forgot">Forgot password?</a> 
                        </label> 
                    </div> 
                    </td> 
                </tr> 
                <tr>
                    <td height="30px" align="center">
                    <input type="hidden" name="action" value="login" />
                    <input tabindex="4" type="button" class="button1" value="Sign in" onclick="submit_login();" /></td> 
                </tr> 
            </table> 
            <input type="hidden" name="__hash__" value="a8ac9e4278680a5b1289d6999704114b" />
            </form> 
        </div> 
        <div class="rightbox_2"> 
            <p><img src="images/help.gif"/>&nbsp;&nbsp;Help&nbsp;&nbsp;<a href="faq">Click to view</a></p> 
            <p><img src="images/favor.gif"/>&nbsp;&nbsp;About me&nbsp;&nbsp;<a href="about">Click to view</a></p> 
        </div> 
    </div> 
    <div class="weltop"> 
        <div class="hottopic">
			<ul>
				<!-- topic list -->
				<li><a href="topic1">topic1</a></li>
				<li><a href="topic2">topic2</a></li>
			</ul>
			<div class="clearline"></div>
		</div> 
    </div> 
    <div class="welbody"> 
        <div class="hotuser"> 
            <div class="hotuserico">See who's here</div> 
            <div class="userlist">
				<ul>
					<!-- user list -->
					<s:iterator value="userlist">
					<li>
						<a href="#">
							<s:if test="iconUrl==null">
							<img src="images/default.jpg" alt="<s:property value="accountName"/>"/>
							</s:if>
							<s:else>
							<img src=<s:property value="iconUrl"/> alt="<s:property value="accountName"/>"/>
							</s:else>
							<span><s:property value="accountName"/></span>
						</a>
					</li>
					</s:iterator>
				</ul>
			</div>  
		</div> 
		<div class="hottalk"> 
			<div class="theysay">Micro Blog View</div> 
			<div class="marqueegb">
				<ul>
					<!-- blog list -->
					<s:iterator value="bloglist">
					<li>
						<div class="indexgbli">
							<table border="0" width="100%">
								<tr>
								<td width="60px" valign="top">
									<a href=<s:action name=""><s:property value="account.accountName"/></s:action>>
										<s:if test="account.iconUrl==null">
										<img src="images/default.jpg" alt="<s:property value="account.accountName"/>"/>
										</s:if>
										<s:else>
										<img src="<s:property value='account.iconUrl'/>" alt="<s:property value="account.accountName"/>"/>
										</s:else>
									</a>
								</td>
								<td valign="top">
									<a href=<s:action name=""><s:property value="account.accountName"/></s:action> class="vip"><s:property value="account.accountName"/></a>
									&nbsp;&nbsp;<s:property value="content"/><div class="sp"><s:property value="createTime"/></div>
								</td>
								</tr>
							</table>
						</div>
					</li>
					</s:iterator>
				</ul>
			</div> 
		</div>
	</div>
	<div class="welbottom"></div> 
	<div id="indexbottom">Powered by vivian.&copy; 2011</div> 
</div>
<script type="text/javascript"> 
$(document).ready(function(){
    //talk
    if ($(".marqueegb ul li").length>3) {
        var firstli;
        var tksi;
        firstli=$(".marqueegb ul li").first();
        firstli.before("<li>"+$(".marqueegb ul li").last().html()+"</li>");
        $(".marqueegb ul li").last().remove();
        firstli.before("<li>"+$(".marqueegb ul li").last().html()+"</li>");
        $(".marqueegb ul li").last().remove();
        firstli.before("<li>"+$(".marqueegb ul li").last().html()+"</li>");
        $(".marqueegb ul li").last().remove();
        function tkscroll() {
            tksi=setInterval(function(){
                firstli=$(".marqueegb ul li").first();
                $(".marqueegb ul li").first().slideDown(1000);
                firstli.before("<li style='display:none'>"+$(".marqueegb ul li").last().html()+"</li>");
                $(".marqueegb ul li").last().remove();
            }, 4000);
        }
        $("a").focus(function(){this.blur()});
        $('.marqueegb').mouseover(function(){clearInterval(tksi)});
        $('.marqueegb').mouseout(function(){tkscroll()});
        tkscroll();
    }
    //topic
    var topiculw=0;
    var l=0;
    var firstl12;
    var tpsi;
    $('.hottopic ul li').each(function(){
        topiculw=topiculw+$(this).width()+10;
    });
    $('.hottopic ul').width(topiculw+'px');
    function tpscroll() {
        tpsi=setInterval(function(){
            l=l+1;
            firstl12=$('.hottopic ul li').first();
            firstl12.css('margin-left',-l);
            if (l==firstl12.width()+10) {
                $('.hottopic ul').append(firstl12);
                $('.hottopic ul li').last().removeAttr('style');
                l=0;
            }
        },50);
    }
    if (topiculw>=530) {
        $('.hottopic').mouseover(function(){clearInterval(tpsi)});
        $('.hottopic').mouseout(function(){tpscroll()});
        tpscroll();
    }
});
</script> 
</body> 
</html>
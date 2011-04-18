var autoupdateid;
var etobj=jQuery.parseJSON(etuser);
var setok=etobj.setok;
var siteurl=etobj.siteurl;
var pubdir=etobj.pubdir;
var my_uid=etobj.my_uid;
var user_name=etobj.user_name;
var nickname=etobj.nickname;
var space=etobj.space;
var lasttalk;
var matchURL = new RegExp("((?:http|https|ftp|mms|rtsp)://(&(?=amp;)|[A-Za-z0-9\./=\?%_~@&#:;\+\-])+)","ig");
/*insertAtCaret*/
$.fn.extend({insertAtCaret: function(myValue){var $t=$(this)[0];if (document.selection) {this.focus();sel = document.selection.createRange();sel.text = myValue;this.focus();} else {if ($t.selectionStart || $t.selectionStart == '0') {var startPos = $t.selectionStart;var endPos = $t.selectionEnd;var scrollTop = $t.scrollTop;$t.value = $t.value.substring(0, startPos) + myValue + $t.value.substring(endPos, $t.value.length);this.focus();$t.selectionStart = startPos + myValue.length;$t.selectionEnd = startPos + myValue.length;$t.scrollTop = scrollTop;} else {this.value += myValue;this.focus();}}}});
$(document).ready(function(){
    $("#main").height(parseInt($("#columns").height())-36);
    /*input num*/
    $("#contentbox").keyup(function(){
        var len=typenums('#contentbox');
        if (len<0) {
            $(".sendsp").html('<font color="red"><span id="nums">'+(-len)+'</span></font>');
        } else {
            $(".sendsp").html('<span id="nums">'+len+'</span>');
        }
    });
    /*hometabs*/
    $(".homestabs > .menu: li").mouseover(function(){$(this).find('b').addClass("arrHover");});
    $(".homestabs > .menu: li").mouseout(function(){$(this).find('b').removeClass("arrHover");});
    $(window).scroll(function(){if ($(window).scrollTop()>0) {$(".gotop").fadeIn("fast");} else {$(".gotop").fadeOut("fast");}});
    $("ol li").mouseover(function(){if (this.parentNode.id!='nolignt' && this.id!='nonemsg') {$(this).addClass("light");$(this).removeClass("unlight");}});
    $("ol li").mouseout(function(){if (this.parentNode.id!='nolignt' && this.id!='nonemsg') {$(this).addClass("unlight");$(this).removeClass("light");}});
    $("a").focus(function(){this.blur()});
    $("input:button").focus(function(){this.blur()});
    Tips();
    Followpreview();
    $('#lookmore').change(function(){
        var conttype=$(this).val();
        if (space) {
            window.location.href=siteurl+user_name+'/'+space+'/'+conttype;
        } else {
            window.location.href=siteurl+user_name+'/'+conttype;
        }
    });
    $('#topcity').change(function(){
        var topcity=$(this).val();
        window.location.href=siteurl+'Hot?c='+topcity;
    });
    $("#mytopic li").mouseover(function(){
        $(this).find('.num').show();
    });
    $("#mytopic li").mouseout(function(){
        $(this).find('.num').hide();
    });
    $("#plugins").mouseover(function(){
        $(this).attr('class','on');
        $('.subNav').show();
    });
    $("#plugins").mouseout(function(){
        $(this).attr('class','');
        $('.subNav').hide();
    });
    $('.topic').mouseover(function(){$('#sharetopic').show();});
    $('.topic').mouseout(function(){$('#sharetopic').hide()});
    $('.video').mouseover(function(){$('#sharevideo').show()});
    $('.video').mouseout(function(){$('#sharevideo').hide()});
    $('.photo').click(function(){$('#sharephoto').show();});
    $('#closephoto').click(function(){$('#sharephoto').hide('fast')});
    $('#uploadbtn').change(function(){uploadpic($(this).val());});
    /*pic rot*/
    picctrl();
});
function typenums(id){
    var cval=$(id).val();
    var webnum=cval.match(matchURL);
    if (webnum) {
        webnum=webnum.length;
    } else {
        webnum=0;
    }
    cval= cval.replace(matchURL, shorturl);
    var len=$.trim(cval).length+(webnum*8);
    len=140-len;
    return len;
}
function tologin(){if (!my_uid) {location.href=siteurl+'login';return;}}
function picctrl(){
    $(".imageshow > .miniImg").bind('click',function(){
        $(this).hide();
        $(this).parent().find('.artZoomBox').show();
    });
    $(".imageshow").find('.maxImgLink').bind('click',function(){
        $(this).parent().parent().find('.miniImg').show();
        $(this).parent().hide();
    });
    $(".imageshow").find('.hideImg').bind('click',function(){
        $(this).parent().parent().parent().find('.miniImg').show();
        $(this).parent().parent().hide();
    });
    $(".imageshow").find('.imgRight').bind('click',function(){
        $(this).parent().parent().find('.maxImg').rotateRight(90);
    });
    $(".imageshow").find('.imgLeft').bind('click',function(){
        $(this).parent().parent().find('.maxImg').rotateLeft(90);
    });
}
/*emotion*/
function closetip(id) {
    $("#"+id).remove();
    if ($('.tipmsg > .tips > p').length<=0) {
        $(".tipmsg").remove();
    }
}
function showemotion(em,pid) {
    $("#"+em).html('<div class="emotions"><ul class="emotion"><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/1.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(��ϲ)\')"><img alt="��ϲ" title="��ϲ" src="'+pubdir+'images/emotion/2.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/3.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(Ż��)\')"><img alt="Ż��" title="Ż��" src="'+pubdir+'images/emotion/4.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(�ݰ�)\')"><img alt="�ݰ�" title="�ݰ�" src="'+pubdir+'images/emotion/5.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(��Ц)\')"><img alt="��Ц" title="��Ц" src="'+pubdir+'images/emotion/6.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(��)\')"><img alt="��" title="��" src="'+pubdir+'images/emotion/7.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(ɫ)\')"><img alt="ɫ" title="ɫ" src="'+pubdir+'images/emotion/8.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(Ʋ��)\')"><img alt="Ʋ��" title="Ʋ��" src="'+pubdir+'images/emotion/9.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(��Ƥ)\')"><img alt="��Ƥ" title="��Ƥ" src="'+pubdir+'images/emotion/10.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/11.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(͵Ц)\')"><img alt="͵Ц" title="͵Ц" src="'+pubdir+'images/emotion/12.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(�ʻ�)\')"><img alt="�ʻ�" title="�ʻ�" src="'+pubdir+'images/emotion/13.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/14.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(��)\')"><img alt="��" title="��" src="'+pubdir+'images/emotion/15.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/16.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/17.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/18.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(��)\')"><img alt="��" title="��" src="'+pubdir+'images/emotion/19.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(��ŭ)\')"><img alt="��ŭ" title="��ŭ" src="'+pubdir+'images/emotion/20.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/21.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(Ͷ��)\')"><img alt="Ͷ��" title="Ͷ��" src="'+pubdir+'images/emotion/22.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(���)\')"><img alt="���" title="���" src="'+pubdir+'images/emotion/23.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/24.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(���)\')"><img alt="���" title="���" src="'+pubdir+'images/emotion/25.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/26.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(���)\')"><img alt="���" title="���" src="'+pubdir+'images/emotion/27.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(�ѹ�)\')"><img alt="�ѹ�" title="�ѹ�" src="'+pubdir+'images/emotion/28.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/29.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/30.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(ץ��)\')"><img alt="ץ��" title="ץ��" src="'+pubdir+'images/emotion/31.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(��Ʒ)\')"><img alt="��Ʒ" title="��Ʒ" src="'+pubdir+'images/emotion/32.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(Ǯ)\')"><img alt="Ǯ" title="Ǯ" src="'+pubdir+'images/emotion/33.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(��)\')"><img alt="��" title="��" src="'+pubdir+'images/emotion/34.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/35.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(ʹ��)\')"><img alt="ʹ��" title="ʹ��" src="'+pubdir+'images/emotion/36.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/37.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/38.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/39.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/40.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(˯)\')"><img alt="˯" title="˯" src="'+pubdir+'images/emotion/41.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(��)\')"><img alt="��" title="��" src="'+pubdir+'images/emotion/42.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(��Ѫ)\')"><img alt="��Ѫ" title="��Ѫ" src="'+pubdir+'images/emotion/43.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(�ɰ�)\')"><img alt="�ɰ�" title="�ɰ�" src="'+pubdir+'images/emotion/44.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(����)\')"><img alt="����" title="����" src="'+pubdir+'images/emotion/45.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(��)\')"><img alt="��" title="��" src="'+pubdir+'images/emotion/46.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(лл)\')"><img alt="лл" title="лл" src="'+pubdir+'images/emotion/47.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(��)\')"><img alt="��" title="��" src="'+pubdir+'images/emotion/48.gif"/></a></li><li><a href="javascript:void(0);" onclick="emotion(\''+em+'\',\''+pid+'\',\'(ʤ��)\')"><img alt="ʤ��" title="ʤ��" src="'+pubdir+'images/emotion/49.gif"/></a></li><li> </li><li> </li><li><a href="javascript:void(0);" onclick="closeemotion(\''+em+'\')">&nbsp;x&nbsp;</a></li></ul></div>');
    $("#"+em).show();
}

function emotion(em,id,emo) {
    $("#"+id).insertAtCaret(emo);
    closeemotion(em);
}
function closeemotion(id) {
     $("#"+id).html('');
     $("#"+id).hide();
}
/*del msg*/
function delmsg(url,mes,obj,reurl) {
    tologin();
    var mymes;
    mymes=confirm(mes);
    if(mymes==true){
        $.get(url,
        function(msg){
            if (msg=="success") {
                if (!reurl) {
                    $(obj).animate({opacity: 'toggle'}, "slow");
                    ye_msg.open('Deleted ^_^',1,1);
                } else {
                    location.href=reurl;
                    return;
                }
            } else {
                ye_msg.open(msg,3,2);
            }
        });
    }
}
function followop(url,mes,mes2,uname,unickname,status) {
    tologin();
    var mymes;
    if (mes2=='gz') {
        mymes=true;
    } else {
        mymes=confirm(mes);
    }
    if(mymes==true){
        $.get(siteurl+'Space/'+url+'/rand/'+GetRandomNum(1,999999),
        function(msg){
            if (msg=="success") {
                if (mes2=='gz') {
                    ye_msg.open('Following ^_^',1,1);
                    if (parseInt(status)>=2) {
                        $('#followsp_'+uname).html("<span class='followbtn'><img src='"+pubdir+"images/fico.gif'> Following each other&nbsp;|&nbsp;<a href='javascript:void(0)' onclick=\"followop('delfollow/user_name/"+uname+"','Unfollow "+unickname+" ?','jc','"+uname+"','"+unickname+"','"+status+"')\">Cancel</a></span>");
                    } else {
                        $('#followsp_'+uname).html("<span class='followbtn'><img src='"+pubdir+"images/fico2.gif'> Following&nbsp;|&nbsp;<a href='javascript:void(0)' onclick=\"followop('delfollow/user_name/"+uname+"','Unfollow "+unickname+" ?','jc','"+uname+"','"+unickname+"','"+status+"')\">Cancel</a></span>");
                    }
                } else {
                    ye_msg.open('Unfollowed ^_^',1,1);
                    $('#followsp_'+uname).html("<a class='bh' onclick=\"followop('addfollow/user_name/"+uname+"','','gz','"+uname+"','"+unickname+"','"+status+"')\">Follow</a>");
                }
            } else {
                ye_msg.open(msg,3,2);
            }
        });
    }
}
function followone(user_name,e) {
    tologin();
    $.get(siteurl+'Space/addfollow/user_name/'+user_name+'/rank/'+GetRandomNum(1,999999),
    function(msg){
        if (msg=='success') {
            $(e).attr("class","yst");
            $(e).attr("onclick","");
            $(e).html('Following');
        } else {
            ye_msg.open(msg,3,2);
        }
    });
}
function fltopic(topic,mes,op,obj) {
    tologin();
    var mymes;
    if (op=='fl') {
        mymes=true;
    } else {
        mymes=confirm(mes);
    }
    if(mymes==true){
        $.get(siteurl+'Topic/follow/keyword/'+topic+'/op/'+op+'/rank/'+GetRandomNum(1,999999),
        function(msg){
            if (msg=="success") {
                if (op=='fl') {
                    ye_msg.open('�ɹ���ע�û���',1,1);
                    $('#followtopic').html("<a class='bl' onclick=\"fltopic('"+topic+"','ȷ��Ҫ����ע�û��⣿','jc')\">����ע</a>");
                } else {
                    ye_msg.open('�ɹ�����ע�û���',1,1);
                    $('#followtopic').html("<a class='bh' onclick=\"fltopic('"+topic+"','','fl')\">��ע����</a>");
                    if (obj) {
                        $(obj).animate({opacity: 'toggle'}, "slow");
                    }
                }
            } else {
                ye_msg.open(msg,3,2);
            }
        });
    }
}
function jsop(url,mes){
    tologin();
    var mymes=confirm(mes);
    if(mymes==true){window.location=url;}
}
function dofavor(id){
    tologin();
    $.get(siteurl+'Space/dofavor/cid/'+id+"/rank/"+GetRandomNum(1,999999),
    function(msg){
        if (msg=='success') {
            ye_msg.open('�ղسɹ� ^_^',1,1);
        } else {
            ye_msg.open(msg,1,2);
        }
    });
}
function isfun(val) {
    if (val=="#Input topic#") {
        ye_msg.open('Please input your topic!',1,2);
        return false;
    } else if (val=="") {
        ye_msg.open('Please input your message!',1,2);
        return false;
    } else if (val.length>140)  {
        ye_msg.open('Message length can not over 140 characters!',1,2);
        return false;
    } else {
        return true;
    }
}
function isfun2(funame,msg) {
    if (funame=="") {
        ye_msg.open('Please select your friend!',1,2);
        return false;
    }
    if (msg=="") {
        ye_msg.open('Please input your message!',1,2);
        return false;
    } else if (msg.length>140)  {
        ye_msg.open('Message length can not over 140 characters!',1,2);
        return false;
    } else {
        return true;
    }
}
/*send msg start*/
function spnums(){
    var len=typenums('#pmcontentbox');
    if (len<0) {
        $("#sendmsgbox").html('<font color="red"><em>'+(-len)+'</em></font>');
    } else {
        $("#sendmsgbox").html('<em>'+len+'</em>');
    }
}
function atbox(funame) {
    tologin();
    var html;
    html ='<div id="pmessage" style="background:none"><table border="0" width="100%">';
    html+='<tr><td><textarea id="contentbox" class="input_text" style="width:395px;height:70px;">@'+funame+' </textarea><div id="emotion"></div></td></tr>';
    html+='<tr height="40px"><td><div class="fleft"><a href="javascript:void(0);" onclick="showemotion(\'emotion\',\'contentbox\')"><img src="'+pubdir+'images/facelist.gif"></a></div><div class="fright"><span class="tip2 sendsp"><em>140</em></span><a href="javascript:void(0);" onclick="sendTalk(1)"><img src="'+pubdir+'images/sendbtn.gif" alt="Submit"></a></div></td></tr></table></div>';
    ye_dialog.openHtml(html,'@'+funame,'450','180');
    $('#contentbox').focus();
    $('.sendsp').html('<em>'+(140-$.trim('@'+funame).length)+'</em>');
    $("#contentbox").keyup(function(){
        var len=typenums('#contentbox');
        if (len<0) {
            $(".sendsp").html('<font color="red"><em>'+(-len)+'</em></font>');
        } else {
            $(".sendsp").html('<em>'+len+'</em>');
        }
    });
}
function sendprimsgbox(funame) {
    tologin();
    var html;
    html ='<div id="pmessage"><table border="0" width="100%">';
    html+='<tr height="30px"><td width="50px">To</td><td><input type="text" class="input_text" id="senduser" style="width:195px"><span class="tip1">Please input your friend\'s name</span></td></tr>';
    html+='<tr><td valign="top">Content</td><td><textarea onkeyup="spnums()" id="pmcontentbox" class="input_text" style="width:350px;height:70px;"></textarea></td></tr>';
    html+='<tr><td colspan="2"><p><span class="tip2" id="sendmsgbox"><em>140</em></span><a href="javascript:void(0);" onclick="sendprimsg()"><img src="'+pubdir+'images/sendbtn.gif" alt="Sent"></a></p></td></tr></table></div>';
    ye_dialog.openHtml(html,'Send Message','450','220');
    if (funame) {
        $("#senduser").val(funame);
        $("#senduser").attr('readonly','readonly');
    } else {
        $("#senduser").autocomplete(siteurl+"Message/getMsgUser/rank/"+GetRandomNum(1,999999),{delay:400,minChars:1,matchSubset:0,matchContains:1,autoFill:0,scroll:0,width:170,height:170});
    }
}
function sendprimsg() {
    tologin();
    var funame=$("#senduser").val();
    var contents=$("#pmcontentbox").val();
    if (!funame || !contents) {
        ye_msg.open('Form is incomplete',1,2);
        return;
    }
    if (contents.length>140) {
        $('#sendmsgbox').hide();
        $('#sendmsgbox').fadeIn("normal");
        return;
    }
    $.post(siteurl+"Message/sendmsg",{funame:funame,content:contents},
    function(msg){
        if (msg=="success") {
            ye_msg.open('Message is sent',1,1);
            ye_dialog.close();
        } else {
            ye_msg.open(msg,1,2);
        }
    });
}
/*send msg end*/
/*send talk*/
function ctrlEnter_st(e){
    var ie =navigator.appName=="Microsoft Internet Explorer"?true:false;
    if(ie){
        if(event.ctrlKey && window.event.keyCode==13){sendTalk();}
    } else {
        if(isKeyTrigger(e,13,true)){sendTalk();}
    }
}
function sendTalk(noadd) {
    //tologin();
    $("#contentbox").val($("#contentbox").val().replace('#Input topic#',''));
    var topic=$('#topic').val();
    var cont=$("#contentbox").val();
    var morecontent=$("#morecontent").html();/*upload pic*/
    morecontent=morecontent==null?'':morecontent;
    if(cont==lasttalk && lasttalk!='') {
        ye_msg.open('Already sent!',1,2);
        return false;
    } else {
        lasttalk=cont;
    }
    if (!cont) {
        ye_msg.open('Content can\'t be blank',1,2);
        return false;
    }
    if (topic) {
        cont=topic+cont;
    }
    if (cont.length>140) {
        $('.sendsp').hide();
        $('.sendsp').fadeIn("normal");
        return;
    }
    $('#contentbox').val('');
    $.getJSON(siteurl+"MyTop_postNew", {blogContent:cont/*,morecontent:morecontent*/},
    function(obj){
        if ("success"==obj.result) {
			var data = "<li class=\"unlight\"><a href=\"" + obj.myaccount.accountName + "\" title=\"" + obj.myaccount.accountName + "\" class=\"avatar\">";
			var data1;
			if( obj.myaccount.iconUrl==null ) {
				data1 = "<img src=\"images/default.jpg\" alt=\"" + obj.myaccount.accountName + "\" />"
			} else {
				data1 = "<img src=\"" + obj.myaccount.iconUrl + "\" alt=\"" + obj.myaccount.accountName + "\" />";
			}
			var data2 = "</a><div class=\"\"><div class=\"content\"><a href=\"" + obj.myaccount.accountName + "\" class=\"author \">" + obj.myaccount.accountName + "</a><h6>:</h6><span id=\"cont" + obj.blogId + "\">" + obj.addBlog.content + "</span></div><span class=\"stamp fleft\">" + obj.addBlog.createTime + "</span><span class=\"stamp op\" style=\"float:right;white-space:nowrap\"><a href=\"javascript:void(0)\" onclick=\"retwit('" + obj.blogId + "')\">Foward</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href=\"javascript:void(0)\" onclick=\"replyajax('" + obj.blogId + "')\">Reply</a>&nbsp;&nbsp;|&nbsp;<a class=\"fav\" href=\"javascript:void(0)\" onclick=\"dofavor('" + obj.blogId + "')\" title=\"Favorite\">Favorite</a></span><div class=\"clearline\"></div><span id=\"reply_" + obj.blogId + "\" class=\"replyspan\"></span></div></li>"
			var data3 = data+data1+data2;
            if (noadd!=1) {
                var firstli,firstli2;
                //if (stalk=='1') {
                    firstli=$(".wa li").first();
                    firstli.before(data3);
                    firstli2=$(".wa li").first();
                    firstli2.css("display","none");
                    firstli2.animate({height: 'toggle', opacity: 'toggle'}, { duration: "slow" });
                //}
                $("ol li").slice(0, 1).mouseover(function(){
                   $(this).addClass("light");
                   $(this).removeClass("unlight");
                });
                $("ol li").slice(0, 1).mouseout(function(){
                   $(this).addClass("unlight");
                   $(this).removeClass("light");
                });
                $("ol li").slice(0, 1).find("a").focus(function(){this.blur()});
                if (topic) {
                    $("#keynum").html(parseInt($("#keynum").html())+1);
                }
                $("#nonemsg").remove();
            } else {
                ye_dialog.close();
            }
            $("#mymsgnum").html(parseInt($("#mymsgnum").html())+1);
            delUpload();/*clear pic*/
            picctrl();
            ye_msg.open('Send success.',1,1);
        } else {
            ye_msg.open(obj.resultMsg,3,2);
        }
        $('.sendsp').html("<span id='nums'>140</span>");
    });
}
/*topic*/
function topicajax(type) {
    var act;
    if (type==1) {
        act='mytopic';
        $('#topic1').attr('class','selected');
        $('#topic2').removeAttr('class');
    } else {
        act='tjtopic';
        $('#topic2').attr('class','selected');
        $('#topic1').removeAttr('class');
    }
    $('.tagB').html('<br/><center><img src="'+pubdir+'images/loading.gif">Loading topics...</center><br/>');
    $.get(siteurl+"Topic/"+act+"/rank/"+GetRandomNum(1,999999),
    function(msg){
        $('.tagB').html(msg);
    });
}
/*reply start*/
function ctrlEnter_rb(e,id,closebox){
    var ie =navigator.appName=="Microsoft Internet Explorer"?true:false;
    if(ie){
        if(event.ctrlKey && window.event.keyCode==13){replysend(id,closebox);}
    } else {
        if(isKeyTrigger(e,13,true)){replysend(id,closebox);}
    }
}
function replyajax(contid) {
    if ($('#reply_'+contid).html()) {
        $('#reply_'+contid).html('');
    } else {
        $('#reply_'+contid).html('<span style="margin:10px 0 0 30px"><img src="'+pubdir+'images/spinner.gif"></span>');
        $.get(siteurl+"Space/reply/cid/"+contid+"/rank/"+GetRandomNum(1,999999),
        function(msg){
            $('#reply_'+contid).html(msg);
            $('#replybox_'+contid).focus();
        });
    }
}
function replyajaxbox(contid) {
    if ($('#reply_'+contid).html()) {
        $('#reply_'+contid).html('');
    } else {
        var html='<div class="status_reply_list"><div class="arrow1"></div><div class="top"></div><div class="cont"><table border="0" width="100%"><tr><td><div class="fleft" style="margin-top:8px"><a href="javascript:void(0);" onclick="showemotion(\'emotion_'+contid+'\',\'replybox_'+contid+'\')"><img src="'+pubdir+'images/facelist.gif"></a></div><textarea id="replybox_'+contid+'" onkeyup="replynums(\'replybox_'+contid+'\',\'rnum_'+contid+'\');" onkeydown="javascript:return ctrlEnter_rb(event,\''+contid+'\',1);" class="input_text replytextarea"></textarea><div class="clearline"></div></td></tr><tr><td><div id="emotion_'+contid+'"></div><div class="fleft"><input type="checkbox" class="replaycheckbox" id="replycheckbox_'+contid+'"><label for="replycheckbox_'+contid+'" class="replycheckbox">Foward to by blog</label></div><div class="fright"><span class="inputnum" id="rnum_'+contid+'"><em>140</em></span><input type="button" id="replybutton_'+contid+'" class="button1" value="Reply" onclick="replysend(\''+contid+'\',1)"/></div><div class="clearline"></div></td></tr></table></div><div class="bottom"></div></div>';
        $('#reply_'+contid).html(html);
        $('#replybox_'+contid).focus();
    }
}
function replysend(id,closebox) {
    tologin();
    $('#replybox_'+id).val($('#replybox_'+id).val().replace('#Input topic#',''));
    var isret=$("#replycheckbox_"+id).attr('checked');
    var cont=$('#replybox_'+id).val();
    if ($('#replybox_'+id).val()=="") {
        ye_msg.open('Please input your replay content��',1,2);
        return false;
    } else if (cont.length>140)  {
        $('#rnum_'+id).hide();
        $('#rnum_'+id).fadeIn("normal");
        return;
    } else {
        if(cont==lasttalk && lasttalk!='') {
            ye_msg.open('Already sent',1,2);
            return false;
        } else {
            lasttalk=cont;
        }
        $('#replybutton_'+id).css("background","#ffffff");
        $('#replybutton_'+id).css("color","#000000");
        $('#replybutton_'+id).attr("disabled","disabled");
        $.post(siteurl+"Space/doreply",{sid:id,closebox:closebox,scont:cont,rck:isret},
        function(msg){
            var stdata=jQuery.parseJSON(msg);
            if (stdata.ret=="success") {
                if (parseInt(closebox)==1) {
                    ye_msg.open('Reply success!',1,1);
                } else {
                    var firstli,firstli2;
                    firstli=$("#reply_"+id+" .reply_list_ul li").first();
                    if (firstli.length>0) {
                        firstli.before(stdata.data);
                        firstli2=$("#reply_"+id+" .reply_list_ul li").first();
                        firstli2.css("display","none");
                        firstli2.animate({height: 'toggle', opacity: 'toggle'}, { duration: "slow" });
                    } else {
                        $("#reply_"+id+" .reply_list_ul").append(stdata.data);
                        firstli2=$("#reply_"+id+" .reply_list_ul li").first();
                        firstli2.css("display","none");
                        firstli2.animate({height: 'toggle', opacity: 'toggle'}, { duration: "slow" });
                    }
                }
            } else {
                ye_msg.open(stdata.data,1,2);
            }
            $('#rnum_'+id).html("<em>140</em>");
            $('#replybox_'+id).val("");
            $('#replybutton_'+id).removeAttr("disabled");
            $('#replybutton_'+id).css("background","#4abae3");
            $('#replybutton_'+id).css("color","#ffffff");
        });
    }
}
function replyajaxin(inputid,nickname) {
    var atto='@'+nickname+' ';
    $('#replybox_'+inputid).focus();
    $('#replybox_'+inputid).val(atto);
}
function replynums(val,nums){
    var len=typenums("#"+val);
    if (len<0) {
        $("#"+nums).html('<font color="red"><em>'+(-len)+'</em></font>');
    } else {
        $("#"+nums).html('<em>'+len+'</em>');
    }
    $("#"+val).height('18px');
    var setheight = $("#"+val).get(0).scrollHeight;
    if($("#"+val).attr("_height") != setheight) {
        $("#"+val).height(setheight+"px").attr("_height",setheight);
    } else {
        $("#"+val).height($("#"+val).attr("_height")+"px");
    }
}
/*reply start*/
/*ret start*/
function retnums(val,nums){
    var len=typenums("#"+val);
    if (len<0) {
        $("#"+nums).html('<font color="red"><em>'+(-len)+'</em></font>');
    } else {
        $("#"+nums).html('<em>'+len+'</em>');
    }
}
function retwit(contid){
    tologin();
    var retcont=$("#ret"+contid).html();
    if (retcont) {
        var emo= new Array("(����)","(��ϲ)","(����)","(Ż��)","(�ݰ�)","(��Ц)","(��)","(ɫ)","(Ʋ��)","(��Ƥ)","(����)","(͵Ц)","(�ʻ�)","(����)","(��)","(����)","(����)","(����)","(��)","(��ŭ)","(����)","(Ͷ��)","(���)","(����)","(���)","(����)","(���)","(�ѹ�)","(����)","(����)","(ץ��)","(��Ʒ)","(Ǯ)","(��)","(����)","(ʹ��)","(����)","(����)","(����)","(����)","(˯)","(��)","(��Ѫ)","(�ɰ�)","(����)","(��)","(лл)","(��)","(ʤ��)");
        retcont= retcont.replace(/<a class="atlink" href="(.*?)">(.*?)<\/a>/gi,'$2');
        retcont= retcont.replace(/<img class="emo" src="(.*?)" alt="(.*?)">/gi,'$2');
    }
    var retconttp=explode(retcont,'||',false);
    var newretcont='';
    var at=$("#ret"+contid).prev().prev().attr("title");
    var html='<table border="0" width="350px" style="margin-left:17px"><tr><td valign="top" height="60px"><div id="retbody" style="padding-bottom:10px"></div></td></tr><tr><td valign="top" style="border-top:1px dashed #cccccc"><div style="color:#999;margin-top:10px"><span class="fleft">�����˵���䣺<a href="javascript:void(0);" onclick="showemotion(\'emotionret_'+contid+'\',\'retbox_'+contid+'\')"><img src="'+pubdir+'images/facelist.gif"></a></span><span class="retbox" id="num_'+contid+'">��������<em>140</em>��</span></div><div id="emotionret_'+contid+'"></div><textarea id="retbox_'+contid+'" class="input_text" onkeyup="retnums(\'retbox_'+contid+'\',\'num_'+contid+'\');" style="width:350px;height:100px;margin:5px auto;color:#999"></textarea></td></tr><tr><td align="center" height="50px"><input type="button" id="replybutton_'+contid+'" class="button2" value="����ת��" onclick="retwitact(\''+contid+'\')"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="button3" value="ȡ��ת��" onclick="ye_dialog.close()"/></td></tr></table>';
    ye_dialog.openHtml(html,'ת�����ҵ�΢��','400','330');

    var rethtml=clearhtml($("#cont"+contid).html());
    rethtml=rethtml.replace("��������ת����ת�鿴ԭͼ","");
    $('#retbody').html('ת��'+rethtml);

    if (at!=undefined) {
        if (retconttp[0]!=null && retcont!=undefined && retcont!=null && retcont!='') {
            if (countCharacters($.trim(retconttp[0]),1)=='@') {
                retconttp[0]=' || '+$.trim(retconttp[0]);
            }
            retcont=" || "+"@"+at+" "+$.trim(retconttp[0]);
            if (retconttp.length>1) {
                for (var i=1; i<retconttp.length; i++) {
                    newretcont+=" || " +$.trim(retconttp[i]);
                }
            }
        } else {
            retcont=" || "+"@"+at;
        }
        newretcont=retcont+newretcont;
    }
    if (retcont) {
        $('#retbox_'+contid).val(newretcont);
        retnums('retbox_'+contid,'num_'+contid);
    }
    var contheight=$('#retbody').height();
    contheight=contheight<=60?60:contheight;
    $('#ye_dialog_window').css('height',(contheight+280)+'px');
    var textArea = document.getElementById('retbox_'+contid);
    if (document.selection) {
         var rng = textArea.createTextRange();
         rng.collapse(true);
         rng.moveEnd("character",0);
         rng.moveStart("character",0);
         rng.select();
    } else if (textArea.selectionStart || (textArea.selectionStart == '0')) {
        textArea.selectionStart = 0;
        textArea.selectionEnd = 0;
    }
    textArea.focus();
}
function retwitact(contid) {
    tologin();
    var retwitval=$("#retbox_"+contid).val();
    if (retwitval.length>140) {
        $('#num_'+contid).hide();
        $('#num_'+contid).fadeIn("normal");
        return;
    }
    if(retwitval==lasttalk && lasttalk!='') {
        ye_msg.open('Aready sent!',1,2);
        return false;
    } else {
        lasttalk=retwitval;
    }
    ye_dialog.close();
    $.post(siteurl+"Space/retwit",{cid:contid,retcont:retwitval},
    function(msg){
        var stdata=jQuery.parseJSON(msg);
        if (stdata.ret=="success") {
            var firstli,firstli2;
            if (stalk==1) {
                firstli=$(".wa li").first();
                firstli.before(stdata.data);
                firstli2=$(".wa li").first();
                firstli2.css("display","none");
                firstli2.animate({height: 'toggle', opacity: 'toggle'}, { duration: "slow" });
            }
            $("ol li").slice(0, 1).mouseover(function(){
               $(this).addClass("light");
               $(this).removeClass("unlight");
            });
            $("ol li").slice(0, 1).mouseout(function(){
               $(this).addClass("unlight");
               $(this).removeClass("light");
            });
            $("ol li").slice(0, 1).find("a").focus(function(){this.blur()});
            $("#nonemsg").remove();
            ye_msg.open('Foward success ^_^',1,1);
        } else {
            ye_msg.open(stdata.data,1,2);
        }
    });
}
/*ret end*/
function clearhtml(text) {
    var regEx = /<[^>]*>/g;
    return text.replace(regEx, "");
}
function isChinese(str) {
   var lst = /[u00-uFF]/;
   return !lst.test(str);
}
function CheckLen(str) {
   var strlength=0;
   for (i=0;i<str.length;i++) {
     if (isChinese(str.charAt(i))==true) {
        strlength=strlength + 2;
     } else {
        strlength=strlength + 1;
     }
   }
   return strlength;
}
function countCharacters(str, len) {
    if(!str || !len) { return ''; }
    var a = 0;
    var i = 0;
    var temp = '';
    for (i=0;i<str.length;i++) {
        a++;
        if(a > len) { return temp; }
         temp += str.charAt(i);
    }
    return str;
}
function countCharacters2(str, startlen,len) {
    if(!str) { return ''; }
    var _startlen=startlen?startlen:0;
    var _len=len?len:(str.length-startlen);
    var a = 0;
    var i = 0;
    var temp = '';
    for (i=_startlen;i<str.length;i++) {
        a++;
        if(a == _len+1) {
            return temp;
        } else {
            temp += str.charAt(i);
        }
    }
    return temp;
}
function cnCharacters(str, len) {
    if(!str || !len) { return ''; }
    var a = 0;
    var i = 0;
    var temp = '';
    for (i=0;i<CheckLen(str);i++) {
        if (isChinese(str.charAt(i))==true) {
            a+=2;
        } else {
            a++;
        }
        if(a > len) { return temp; }
        temp += str.charAt(i);
    }
    return str;
}
function submit_login() {
    var t1=$('#username').val();
    var t2=$('#password').val();
	var t3=$('#remeberMe').val();
	if( t1=="Input your name" ) {t1="";}
	if( t2=="******" ) {t2="";}
	$.getJSON(siteurl+"Login_Login",{username:t1,password:t2,remeberMe:t3},
	function(obj){
		if( "success" == obj.result ) {
			ye_dialog.openHtml("<div class='regok'>Sign in OK. The next step.  </div>",'Sign in',400,100);
			setInterval(function(){window.location.href=siteurl+obj.resultMsg;}, 1000);
		} else {
			ye_msg.open(obj.resultMsg,5,2);
		}
	});
}
/*reg check*/
function check_register() {
    //var t0=$('#invitecode').val();
    var t1=$('#username').val();
    var t2=$('#email').val();
    var t3=$('#password').val();
    var t4=$('#repassword').val();
    //var t5=$('#inviteuid').val();
    if (regname(t1)==false) {
        ye_msg.open("Only use letters, numbers and '_'",5,2);
        return false;
    }
    $.getJSON(siteurl+"Register",{/*invitecode:t0,*/username:t1,email:t2,password:t3,repassword:t4,/*inviteuid:t5*/},
    function(obj){
        if( "success" == obj.result ) {
			ye_dialog.openHtml("<div class='regok'>Sign up OK. The next step.  </div>",'Sign up',400,100);
			setInterval(function(){window.location.href=siteurl+obj.resultMsg;}, 1000);
		} else {
           ye_msg.open(obj.resultMsg,5,2);
        }
    });
}
function isLegal(str){
    if(str >= '0' && str <= '9'){return true;}
    if(str >= 'a' && str <= 'z'){return true;}
    if(str >= 'A' && str <= 'Z'){return true;}
    if(str == '_'){return true;}
    var reg = /^[\u4e00-\u9fa5]+$/i;
    if (reg.test(str)){return true;}
    return false;
}
function regname(str){
    if(str=="" || str==undefined) {return false;}
    for (i=0; i<str.length; i++) {
        if (!isLegal(str.charAt(i))){
            return false;
        }
    }
    return true;
}
function reportbox() {
    tologin();
    var html='<div id="report"><p>�������΢���з�����ɫ�顢������������Υ�������,���ύ�����ǽ����촦�?</p><p><select id="reporttp"><option value="0" selected="selected">=��ѡ������Ϣ������=</option><option value="1">�漰��ɫ�ͱ���</option><option value="2">���η���</option><option value="3">������Ȩ</option><option value="4">��������Ϣ</option></select></p><p>������Ϣ���������ύ������Ϣ�ĵ�ַ</p><p><textarea id="describe" class="input_text">��ǰ��ַ��'+document.URL+'\n\r�ٱ����ݣ�</textarea></p><p><center><input type="button" class="button2" value="�ύ��Ϣ" onclick="reportact()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="button3" type="button" value="�رմ���" onclick="ye_dialog.close()"/></center></p></div>';
    ye_dialog.openHtml(html,'�ٱ�������Ϣ','400','350');
}
function reportact() {
    tologin();
    var l=$('#reporttp').val();
    var d=$('#describe').val();
    if(l==0 || !d){
        ye_msg.open('��ľٱ���Ϣû����д����',1,2);
        return false;
    }
    $.post(siteurl+"Space/report",{reporttp:l,describe:d},
    function(msg){
        if (msg=="success") {
           ye_msg.open('��л��ľٱ������ǻᾡ�촦��^_^',1,1);
           ye_dialog.close();
        } else {
            ye_msg.open(msg,3,2);
        }
    });
}
function indextop() {if(jQuery.browser.safari) {jQuery('body').animate({scrollTop:0}, 'fast');return false;} else {jQuery('html').animate({scrollTop:0}, 'fast');return false;}}
/*upload pic*/
function cencelUpload() {
    $("#imageUpload").attr("src","about:blank");
    $("#priviewbtn").hide();
    $("#priviewbtn").html('');
    $("#uploading").hide();
    $("#uploadbtn").val('');
    $("#imageUpload").contents().find("body").html('');
    $("#morecontent").html('');
}
function uploadpic(file) {
    var pic=file.toLowerCase();
    if(pic.indexOf( ".gif")>-1 || pic.indexOf( ".jpg")>-1 || pic.indexOf( ".bmp")>-1 || pic.indexOf( ".png")>-1) {
        $("#imageUpload").attr("src","about:blank");
        $("#priviewbtn").hide();
        $("#priviewbtn").html('');
        $("#uploading").show();
        $("#upform").submit();
        $('#imageUpload').unbind("load");
        $("#imageUpload").load(function(){loadpic();});
    } else {
        ye_msg.open('�ܱ�Ǹ�����ϴ����ļ���ʽ����ȷ��',1,2);
        $("#uploadbtn").val('');
    }
}
function loadpic() {
    var htmls=$("#imageUpload").contents().find("body").html();
    var obj = jQuery.parseJSON(htmls);
    if (htmls) {
        if (obj.ret=='success') {
            $("#uploading").hide();
            $("#priviewbtn").show();
            $("#priviewbtn").html(obj.name+"<a href='javascript:void(0);' onclick='delUpload()'> [Remove]</a>");
            $("#priviewpoic").html("<img src='"+obj.img+"'>");
            $("#imageUpload").contents().find("body").html('');
            $("#morecontent").html(obj.content);
            if (!$('#contentbox').val()) {
                $('#contentbox').val('I uploaded a picture');
            }
        } else {
            $("#uploading").hide();
            $("#priviewbtn").hide();
            $("#priviewbtn").html('');
            $("#priviewpoic").html('');
            $("#imageUpload").contents().find("body").html('');
            $("#morecontent").html('');
            ye_msg.open(obj.ret,3,2);
        }
    }
}
function delUpload() {
    $("#uploading").hide();
    $("#priviewbtn").hide();
    $("#priviewbtn").html('');
    $("#sharephoto").hide();
    $("#priviewpoic").html('');
    $("#uploadbtn").val('');
    $("#imageUpload").contents().find("body").html('');
    $("#morecontent").html('');
}
function ETCopy(id){
    var testCode=document.getElementById(id).value;
    if(copy2Clipboard(testCode)!=false){
        document.getElementById(id).select() ;
        ye_msg.open('Copied to clipboard!',3,1);
    }
}
copy2Clipboard=function(txt){
    if(window.clipboardData){
        window.clipboardData.clearData();
        window.clipboardData.setData("Text",txt);
    }
    else if(navigator.userAgent.indexOf("Opera")!=-1){
        window.location=txt;
    }
    else if(window.netscape){
        try{
            netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
        }
        catch(e){
            alert("���firefox��ȫ������������м������������'about:config'��signed.applets.codebase_principal_support'����Ϊtrue'֮�����ԣ����·��Ϊfirefox��Ŀ¼/greprefs/all.js");
            return false;
        }
        var clip=Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
        if(!clip){return;}
        var trans=Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
        if(!trans){return;}
        trans.addDataFlavor('text/unicode');
        var str=new Object();
        var len=new Object();
        var str=Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
        var copytext=txt;str.data=copytext;
        trans.setTransferData("text/unicode",str,copytext.length*2);
        var clipid=Components.interfaces.nsIClipboard;
        if(!clip){return false;}
        clip.setData(trans,null,clipid.kGlobalClipboard);
    }
};
function GetRandomNum(Min,Max) {
    var Range = Max - Min;
    var Rand = Math.random();
    return(Min + Math.round(Rand * Range));
}
function dosearch(){
    var v=$('#searchr-input').val();
    var t=$('#commonsearch').val();
    if(v!='Keyword' && v!=''){
        if (t=='user') {
            window.location.href=siteurl+'Find/search?sname='+v;
        } else {
            window.location.href=siteurl+'Pub/index?t=s&q='+v;
        }
    }else{
        $('#searchr-input').val('Keyword');
    }
}
function Sharetopic(topic) {
    topic=topic==undefined?'Input topic':topic;
    var tlenght=topic.length+1;
    var cont=$('#contentbox').val();
    var pos=cont.indexOf('#'+topic+'#');
    if (pos < 0) {
        $('#contentbox').val(cont+'#'+topic+'#');
        cont=$('#contentbox').val();
        pos=cont.indexOf('#'+topic+'#');
    }
    if (topic!='Input topic') {
        $('#contentbox').val($('#contentbox').val().replace('#Input topic#',''));
        $('#contentbox').focus();
    } else {
        var textArea = document.getElementById('contentbox');
        if (document.selection) {
             var rng = textArea.createTextRange();
             rng.collapse(true);
             rng.moveEnd("character",parseInt(pos)+tlenght);
             rng.moveStart("character",parseInt(pos)+1);
             rng.select();
        } else if (textArea.selectionStart || (textArea.selectionStart == '0')) {
            textArea.selectionStart = parseInt(pos)+1;
            textArea.selectionEnd = parseInt(pos)+tlenght;
        }
        textArea.focus();
    }

}
function explode(inputstring, separators, includeEmpties) {
    inputstring = new String(inputstring);
    separators = new String(separators);
    if(separators == "undefined") {
        separators = " :;";
    }
    fixedExplode = new Array(1);
    currentElement = "";
    count = 0;
    for(x=0; x < inputstring.length; x++) {
        str = inputstring.charAt(x);
        if(separators.indexOf(str) != -1) {
            if ( ( (includeEmpties <= 0) || (includeEmpties == false)) && (currentElement == "")) {
            }else {
                fixedExplode[count] = currentElement;
                count++;
                currentElement = "";
            }
        }
        else {
            currentElement += str;
        }
    }
    if (( ! (includeEmpties <= 0) && (includeEmpties != false)) || (currentElement != "")) {
        fixedExplode[count] = currentElement;
    }
    return fixedExplode;
}
function isKeyTrigger(e,keyCode){
    var argv = isKeyTrigger.arguments;
    var argc = isKeyTrigger.arguments.length;
    var bCtrl = false;
    if(argc > 2){
        bCtrl = argv[2];
    }
    var bAlt = false;
    if(argc > 3){
        bAlt = argv[3];
    }
    var nav4 = window.Event ? true : false;
    if(typeof e == 'undefined') {
        e = event;
    }
    if( bCtrl && !((typeof e.ctrlKey != 'undefined') ? e.ctrlKey : e.modifiers & Event.CONTROL_MASK > 0)){
        return false;
    }
    if( bAlt && !((typeof e.altKey != 'undefined') ? e.altKey : e.modifiers & Event.ALT_MASK > 0)){
        return false;
    }
    var whichCode = 0;
    if (nav4) whichCode = e.which;
    else if (e.type == "keypress" || e.type == "keydown") whichCode = e.keyCode;
    else whichCode = e.button;
    return (whichCode == keyCode);
}
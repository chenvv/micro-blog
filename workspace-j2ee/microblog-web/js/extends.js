/***********************************************************
    [EasyTalk] (C)2009 - 2011 nextsns.com
    This is NOT a freeware, use is subject to license terms

    @Filename extends.js $

    @Author hjoeson $

    @Date 2011-01-09 08:45:20 $
*************************************************************/

Tips = function() {
    var tip;var error;
    switch(setok) {
        case "theme1":tip='ģ�屣��ɹ�^_^';error=1;break;
        case "theme2":tip='ģ������ʧ�ܣ�';error=2;break;
        case "home1":tip='��û������㲥����';error=2;break;
        case "home4":tip='�����ַ���Ϸ�';error=2;break;
        case "home5":tip='��������̫��,���ɳ���100��';error=2;break;
        case "home6":tip='����ɹ���';error=1;break;
        case "home7":tip='����ĵ�ַ����ʶ��';error=2;break;
        case "account1":tip='��������������벻һ����Ϊ�գ�';error=2;break;
        case "account2":tip='�����޸ĳɹ�';error=1;break;
        case "account3":tip='ԭʼ�������';error=2;break;
        case "finder1":tip='�ɹ���������^_^';error=1;break;
        case "finder2":tip='û����д����ĵ����ʼ�';error=2;break;
        case "login1":tip='���ã������ʺű�����Ա���Σ����ܵ�¼��';error=2;break;
        case "login2":tip='�û�������������������µ�¼��';error=2;break;
        case "mail1":tip='��֤�ʼ��Ѿ����ͣ������';error=1;break;
        case "mail2":tip='�����ʽ����ȷ';error=2;break;
        case "mail3":tip='�����Ѵ��ڣ��������������';error=2;break;
        case "mail4":tip='�µ����ʼ��;ɵ����ʼ�����һ��';error=2;break;
        case "mail5":tip='û����д�����ʼ�';error=2;break;
        case "mail6":tip='�����Ѿ���֤�ɹ�';error=1;break;
        case "mail7":tip='�����Ѿ���֤ʧ��';error=2;break;
        case "mail8":tip='�����Ѿ�����';error=1;break;
        case "reset1":tip='δ�ҵ����������ַ';error=2;break;
        case "reset2":tip='�����ʼ��ѷ����������';error=1;break;
        case "reset3":tip='�õ�ַ�Ѿ����ڣ������¡��һ����롱';error=2;break;
        case "reset4":tip='��ַ��֤ʧ�ܣ������¡��һ����롱';error=2;break;
        case "reset5":tip='�������óɹ������¼';error=1;break;
        case "setting1":tip='�������Ա𡢾�ס�ز���Ϊ��Ŷ��';error=2;break;
        case "setting2":tip='��������ȷ���߰�����������ַ���';error=2;break;
        case "setting3":tip='��Ϣ����ɹ���';error=1;break;
        case "setting4":tip='�����Ѿ����ڣ����������룡';error=2;break;
        case "settingfirst":tip='���ǵ�һ�ε�½΢��������������������';error=3;break;
        case "feedback1":tip='��Ϣ�ύ�ɹ�����л���ķ�����';error=1;break;
        case "feedback2":tip='�ܱ�Ǹ���ύ��Ϣʧ���ˣ�';error=2;break;
        case "report1":tip='��л���ľٱ������ǻἰʱ����';error=1;break;
        case "report2":tip='��û����д�����ٱ���Ϣ��';error=2;break;
        case "upload1":tip='��ʧ�ܣ��ļ���������ļ������ڣ�';error=2;break;
        case "upload2":tip='�ϴ�ͼƬ�����������2M֮�ڣ�';error=2;break;
        case "upload3":tip='�ϴ�ʧ�ܣ�ͼƬ��ʽ����ȷ��';error=2;break;
        case "upload4":tip='�ϴ�ʧ�ܣ������ļ������ڣ�';error=2;break;
        case "face1":tip='ͷ����³ɹ�';error=1;break;
        case "face2":tip='����û��ѡ��ͼƬ';error=2;break;
        case "activation1":tip='���������������������';error=2;break;
        case "activation2":tip='�ʺż���ɹ�';error=1;break;
        case "activation3":tip='�ʺż���ʧ��';error=2;break;
        case "activation4":tip='�ܱ�Ǹ�����ʺŲ���ʹ��';error=2;break;
        default:tip=0;error=0;break;
    }
    if (tip && error) {ye_msg.open(tip,3,error);}
}
jQuery.fn.rotate = function(angle,whence) {
    var p = this.get(0);
    // we store the angle inside the image tag for persistence
    if (!whence) {
        p.angle = ((p.angle==undefined?0:p.angle) + angle) % 360;
    } else {
        p.angle = angle;
    }
    if (p.angle >= 0) {
        var rotation = Math.PI * p.angle / 180;
    } else {
        var rotation = Math.PI * (360+p.angle) / 180;
    }
    var costheta = Math.cos(rotation);
    var sintheta = Math.sin(rotation);
    if (document.all && !window.opera) {
        var canvas = document.createElement('img');
        canvas.src = p.src;
        canvas.height = p.height;
        canvas.width = p.width;
        canvas.style.filter = "progid:DXImageTransform.Microsoft.Matrix(M11="+costheta+",M12="+(-sintheta)+",M21="+sintheta+",M22="+costheta+",SizingMethod='auto expand')";
    } else {
        var canvas = document.createElement('canvas');
        if (!p.oImage) {
            canvas.oImage = new Image();
            canvas.oImage.src = p.src;
        } else {
            canvas.oImage = p.oImage;
        }
        canvas.style.width = canvas.width = Math.abs(costheta*canvas.oImage.width) + Math.abs(sintheta*canvas.oImage.height);
        canvas.style.height = canvas.height = Math.abs(costheta*canvas.oImage.height) + Math.abs(sintheta*canvas.oImage.width);
        var context = canvas.getContext('2d');
        context.save();
        if (rotation <= Math.PI/2) {
            context.translate(sintheta*canvas.oImage.height,0);
        } else if (rotation <= Math.PI) {
            context.translate(canvas.width,-costheta*canvas.oImage.height);
        } else if (rotation <= 1.5*Math.PI) {
            context.translate(-costheta*canvas.oImage.width,canvas.height);
        } else {
            context.translate(0,-sintheta*canvas.oImage.width);
        }
        context.rotate(rotation);
        context.drawImage(canvas.oImage, 0, 0, canvas.oImage.width, canvas.oImage.height);
        context.restore();
    }
    canvas.className='maxImg';
    canvas.angle = p.angle;
    p.parentNode.replaceChild(canvas, p);
}
jQuery.fn.rotateRight = function(angle) {
    this.rotate(angle==undefined?90:angle);
}
jQuery.fn.rotateLeft = function(angle) {
    this.rotate(angle==undefined?-90:-angle);
}
/*followpreview*/Followpreview = function() {var a={};$(".followpreview").mouseover(function(){var h=$(this);var b=h.attr("id"),d=h.offset().left,j=h.offset().top+h.height(),g="";var e=$("body").width();if(e-d<210){d=d-186;g="followerPreviewBoxArrRight"}else{g="followerPreviewBoxArrLeft";}a[b]=window.setTimeout(function(){var l="Box"+b;var k=b.replace("fu","");if(document.getElementById(l)==null){$("body").append('<div class="followerPreviewBox" id="'+l+'"></div>');$("#"+l).css({left:d,top:j}).fadeIn(500);$.ajax({type: "GET",url:siteurl+"/Api/userpreview/uid/"+k+"/class/"+g+"/rank/"+GetRandomNum(1,999999),success: function(msg){$("#"+l).html(msg).css("backgroundImage","none");}});}else{$("#"+l).fadeIn(500)}},500);function c(){var l=$(this).attr("id");window.clearTimeout(a[l]);var k="Box"+l;$("#"+k).fadeOut(500)}}).mouseout(function(){var c=$(this).attr("id");window.clearTimeout(a[c]);var b="Box"+c;$("#"+b).remove()});}
/*media*/function showFlash(host, flashvar, obj, shareid) {var flashAddr = {
'youku.com' : 'http://player.youku.com/player.php/sid/FLASHVAR/v.swf',
'ku6.com' : 'http://player.ku6.com/refer/FLASHVAR/v.swf',
'tudou.com' : 'http://www.tudou.com/v/FLASHVAR/v.swf',
'sohu.com' : 'http://v.blog.sohu.com/fo/v4/FLASHVAR',
'mofile.com' : 'http://tv.mofile.com/cn/xplayer.swf?v=FLASHVAR',
'sina.com.cn' : 'http://vhead.blog.sina.com.cn/player/outer_player.swf?vid=FLASHVAR',
'music' : 'FLASHVAR','flash':'FLASHVAR'};var flash = '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="390" height="310"><param name="movie" value="FLASHADDR" /><param name="quality" value="high" /><param name="bgcolor" value="#FFFFFF" /><embed width="390" height="310" menu="false" quality="high" src="FLASHADDR" type="application/x-shockwave-flash" /></object>';var videoFlash = '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="390" height="395"><param value="transparent" name="wmode"/><param value="FLASHADDR" name="movie" /><embed src="FLASHADDR" wmode="transparent" allowfullscreen="true" type="application/x-shockwave-flash" width="390" height="360"></embed></object>';var musicFlash = '<object id="audioplayer_SHAREID" height="24" width="290" data="'+pubdir+'/images/player.swf" type="application/x-shockwave-flash"><param value="'+pubdir+'/images/player.swf" name="movie"/><param value="autostart=yes&righticon=0xF2F2F2&righticonhover=0xFFFFFF&text=0x999999&slider=0x357DCE&track=0xFFFFFF&border=0xFFFFFF&loader=0xcccccc&soundFile=FLASHADDR" name="FlashVars"/><param value="transparent" name="wmode"/><param value="high" name="quality"/><param value="false" name="menu"/><param value="#FFFFFF" name="bgcolor"/></object>';var musicMedia = '<object height="64" width="290" data="FLASHADDR" type="audio/x-ms-wma"><param value="FLASHADDR" name="src"/><param value="1" name="autostart"/><param value="true" name="controller"/></object>';var flashHtml = videoFlash;var videoMp3 = true;if('' == flashvar) {return false;}if('music' == host) {var mp3Reg = new RegExp('.mp3$', 'ig');var flashReg = new RegExp('.swf$', 'ig');flashHtml = musicMedia;videoMp3 = false;if(mp3Reg.test(flashvar)) {videoMp3 = true;flashHtml = musicFlash;} else if(flashReg.test(flashvar)) {videoMp3 = true;flashHtml = flash;}}flashvar = encodeURI(flashvar);if(flashAddr[host]) {var flash = flashAddr[host].replace('FLASHVAR', flashvar);flashHtml = flashHtml.replace(/FLASHADDR/g, flash);flashHtml = flashHtml.replace(/SHAREID/g, shareid);}if(!obj) {$('#flash_div_' + shareid).html(flashHtml);}if(flashAddr[host]) {$("<div id='flash_div_"+shareid+"'></div>").appendTo(obj.parentNode);$("#flash_div_"+shareid).html(flashHtml);$("#flash_div_"+shareid).append("&nbsp;&nbsp;<a class='shouqi' title='����' onclick='$(\"#flash_div_"+shareid+"\").remove();$(\"#img_"+shareid+"\").css(\"display\",\"block\")' href='##'><img src='"+pubdir+"/images/top.gif' style='width:12px;height:15px;padding:0px'></a>");$(obj).css("display","none");}}
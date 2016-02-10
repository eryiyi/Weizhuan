//去掉前后空格
function Trim (str) {
	return str.replace(/(^\s*)|(\s*$)/g,"");
}

//是不是时间格式
function isTime(date, format) {
	if(format==null||format==""){
		format=":";
	}
	var arr = date.split(format);
	if(arr.length!=3){
		return false
	}
	if(isNaN(arr[0])||arr[0]>24||arr[0]<0){
		return false
	}
	if(isNaN(arr[1])||arr[1]>60||arr[1]<0){
		return false
	}
	if(isNaN(arr[2])||arr[2]>60||arr[2]<0){
		return false
	}
	return true;
}

//是否符合给定长度并且不为空
function val_len(object,info,min,max){
	if(!valLength(Trim(object.value),min,max)){
		alert(info);
		object.focus();
		return false;
	}
	else{
		return true;
	}
}

//是否符合给定长度
function valLength(s1,minsize,maxsize)
{
	if (minsize == Number.MAX_VALUE)
		minsize = 0;
	var len = checkLength(s1);
	if (len>=minsize && len <= maxsize ){
		return true;
	}
	else{
		return false;
	}
}

//检查是否有HTML标记
function hasQutMark(srcstr) {
	if(srcstr.length==0) {
		return false;
	}
	for(i=0;i<srcstr.length;i++)
	{
		var charI = srcstr.charAt(i);
		if(charI=="'"||charI=="\""||charI=="."||charI=="<"||charI==">"||charI==":"||charI=="?")
		{
			return true;
		}
	}
	return false;
}

//是否符合邮箱格式
function isEmail(email,info) {
	//var	re = /^[0-9\s]*$/;
	//if (js_value.match (re)) {
	//	return	true;
	//}
	//return	false;
	var reg =/^[a-zA-Z0-9_\-]{1,}@[a-zA-Z0-9_\-]{1,}\.[a-zA-Z0-9_\-.]{1,}$/;
	if (!reg.test(email.value)) {
		alert(info);
		email.focus();
		return false;
	}else{
		return true;
	}
}
//是否符合QQ格式
function isQQ(qq,info) {
	//var	re = /^[0-9\*\-( )]*$/;
	//if (js_value.match (re)) {
	//	return	true;
	//}
	//return	false;
	if (qq.value.length==0){
		return true;
	}
	var reg =/^[1-9][0-9]{4,9}$/;

	if (!reg.test(qq.value)) {
		alert(info);
		qq.focus();
		return false;
	}else{
		return true;
	}
}

//是否符合固定电话格式
function isPhone(Tel,info) {
	//var	re = /^[0-9\*\-( )]*$/;
	//if (js_value.match (re)) {
	//	return	true;
	//}
	//return	false;
	if (Tel.value.length==0){
		return true;
	}
	var reg = /^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;

	if (!reg.test(Tel.value)) {
		alert(info);
		Tel.focus();
		return false;
	}else{
		return true;
	}
}

//是否符合移动电话格式
function isMobilePhone(mobile,info) {
	//var	re = /^[0-9\s]*$/;
	//if (js_value.match (re)) {
	//	return	true;
	//}
	//return	false;
	var reg = /^0?1[3|4|5|8][0-9]\d{8}$/;
	if (!reg.test(mobile.value)) {
		alert(info);
		mobile.focus();
		return false;
	}else{
		return true;
	}
}

//是否符合url格式
function isUrl(url,info) {
	//var	re = /^[0-9\s]*$/;
	//if (js_value.match (re)) {
	//	return	true;
	//}
	//return	false;
	var reg =/^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/;
	if (!reg.test(url.value)) {
		alert(info);
		url.focus();
		return false;
	}else{
		return true;
	}
}

//验证符合传真格式
function isFax(fax,info) {
	//var	re = /^[0-9\*\-( )]*$/;
	//if (js_value.match (re)) {
	//	return	true;
	//}
	//return	false;
	if (fax.value.length==0){
		return true;
	}
	var reg = /^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;

	if (!reg.test(fax.value)) {
		alert(info);
		fax.focus();
		return false;
	}else{
		return true;
	}
}


//是否符合IPV4地址格式
function isIpadr(js_value) {
	var	re1 = /10.1[0-9][0-9].1[0-9][0-9]$/;
	var	re2 = /10.1[0-9][0-9].2[0-5][0-5]$/;
	var	re3 = /10.2[0-5][0-5].1[0-9][0-9]$/;
	var	re4 = /10.2[0-5][0-5].2[0-5][0-5]$/;
	if (js_value.charAt(3)=='1'&&js_value.charAt(7)=='1'&&js_value.match(re1)) {
		return	true;
	}
	else if (js_value.charAt(3)=='1'&&js_value.charAt(7)=='2'&&js_value.match(re2)){
		return	true;
	}
	else if (js_value.charAt(3)=='2'&&js_value.charAt(7)=='1'&&js_value.match(re3)){
		return	true;
	}
	else if (js_value.charAt(3)=='2'&&js_value.charAt(7)=='2'&&js_value.match(re4)){
		return	true;
	}
	else {
		return	false;
	}
}

//是否符合URL格式
function isURL(js_value) {
	var pos, posdot ;
	var	re ;
	re = /^\s*$/ ;
	if ( js_value.match(re) ){
		return true ;
	}
	pos = js_value.indexOf('://',0) ;
	if ( pos<0 ) return false ;
	posdot = js_value.lastIndexOf('.') ;
	if ( posdot<pos ) {
		return false ;
	}
	if ( posdot == js_value.length-1 ) {
		return false ;
	}
	return true ;
}

//是否符合数字格式
function isNumber(js_value) {
	var	re ;
	re = /^\s*$/ ;
	if ( js_value.match(re) ) {
		return true ;
	}
	if ( isNaN(js_value) || js_value.indexOf('.',0) >= 0 ) {
		return false ;
	}
	return true ;
}

//是否符合Double格式
function isDouble(js_value) {
	var re;
	re = /^\s*$/;
	if( js_value.match(re)){
		return true;
	}
	if(isNaN(js_value)) {
		return false;
	}
	return true;
}

//比较两个日期的先后
function date_compare(date1, date2) {
	var  date1_time = date1.getTime();
	var  date2_time = date2.getTime();
	if (date1_time > date2_time) {
		return 1;
	}
	if (date1_time == date2_time) {
		return 0;
	}
	return -1;
}

//得到HTML组件的值
function getValue(js_obj) {
	if (null == js_obj) {
		return null;
	}
	var	re, i;
	re = /^\s*$/ ;
	if (js_obj.length){
		if (js_obj[0].type == "checkbox"){
			for (i=0; i<js_obj.length; i++) {
				if (js_obj[i].checked == true) {
					return js_obj[i].value;
				}
			}
			return null;
		}
		else if (js_obj[0].type == "radio"){
			for (i=0; i<js_obj.length; i++) {
				if (js_obj[i].checked == true) {
					return js_obj[i].value;
				}
			}
			return	null;
		}
	}
	else{
		if (js_obj.type == "select-multiple"){
			if (js_obj.selectedIndex < 0) {
				return null;
			}
			else {
				return js_obj[js_obj.selectedIndex].value;
			}
		}
		else if (js_obj.type == "select-one"){
			if (js_obj.selectedIndex < 0) {
				return null;
			}
			else {
				return js_obj[js_obj.selectedIndex].value;
			}
		}
		else if (js_obj.type == "text"){
		}
		else if (js_obj.type == "checkbox") {
			if (js_obj.checked == false) {
				return	null;
			}
		}
		else if (js_obj.type == "radio") {
			if (js_obj.checked == false) {
				return	null;
			}
		}
		return	js_obj.value;
	}
	return	js_obj.value;
}

//将特殊符号转换为HTML格式
function htmlEncode(str) {
	if(str!=''){
		var strRet = '';
		var j = str.length;
		for(i = 0; i < j; i++){
			var s = str.charAt(i);
			var c = str.charCodeAt(i);
			switch(c){
				case 60:strRet += "&lt;";break;
				case 62:strRet += "&gt;";break;
				case 38:strRet += "&amp;";break;
				case 39:strRet += "&#39;";break;
				case 34:strRet += "&quot;";break;
				case 169:strRet += "&copy;";break;
				case 174:strRet += "&reg;";break;
				case 165:strRet += "&yen;";break;
				case 8364:strRet += "&euro;";break;
				case 8482:strRet += "&#153;";break;
				case 13:
					if(i < j - 1 && str.charCodeAt(i + 1) == 10){
						strRet += "<br>";
						i++;
					}
					break;
				case 32:
					if(i < j - 1 && str.charCodeAt(i + 1) == ' '){
						strRet += " &nbsp;";
						i++;
					}
					break;
				default:
					strRet += s;
					break;
			}
		}
		return strRet;
	}
	else{
		return '';
	}
}

//得到长度
function checkLength(js_value) {
	var len1=0;
	if(js_value.match(/[\x00-\xff]/g)){
		len=js_value.length*2-js_value.match(/[\x00-\xff]/g).length;
		return len;
	}
	else{
		len=js_value.length*2;
		return len;
	}
}

//检查图片类型是否是GIF、JPG、BMP、PNG格式的
function checkTypeOfImage(img)
{
	alert(img);
	if((document.all[img].value.indexOf(".gif") == -1) && (document.all[img].value.indexOf(".jpg") == -1) && (document.all[img].value.indexOf(".bmp") == -1 && (document.all[img].value.indexOf(".png") == -1))) {
		return false;
	}
}

//Text表单限制输入
//用法:
//     1、小写英文：<input onkeypress = "return regInput(this,/^[a-z]*$/,String.fromCharCode(event.keyCode))"
//				 onpaste = "return regInput(this,/^[a-z]*$/,window.clipboardData.getData('Text'))"
//				 ondrop = "return regInput(this,/^[a-z]*$/,event.dataTransfer.getData('Text'))"
//				 style = "ime-mode:Disabled">
//	   2、大写英文：<input onkeypress = "return regInput(this,/^[A-Z]*$/,String.fromCharCode(event.keyCode))"
//				  onpaste = "return regInput(this,/^[A-Z]*$/,window.clipboardData.getData('Text'))"
//				  ondrop = "return regInput(this,/^[A-Z]*$/,event.dataTransfer.getData('Text'))"
//				  style="ime-mode:Disabled">
//	   3、任意数字：<input onkeypress = "return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))"
//				  onpaste = "return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))"
//				  ondrop = "return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"
//				  style="ime-mode:Disabled">
//	   4、限2位小数：<input onkeypress = "return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))"
//				   onpaste = "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))"
//				   ondrop = "return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))"
//				   style="ime-mode:Disabled">
//	   5、日期：<input onkeypress	= "return regInput(this,/^\d{1,4}([-\/](\d{1,2}([-\/](\d{1,2})?)?)?)?$/,String.fromCharCode(event.keyCode))"
//			   onpaste = "return regInput(this,/^\d{1,4}([-\/](\d{1,2}([-\/](\d{1,2})?)?)?)?$/,window.clipboardData.getData('Text'))"
//		       ondrop = "return regInput(this,/^\d{1,4}([-\/](\d{1,2}([-\/](\d{1,2})?)?)?)?$/,event.dataTransfer.getData('Text'))"
//		       style="ime-mode:Disabled">
//     6、任意中文：<input	onkeypress = "return regInput(this,/^$/,String.fromCharCode(event.keyCode))"
//				  onpaste = "return regInput(this,/^[\u4E00-\u9FA5]*$/,window.clipboardData.getData('Text'))"
//				  ondrop = "return regInput(this,/^[\u4E00-\u9FA5]*$/,event.dataTransfer.getData('Text'))">
//     7、部分英文：<input	onkeypress = "return regInput(this,/^[a-e]*$/,String.fromCharCode(event.keyCode))"
//				  onpaste = "return regInput(this,/^[a-e]*$/,window.clipboardData.getData('Text'))"
//				  ondrop = "return regInput(this,/^[a-e]*$/,event.dataTransfer.getData('Text'))"
//				  style="ime-mode:Disabled">
function regInput(obj, reg, inputString) {
	var docSel	= document.selection.createRange();
	if (docSel.parentElement().tagName != "INPUT")	{
		return false;
	}
	oSel = docSel.duplicate();
	oSel.text = "";
	var srcRange = obj.createTextRange();
	oSel.setEndPoint("StartToStart", srcRange);
	var str = oSel.text + inputStr + srcRange.text.substr(oSel.text.length);
	return reg.test(str)
}
//是不是日期
function CheckDate(str){
	//在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号
	var Expression=/^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$/;
	var objExp=new RegExp(Expression);
	if(objExp.test(str)==true){
		return true;
	}else{
		return false;
	}

}
function isCardID(str){
	var reg=/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
	if(reg.test(str)==true)
	{
		return true;
	}else{
		return false;
	}
}

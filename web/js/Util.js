var Util = {};
Util.formParams = function(formId) {
    var nodes = $("#" + formId).find("input[type='text'],input[type='password'],input[type='hidden'],input[type='radio']:checked," +
        "input[type='checkbox']:checked,textarea,select");
    var params = {};
    for (var i = 0; i < nodes.length; i++) {
        var e = $(nodes[i]);
        var name = e.attr("name");
        if(name == undefined) continue;
        if (params[name] == undefined) {
            params[name] = e.attr("value");
        } else {
            params[name] += "|" + e.attr("value");
        }
    }
    return params;
};
Util.editors = [];
//$(document).ready(function(){
//    //div的id设置notice_02 取02分类下的公告
//    $("div[id^='notice_']").each(function(){
//        var id = $(this).attr("id"),
//            no = id.substring("notice_".length);
//        $.ajax({
//            url:'/notice/pageList.do',
//            type:'post',
//            data:{'size':5,'cateNo':no},
//            success:function(_data){
//                var data = $.parseJSON(_data);
//                var newNode = "";
//                for(var i = 0; i<data.length; i ++){
//                    newNode += "<li><a target='_blank' title='" + data[i].title
//                        + "' href='/notice/show.do?id=" + data[i].id + "'>" + data[i].title +"</a> </li>";
//                }
//                $("#" + id).find("ul").append(newNode);
//            }
//        });
//    });
//
//    $.ajax({
//        url:'/notice/pageList.do',
//        type:'post',
//        data:{'size':8,'cateNo':'06'},
//        success:function(_data){
//            var data = $.parseJSON(_data);
//            var newNode = "";
//            for(var i = 0; i<data.length; i ++){
//                newNode += "<a target='_blank' title='" + data[i].title
//                    + "' href='/notice/show.do?id=" + data[i].id + "'>" + data[i].title +"</a> ";
//                if(i != data.length-1){
//                    newNode += "|";
//                }
//            }
//            $("#copyLink").find("span").append(newNode);
//
//        }
//    });
//});
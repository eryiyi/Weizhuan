<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="um" uri="/unimanager-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>

<div class="row">
  <div id="breadcrumb" class="col-xs-12">
    <a href="#" class="show-sidebar">
      <i class="fa fa-bars"></i>
    </a>
    <ol class="breadcrumb pull-left">
      <li><a href="index.html">主页</a></li>
      <li><a href="#">萌宝管理</a></li>
      <li><a href="#">添加萌宝</a></li>
    </ol>
    <div id="social" class="pull-right">
      <a href="#"><i class="fa fa-google-plus"></i></a>
      <a href="#"><i class="fa fa-facebook"></i></a>
      <a href="#"><i class="fa fa-twitter"></i></a>
      <a href="#"><i class="fa fa-linkedin"></i></a>
      <a href="#"><i class="fa fa-youtube"></i></a>
    </div>
  </div>
</div>

<div class="row">
  <div class="col-xs-12 col-sm-12">
    <div class="box ui-draggable ui-droppable">
      <div class="box-header">
        <div class="box-name ui-draggable-handle">
          <i class="fa fa-table"></i>
          <span>添加萌宝</span>
        </div>
        <div class="box-icons">
          <a class="collapse-link">
            <i class="fa fa-chevron-up"></i>
          </a>
          <a class="expand-link">
            <i class="fa fa-expand"></i>
          </a>
          <a class="close-link">
            <i class="fa fa-times"></i>
          </a>
        </div>
        <div class="no-move"></div>
      </div>
      <div class="box-content">
        <div class="col-sm-4 col-xs-3">
          <label class="col-sm-3 control-label">ID</label>
          <div class="col-sm-6">
            <input class="form-control" id="phone_number" name="phone_number" value="" type="text" placeholder="萌宝ID">
          </div>
        </div>
        <div class="col-xs-3 col-sm-2">
          <i class="fa fa-search"></i>
          <a href="javascript:void (0);" onclick="searchBaby()">搜索</a>
        </div>

        <table class="table">
          <thead>
          <tr>
            <th>萌宝ID</th>
            <th>萌宝名称</th>
            <th>电话</th>
            <th>得票数</th>
            <th>取消票数</th>
            <th>人气数</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${list}" var="e" varStatus="st">
            <tr>
              <td>${e.id}</td>
              <td>${e.nickname}</td>
              <td>${e.phone}</td>
              <td>${e.num}</td>
              <td>${e.dnum}</td>
              <td>${e.sharenum}</td>
              <td>
                <a class="btn btn-default btn-sm" href="javascript:void (0)" onclick="addRole('${e.id}','${e.nickname}', '${e.num}' , '${e.dnum}' , '${e.sharenum}'  )" role="button">添加</a>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">

  function searchBaby(){
    var phone = $("#phone_number").val();
    if (phone !='' ) {
      window.location.href="#module=role/add&name="+phone;
    } else {
      alert("请输入ID");
    }
  }


  function addRole(_id,_nickname,_num,_dnum,_sharenum){
    if(confirm("确定要添加该萌宝么？")){
      $.ajax({
        cache: true,
        type: "POST",
        url:"/children/save.do",
        data:{"cid":_id, "name":_nickname, "num":_num, "dnum":_dnum, "sharenum":_sharenum },
        async: false,
        success:function(_data){
          var data = $.parseJSON(_data);
          if(data.success){
            alert("添加成功");
//            window.location.href = "#module=children/list";
          }else{
            var _case = {1:"添加失败"};
            alert(_case[data.code])
          }
        }
      });
    }
  }
</script>



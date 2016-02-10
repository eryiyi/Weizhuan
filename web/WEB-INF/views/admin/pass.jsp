<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<div class="row">
  <div id="breadcrumb" class="col-xs-12">
    <a href="#" class="show-sidebar">
      <i class="fa fa-bars"></i>
    </a>
    <ol class="breadcrumb pull-left">
      <li><a href="/index.do">主页</a></li>
      <li><a href="#">系统管理</a></li>
      <li><a href="#">修改密码</a></li>
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
    <div class="box">
      <div class="box-header">
        <div class="box-name">
          <i class="fa fa-search"></i>
          <span>修改密码</span>
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
      <div class="box-content" >
        <h4 class="page-header">修改密码</h4>
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label class="col-sm-2 control-label">原密码</label>
            <div class="col-sm-4">
              <input type="password" id="ePass" class="form-control" placeholder="请输入原密码" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">新密码</label>
            <div class="col-sm-4">
              <input type="password" id="pass" class="form-control" placeholder="请输入新密码" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">确认新密码</label>
            <div class="col-sm-4">
              <input type="password" id="pass_sure" class="form-control" placeholder="请再次输入新密码" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>


          <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
              <button type="button" class="btn btn-primary" onclick="updatePass()">提交</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%--<div class="col-xs-4 col-sm-4">--%>
<script type="text/javascript">
  function updatePass(){
    var ePass = $("#ePass").val();
    if(ePass == ''){
      alert("请输入原密码");
      return;
    }
    var pass = $("#pass").val();
    if(pass == ''){
      alert("请输入新密码");
      return;
    }
    if(pass.length<6){
      alert("密码长度至少6位");
      return;
    }
    var passSure = $("#pass_sure").val();
    if(passSure == ''){
      alert("请再次输入新密码");
      return;
    }
    if(pass != passSure){
      alert("两次新密码输入不一致，请重新输入");
      $("#pass_sure").val("");
      return;
    }
    ePass = hex_md5(ePass);
    pass = hex_md5(pass);

    $.ajax({
      cache: true,
      type: "POST",
      url:"/changePass.do",
      data:{"ePass":ePass,"pass":pass},
      async: false,
      success: function(_data) {
        var data = $.parseJSON(_data);
        if(data.success){
          alert("密码成功，重新登入");
          window.location.href = "/";
        }else{
          var _case = {1:"修改密码失败",2:"请先登录",3:"原密码不对,请重新输入"};
          alert(_case[data.code]);
          $("#ePass").val("");
        }
      }
    });
  }
</script>

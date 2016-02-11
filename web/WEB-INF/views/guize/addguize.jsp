<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<div class="row">
  <div id="breadcrumb" class="col-xs-12">
    <a href="#" class="show-sidebar">
      <i class="fa fa-bars"></i>
    </a>
    <ol class="breadcrumb pull-left">
      <li><a href="index.html">主页</a></li>
      <li><a href="#">规则设置</a></li>
      <li><a href="#">规则设置</a></li>
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
          <span>规则设置</span>
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
        <h4 class="page-header">规则内容</h4>
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label class="col-sm-2 control-label">时间</label>
            <div class="col-sm-4">
              <input type="text" id="guize_time" class="form-control" placeholder="执行时间" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">文章数量</label>
            <div class="col-sm-4">
              <input type="text" id="guize_number" class="form-control" placeholder="执行文章数量" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>

          <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
              <button type="button" class="btn btn-primary" onclick="saveP()">执行</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
  function saveP(){
    var guize_time = $("#guize_time").val();
    var guize_number = $("#guize_number").val();

    if(guize_time == ''){
      alert("请输入正确的--执行时间");
      return;
    }
    if(guize_number == ''){
      alert("请输入正确的--文章数量");
      return;
    }

    $.ajax({
      cache: true,
      type: "POST",
      url:"/guize/save.do",
      data:{"guize_time":guize_time, "guize_number":guize_number},
      async: false,
      success: function(_data) {
        var data = $.parseJSON(_data);
        if(data.success){
          alert("执行成功");
          window.location.href = "#module=piaoadd/subdo";
        }else{
          alert("执行失败，请检查")
        }
      }
    });
  }
</script>



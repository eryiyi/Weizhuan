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
      <li><a href="#">自动加票</a></li>
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
            <label class="col-sm-2 control-label">加票最低值</label>
            <div class="col-sm-4">
              <input type="text" id="add_one" class="form-control" placeholder="加票数最低值" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">加票最高值</label>
            <div class="col-sm-4">
              <input type="text" id="add_two" class="form-control" placeholder="加票数最高值" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">取消最低值</label>
            <div class="col-sm-4">
              <input type="text" id="del_one" class="form-control" placeholder="取消数最低值" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">取消最高值</label>
            <div class="col-sm-4">
              <input type="text" id="del_two" class="form-control" placeholder="取消数最高值" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">人气最低值</label>
            <div class="col-sm-4">
              <input type="text" id="level_one" class="form-control" placeholder="人气最低值" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">人气最高值</label>
            <div class="col-sm-4">
              <input type="text" id="level_two" class="form-control" placeholder="人气最高值" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">间隔时间</label>
            <div class="col-sm-4">
              <input type="text" id="date_time" class="form-control" placeholder="间隔时间" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">执行次数</label>
            <div class="col-sm-4">
              <input type="text" id="num" class="form-control" placeholder="执行次数" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
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
    var add_one = $("#add_one").val();
    var add_two = $("#add_two").val();
    var del_one = $("#del_one").val();
    var del_two = $("#del_two").val();
    var level_one = $("#level_one").val();
    var level_two = $("#level_two").val();
    var date_time = $("#date_time").val();
    var num = $("#num").val();

    if(!/^\d+$/.test(add_one)){
      alert("请输入正确的--加票最低值");
      return;
    }
    if(!/^\d+$/.test(add_two)){
      alert("请输入正确的--加票最高值");
      return;
    }
    if(!/^\d+$/.test(del_one)){
      alert("请输入正确的--取消最低值");
      return;
    }
    if(!/^\d+$/.test(del_two)){
      alert("请输入正确的--取消最高值");
      return;
    }
    if(!/^\d+$/.test(level_one)){
      alert("请输入正确的--人气最低值");
      return;
    }
    if(!/^\d+$/.test(level_two)){
      alert("请输入正确的--人气最低值");
      return;
    }

    if(!/^\d+$/.test(date_time)){
      alert("请输入正确的--间隔时间");
      return;
    }
    if(!/^\d+$/.test(num)){
      alert("请输入正确的--执行次数");
      return;
    }

    if(parseInt(add_one) > parseInt(add_two)){
      alert("加票 最低数不能大于最高数");
      return;
    }
    if(parseInt(del_one) > parseInt(del_two)){
      alert("取消 最低数不能大于最高数");
      return;
    }

    if(parseInt(level_one) > parseInt(level_two)){
      alert("人气 最低数不能大于最高数");
      return;
    }

    if(parseInt(del_two) > parseInt(add_one)){
      alert("输入不正确，取消最大值不能高于加票最小值");
      return;
    }

    $.ajax({
      cache: true,
      type: "POST",
      url:"/piaoadd/save.do",
      data:{"addone":add_one, "addtwo":add_two,"delone":del_one, "deltwo":del_two,"datetime":date_time,"addshareone":level_one,"addsharetwo":level_two,"handnum":num},
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



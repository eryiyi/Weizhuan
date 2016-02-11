<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<div class="row">
  <div id="breadcrumb" class="col-xs-12">
    <a href="#" class="show-sidebar">
      <i class="fa fa-bars"></i>
    </a>
    <ol class="breadcrumb pull-left">
      <li><a href="index.html">主页</a></li>
      <li><a href="#">文章管理</a></li>
      <li><a href="#">文章列表</a></li>
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
          <span>文章列表</span>
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
        <%--<p>For basic styling add the base class <code>.table</code> to any <code>&lt;table&gt;</code>.</p>--%>
        <table class="table">
          <thead>
          <tr>
            <th>文章ID</th>
            <th>标题</th>
            <%--<th>时间</th>--%>
            <th>浏览量</th>
            <th>状态</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${list}" var="e" varStatus="st">
            <tr>
              <td>${e.content_id}</td>
              <td>${e.title}</td>
              <%--<td>${e.time}</td>--%>
              <td>${e.views}</td>
              <td>${e.status}</td>

            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
  function deleteRole(_id){
    if(confirm("确定要删除该萌宝么？")){
      $.ajax({
        url:"/children/delete.do",
        data:{"cid":_id},
        type:"POST",
        success:function(_data){
          var data = $.parseJSON(_data);
          if(data.success){
            alert("删除成功");
            window.location.href = "#module=children/list";
          }else{
            var _case = {1:"删除失败"};
            alert(_case[data.code])
          }
        }
      });
    }
  }
</script>



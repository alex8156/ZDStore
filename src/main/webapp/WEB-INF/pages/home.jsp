<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Bootstrap 实例 - 基本表单</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/resources/jquery/jquery-3.3.1.js"></script>
    <script src="/resources/jquery/jquery.form.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

    <form class="form-horizontal" role="form" id="upload" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="appname" class="col-sm-2 control-label">应用名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="appname" placeholder="请输入应用名称">
            </div>
        </div>
        <div class="form-group">
            <label for="packageName" class="col-sm-2 control-label">应用包名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="packageName" placeholder="请输入应用包名">
            </div>
        </div>
        <div class="form-group">
            <label for="packageName" class="col-sm-2 control-label">Icon</label>
            <input type="file" id="inputIcon" name="file" >
           <img id="icon" src="/resources/icon.png" width="100" height="100" alt="哈哈">
        <div class="form-group">
            <label  class="col-sm-2 control-label">Icon</label>
            <input type="file" id="packageFile">
        </div>
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">确定</button>
            </div>
        </div>
</form>
<script type="text/javascript">
    $(document).ready(function () {
       $("#inputIcon").change(function () {
          var imagePath = $("#inputIcon").val();
          if(imagePath =="") {
              alert("请上传应用图标")
              return false;
          }
          var  strExtension = imagePath.substr(imagePath.lastIndexOf('.')+1);
           if (strExtension != 'jpg' && strExtension != 'gif'
               && strExtension != 'png' && strExtension != 'bmp') {
               alert("please upload file that is a image");
               return false;
           }
            var formData = new FormData()
           formData.append("file",$(this)[0].files[0])
           // $.ajax('/uploadIcon',{
           //      type:'post',
           //     success:function (path) {
           //          alert("上传成功，路径为"+path)
           //         console.log("上传成功,路径为%s",path)
           //         // $("#icon").attr("src",path)
           //     },
           //     error:function (error) {
           //         console.log("上传出错："+error);
           //     },
           //     data:formData,
           //     processData:false,
           //     contentType: 'multipart/form-data'
           // });
           // $(this).ajaxSend(function () {
           //     console.log("上传中：");
           // });
           var options = {
               url:'/uploadIcon',
               success:function (path) {
                   console.log("上传成功,路径为%s",path)
                   $("#icon").attr("src",path)
               },
               error:function (error) {
                   console.log("上传出错："+error);
               }
           };
            $("#upload").ajaxSubmit(options)
       });
    });

</script>



</body>
</html>
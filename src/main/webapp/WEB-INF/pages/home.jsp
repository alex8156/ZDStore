<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Bootstrap 实例 - 基本表单</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/resources/jquery/jquery-3.3.1.js"></script>
    <script src="/resources/jquery/jquery.form.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
<div class="row pb-2" >
    <label for="appName" class="col-sm-2 control-label">应用名称</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="appName" placeholder="请输入应用名称" form="uploadAll" required name="appName">
    </div>
</div>

<div class="row mb-3">
    <label for="packageName" class="col-sm-2 control-label">应用包名</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="packageName" placeholder="请输入应用包名" form="uploadAll" required name="packageName">
    </div>
</div>
<form class="row mb-3" id="upload" method="post" enctype="multipart/form-data">
    <div class="form-group">
         <label for="inputIcon" class="col-sm-2" class="control-label">应用图标</label>
        <div class="col-sm-4">
            <input type="file" id="inputIcon" name="file">
        </div>
        <div class="col-sm-6">
            <img id="icon" src="/resources/icon.png" width="100" height="100" alt="哈哈">
        </div>
    </div>
</form>
<form class="row my-3" id="uploadFile" method="post" enctype="multipart/form-data" action="/upload/package">
    <div class="form-group">
        <div class="col-sm-2 ">
            <label class="control-label">包文件</label>
        </div>
        <div class="col-sm-4 ">
            <input type="file"  name="file">
        </div>

        <div class="col-sm-6">
            <button type="submit" class="btn btn-info">上传</button>
        </div>
    </div>
</form>
    <form method="post" class="row" id="uploadAll" action="/upload/packageInfo">
        <input type="hidden"  name="appFile" id="appFile">
        <input type="hidden" name="appIcon" id="appIcon">
        <button type="submit" class="btn col-sm-12">确定</button>
    </form>

</div>

<script type="text/javascript">
    $(document).ready(function () {
        $("#inputIcon").change(function () {
            var imagePath = $("#inputIcon").val();
            if (imagePath == "") {
                alert("请上传应用图标")
                return false;
            }
            var strExtension = imagePath.substr(imagePath.lastIndexOf('.') + 1);
            if (strExtension != 'jpg' && strExtension != 'gif'
                && strExtension != 'png' && strExtension != 'bmp') {
                alert("please upload file that is a image");
                return false;
            }
            //  var formData = new FormData()
            // formData.append("file",$(this)[0].files[0])
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
                url: '/upload/icon',
                success: function (path) {
                    console.log("上传成功,路径为%s", path)
                    $("#icon").attr("src", path)
                    $('#appIcon').val(path)
                    console.log($('#appIcon').val())
                },
                error: function (error) {

                }
            };
            $("#upload").ajaxSubmit(options)
        });

        $('#uploadFile').ajaxForm({
            success:function (path) {
                console.log("上传成功,路径为%s",path)
                $('#appFile').val(path)

            },
            error:function (error) {
                console.log("上传出错：" + error);
            }
        });
        $('#uploadAll').ajaxForm({
            success:function (data) {
                alert(data)
            },
            error:function (error) {
                console.log("提交出错：" + error);
            }
        });
    });

</script>


</body>
</html>
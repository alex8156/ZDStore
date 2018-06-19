<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bootstrap 实例 - 基本表单</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

    <form class="form-horizontal" role="form">
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
            <input type="file" id="inputIcon">
           <img  src="/resources/icon.png" width="100" height="100">
        <div class="form-group">
            <label  class="col-sm-2 control-label">Icon</label>
            <input type="file" id="packageFile">
        </div>
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">确定</button>
            </div>
        </div>
</form>




</body>
</html>
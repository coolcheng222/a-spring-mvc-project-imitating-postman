<%--
  Created by IntelliJ IDEA.
  User: carrzhou
  Date: 2021/1/25
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <base href=" <%=
    request.getScheme()
    %>://<%=
    request.getServerName()
    %>:<%=request.getServerPort() %><%=request.getContextPath() %>/">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>发post</title>
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/js/jquery-1.10.1.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="static/js/render.js"></script>
    <script src="static/js/submit.js"></script>
    <link rel="stylesheet" href="static/css/index.css">
</head>
<body>
<div id="mainarea">

    <form id="post-info" class="form-horizontal">
        <div class="form-group row clearfix" id="row1">

            <select id="method" class="col-sm-1 form-control" name="method">
                <option value="POST" selected="selected">POST</option>
                <option value="GET">GET</option>
                <option value="DELETE">DELETE</option>
                <option value="PUT">PUT</option>
            </select>
            <label class="col-sm-1 control-label" style="text-align: center" id="urllabel">Url</label>
            <div class=" col-sm-9">
                <input type="text" class="form-control" name="url" placeholder="URL">
            </div>
        </div>
        <br/>
        <div id="kvarea">
            <ul class="nav nav-tabs">
                <li role="presentation" id="parameters" class="active nav1"><a href="#">Parameters</a></li>
                <li role="presentation" id="cookies" class="nav1"><a href="#">COOKIE</a></li>
                <li role="presentation" id="headers" class="nav1"><a href="#">HEADERS</a></li>
                <li role="presentation" id="json" class="nav1"><a href="#">JSON</a></li>
            </ul>
            <div id="parameters_div" class="kvs" display="true">
                <button type="button" class="btn btn-default btn-lg addParam">
                    +
                </button><br>
                <span class="subtitle">Parameters: only valid when method is post or put</span>
                <table class="table table-striped table-hover inputs table-bordered">

                </table>
            </div>
            <div id="cookies_div" class="kvs">
                <button type="button" class="btn btn-default btn-lg addParam">
                     +
                </button><br>
                <span class="subtitle">Cookies</span>
                <table class="table table-striped table-hover inputs table-bordered">

                </table>
            </div>
            <div id="headers_div" class="kvs">
                <button type="button" class="btn btn-default btn-lg addParam">
                    +
                </button><br>
                <span class="subtitle">Headers:</span>
                <table class="table table-striped table-hover inputs table-bordered">

                </table>
            </div>
        </div>


        <div id="json_div" class="kvs">
            <label class="checkbox-inline">
                <input type="checkbox" name="isjson" value="true"> using json(only for post and put,and the parameters will be invalid)
            </label>
            <textarea class="form-control" rows="3" name="json"></textarea>
        </div>

        <input class="btn btn-primary btn-sm" type="submit" id="submit">
    </form>

    <div id="responsearea">
        <ul class="nav nav-tabs">
            <li role="presentation" id="raw" class="active nav1"><a href="#">RAW</a></li>
            <li role="presentation" id="formatted" class="nav1"><a href="#">FORMATTED</a></li>
            <li role="presentation" id="rheaders" class="nav1"><a href="#">HEADERS</a></li>
            <li role="presentation" id="status" class="nav1"><a href="#">STATUS</a></li>
        </ul>
        <div id="raw_div" display="true" class="response">

        </div>
        <div id="formatted_div" class="response">
        </div>
        <div id="rheaders_div" class="response">
        </div>
        <div id="status_div" class="response">
        </div>
    </div>
</div>
</body>
</html>

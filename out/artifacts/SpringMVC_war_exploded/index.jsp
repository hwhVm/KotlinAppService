<%--
  Created by IntelliJ IDEA.
  User: beini
  Date: 2017/2/22
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
    <meta http-equiv="ex" content="60">
    <%--<style type="text/css">--%>
    <%--#main {--%>
    <%--margin: 0 auto;--%>
    <%--width: 400px;--%>
    <%--}--%>

    <%--#container {--%>
    <%--width: 400px;--%>
    <%--height: 300px;--%>
    <%--border: 1px dashed #666;--%>
    <%--text-align: center;--%>
    <%--line-height: 300px;--%>
    <%--}--%>
    <%--</style>--%>
    <script type="application/javascript" src="<%=request.getContextPath() %>/js/jquery-3.1.1.min.js">
    </script>


    <script type="text/javascript">
        $(function () {
            $('#myBut').click(function () {
                $.get("<%=request.getContextPath() %>/ajaxCommit",
                    {
                        age: 18,
                        name: "beini"
                    },
                    function (data, textStatus) {
                        alert(textStatus)
                        var container = $('#container');
                        var resultData = $.parseJSON(data);
                        var age = resultData.age;
                        var name = resultData.name;
                        container.html("name:" + name + "," + "age:" + age);

                    });
            });
        });
        XMLHttpRequest
        function showAlertTo() {
            alert("test");
        }

        $(document).ready(function () {

            $("#b01").click(function () {

                htmlobj = $.ajax({url: "<%=request.getContextPath() %>/changeContent", async: false});

                $("#myDiv").html(htmlobj.responseText);

            });

        });
        //添加用户
        function addUser() {
            var form = document.forms[0];
            form.action = "${pageContext.request.contextPath}/addUser";
            form.method = "post";
            form.submit();
        }

        function chageCode() {
            $('#codeImage').attr('src', 'getAuthCode?abc=' + Math.random());//链接后添加Math.random，确保每次产生新的验证码，避免缓存问题。
        }

        function subm() {
            var form = document.forms[0];
            form.action = "${pageContext.request.contextPath}/isTrueCode";
            form.method = "post";
            form.submit();
        }
    </script>
</head>
<body>

<p><a href="longtimetask">spring MVC asynchronous</a></p>

<div id="main">
    <button id="myBut">Ajax获取数据</button>
    <button id="myAlert" onclick="showAlertTo();">showAlert</button>
    <div id="container"></div>
</div>

<br/>
<div id="myDiv"><h2>Let AJAX change this text</h2></div>
<button id="b01" type="button">Change Content</button>

<p>表单提交</p>
<form method="post">
    <input type="text" name="userName"> <br/> <input
        type="password" name="password"> <br/> <input type="button"
                                                      value="提交" onclick="addUser()">
</form>

<p>上传图片</p>
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="Submit"/>
</form>
<p>
<p>
<form id="form1" action="login" method="post">
    账号:<input type="text" name="name"/></br>
    密码:<input type="password" name="password"/></br>
    <input type="submit" value="submit"/>
</form>
</p>
<p/>
<a href="queryAllLeader">xml文件配置SpringMVC myBatis</a>

<p>
    <a href="testSimpleMappingException">SpringMVC中自带的简单异常处理器 SimpleMappingExceptionResolver</a>
</p>

<p>
    <a href="http://localhost:8080/js/jquery-3.1.1.min.js">
        静态资源的访问
    </a>
</p>


<form action="toLogin.do" id="loginUser" method="post">
    <div class="form-group">
        姓名：<input id="name" name="name" type="text"/>
    </div>
    <div class="form-group">
        密码：<input id="password" name="password" type="password"/>
    </div>
    <div class="form-group">
        验证码：<input id="authCode" name="authCode" type="text"/>
        <!--这里img标签的src属性的值为后台实现图片验证码方法的请求地址-->
        <label><img type="image" src="getAuthCode" id="codeImage" onclick="chageCode()" title="图片看不清？点击重新得到验证码"
                    style="cursor:pointer;"/></label>
        <label><a onclick="chageCode()">换一张</a></label>
    </div>
    <input type="button" class="btn btn-default" onclick="subm()" value="登录"/>

</form>
<div>

    <a href="<%=request.getContextPath() %>//gotoWebSocket">websocket page</a>

</div>
<%--测试权限框架shiro--%>
<div>


</div>
</body>
</html>

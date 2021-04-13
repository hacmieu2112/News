<%-- 
    Document   : Register
    Created on : Nov 15, 2020, 6:20:43 PM
    Author     : Doktoh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.User"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Home</title>
        <link href="View/style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="View/js/cufon-yui.js"></script>
        <script type="text/javascript" src="View/js/arial.js"></script>
        <script type="text/javascript" src="View/js/cuf_run.js"></script>
    </head>
    <body>
        <div class="main">
            <div class="header">
                <div class="header_resize">
                    <div class="logo">
                        <h1><a href="${pageContext.request.contextPath}/home"><span>Tin tức</span> ngoài tầm tay<br />
                                <small>Sẽ vào trong tầm tay</small></a></h1>
                    </div>
                    <div class="clr"></div>
                    <div class="menu">
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/home"><span>Trang chủ</span></a></li>
                            <li><a href="${pageContext.request.contextPath}/login"><span>Đăng nhập</span></a></li>
                        </ul>
                    </div>
                    <div class="clr"></div>
                </div>
            </div>
            <div class="body">
                <div class="body_resize">
                    <form action="${pageContext.request.getContextPath()}/register" method="post">
                        <div class="container">
                            <h2>Register</h2>
                            <hr>
                            <label for="username"><b>Username</b></label>
                            <input type="text" placeholder="Enter Username" name="username" id="username" >

                            <label for="psw"><b>Password</b></label>
                            <input type="password" placeholder="Enter Password" name="pass" id="psw" ><br><br>
                            <label for="psw-repeat"><b>Repeat Password</b></label>
                            <input type="password" placeholder="Re-pass" name="re-pass" id="psw-repeat" ><br><br>
                            <label for="name"><b>Fullname</b></label>
                            <input type="text" placeholder="Name" name="name" id="name" ><br><br>
                            <hr>
                            <button type="submit" class="registerbtn" name="registerbtn">Register</button></a>
                            <%
                                String exist = "";
                                if (request.getAttribute("exist") == null) {
                                    exist = "";
                                } else {
                                    exist = (String) request.getAttribute("exist");
                                }

                            %><%=exist%><br><br>
                            <%
                                String res = "";
                                if (request.getAttribute("res") == null) {
                                    res = "";
                                } else {
                                    res = (String) request.getAttribute("res");
                                }

                            %><%=res%>
                        </div>
                        <table border = "1">
                            <tr>
                                <td>Id</td>
                                <td>Username</td>

                            </tr>
                            <%
                                ArrayList<User> list = (ArrayList<User>) request.getAttribute("list");
                                for (User item : list) {
                                    out.println("<tr>");
                                    out.println("<td>" + item.getId() + "</td>");
                                    out.println("<td>" + item.getUsername() + "</td>");
                                    out.println("</tr>");
                                }
                            %>
                        </table>
                    </form>
                    <div class="clr"></div>
                </div>
            </div>

            <div class="footer">
                <div class="footer_resize">
                    <p class="lf"></p>
                    <div class="clr"></div>
                </div>
                <div class="clr"></div>
            </div>
        </div>
    </body>
</html>

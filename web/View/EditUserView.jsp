<%-- 
    Document   : EditUserView
    Created on : Nov 16, 2020, 4:43:57 AM
    Author     : Doktoh
--%>

<%@page import="Model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                            <li><a href="${pageContext.request.contextPath}/logout"><span>Trang chủ</span></a></li>
                            <li><a href="${pageContext.request.contextPath}/logout"><span>Đăng xuất</span></a></li>
                        </ul>
                    </div>
                    <div class="clr"></div>
                </div>
            </div>
            <div class="body">
                <div class="body_resize">
                    <div class="left">
                        <div class="item">
                            <h2>Sửa User</h2>
                            <form action="edituser" method="get" enctype="multipart/form-data" id="contactform">
                                <ol>
                                    <li>
                                        <label>User</label><br><br>
                                            <%
                                                ArrayList<User> listu = (ArrayList<User>) request.getAttribute("listu");
                                                for (User item : listu) {
                                                    out.println("<a href=\"edituser?id="+item.getId()+"\">ID: " + item.getId()+"<br>UserName: "+ item.getUsername()+"<br>Password: "+ item.getPassword()+"<br>FullName: "+ item.getFullname()+ "</a><hr>");
                                                }
                                            %>                
                                    </li>
                                </ol>
                            </form>
                        </div>
                    </div>
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

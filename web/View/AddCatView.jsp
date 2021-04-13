<%-- 
    Document   : AddCatView
    Created on : Nov 16, 2020, 4:42:32 AM
    Author     : Doktoh
--%>

<%@page import="Model.Category"%>
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
                            <h2>Sửa Category</h2>
                            <form action="addcat" method="get" enctype="multipart/form-data" id="contactform">
                                <ol>
                                    <li>
                                        <label>Danh mục</label><br><br>
                                            <%
                                                ArrayList<Category> listc = (ArrayList<Category>) request.getAttribute("listc");
                                                for (Category item : listc) {
                                                    out.println("<p>" + item.getName() + "</p>");
                                                }
                                            %>
                                    </li>
                                    <li class="buttons">
                                        <input type="text" name="addcate">
                                        <input type="submit" name="Add" value="Add" class="send" >
                                        <div class="clr"></div>
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

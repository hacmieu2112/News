<%-- 
    Document   : home
    Created on : Nov 15, 2020, 4:26:59 PM
    Author     : Doktoh
--%>

<%@page import="Model.Category"%>
<%@page import="Model.New"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
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
                            <li><a href="${pageContext.request.contextPath}/home" class="active"><span>Trang chủ</span></a></li>
                            <li><a href="${pageContext.request.contextPath}/topview" ><span>Top View</span></a></li>
                            <li><a href="${pageContext.request.contextPath}/topnew" ><span>Top New</span></a></li>
                            <li><a href="${pageContext.request.contextPath}/login" ><span>Đăng nhập</span></a></li>
                        </ul>
                    </div>
                    <div class="clr"></div>
                </div>
            </div>
            <div class="body">
                <div class="body_resize">
                    <div class="left">
                        <div class="item">
                            <%
                                ArrayList<New> listn = (ArrayList<New>) request.getAttribute("listn2");
                                for (New item : listn) {
                            %>
                            <h2><a href="detail?postid=<%out.println(item.getId());%>" title=""><%out.println(item.getName());%></a></h2>
                            <img src="<%out.println(item.getImage());%>" width="585" height="156" />
                            <div class="clr"></div>
                            <%
                                    out.println("<p>" + item.getDescription() + "</p>");
                                }
                            %>
                        </div>
                    </div>
                    <div class="right">
                        <h2>Danh mục</h2>
                        <ul>
                            <%
                                ArrayList<Category> listc = (ArrayList<Category>) request.getAttribute("listc2");
                                for (Category item : listc) {%>
                            <li><a href="cat?cateid=<%out.println(item.getId());%>"><%out.println(item.getName());%></a></li>
                                <%
                                    }
                                %>
                        </ul>
                        <form action="search" method="get" enctype="multipart/form-data" id="contactform">
                            <input type="text" name="searchid">
                            <input type="submit" name="search" value="Search">
                        </form>
                    </div>
                    <div class="clr"></div>
                </div>
            </div>

            <div class="footer">
                <div class="footer_resize">
                    <p class="lf"></a></p>
                    <div class="clr"></div>
                </div>
                <div class="clr"></div>
            </div>
        </div>
    </body>
</html>

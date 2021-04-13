<%-- 
    Document   : catview
    Created on : Nov 16, 2020, 4:10:55 AM
    Author     : Doktoh
--%>

<%@page import="Model.Category"%>
<%@page import="Model.New"%>
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
                            <li><a href="${pageContext.request.contextPath}/home" ><span>Trang chủ</span></a></li> 
                                <%
                                    String catename = (String) request.getAttribute("caten");
                                %>
                            <li><a class="active"><span><%=catename%></span></a></li>
                            <li><a href="${pageContext.request.contextPath}/topview?cateid=<%=request.getParameter("cateid")%>" ><span>Top View</span></a></li>
                            <li><a href="${pageContext.request.contextPath}/topnew?cateid=<%=request.getParameter("cateid")%>" ><span>Top New</span></a></li>
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
                                ArrayList<New> listn = (ArrayList<New>) request.getAttribute("listn4");
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
                                ArrayList<Category> listc = (ArrayList<Category>) request.getAttribute("listc4");
                                for (Category item : listc) {%>
                            <li><a href="cat?cateid=<%out.println(item.getId());%>"><%out.println(item.getName());%></a></li>

                            <%
                                }
                            %>
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

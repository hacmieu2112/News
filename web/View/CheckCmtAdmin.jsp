<%-- 
    Document   : CheckCmtAdmin
    Created on : Nov 18, 2020, 4:37:28 AM
    Author     : Doktoh
--%>

<%@page import="Model.New"%>
<%@page import="Model.Comment"%>
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
                            <li><a href="${pageContext.request.contextPath}/adckcmt" class="active"><span>Comment</span></a></li>
                        </ul>
                    </div>
                    <div class="clr"></div>
                </div>
            </div>
            <div class="body">
                <div class="body_resize">
                    <div class="left">
                        <div class="item">
                            <h2>Sửa tin</h2>
                            <form action="adckcmt" method="get" enctype="multipart/form-data" id="contactform">
                                <table>
                                    <tr>
                                        <td>
                                            <label>Tên tin*</label>
                                        </td>
                                        <td>
                                            <select name="name">
                                                <%
                                                    ArrayList listn = (ArrayList) request.getAttribute("listn");
                                                    for (int i = 0; i<listn.size();i++) {
                                                        out.println("<option>" + listn.get(i) + "</option>");
                                                    }
                                                %>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>

                                        </td>
                                        <td>
                                            <input type="submit" name="load" value="Load">
                                        </td>
                                    </tr>
                                </table>
                                
                                    <%
                                        ArrayList<Comment> listcmt;
                                        if (request.getAttribute("listcmt") != null) {
                                            listcmt = (ArrayList<Comment>) request.getAttribute("listcmt");
                                            for (Comment item : listcmt) {
                                                out.println("<table><tr><td>Name: </td><td>" + item.getName() + "</td></tr><tr><td>Comment: </td><td>" + item.getComment() + "</td></tr>");
                                                out.println("<hr>");
                                                out.println("<tr><td></td><td><a href=\"adckcmt?id=" + item.getId() + "&name="+request.getParameter("name")+"&load=Load\">Duyệt</a></td></tr></table>");

                                            }
                                        }

                                    %>
                                    
                                
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

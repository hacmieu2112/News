<%-- 
    Document   : viewdetail
    Created on : Nov 16, 2020, 12:16:14 AM
    Author     : Doktoh
--%>

<%@page import="Model.Comment"%>
<%@page import="Model.New"%>
<%@page import="Model.Category"%>
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
                                ArrayList<New> listn = (ArrayList<New>) request.getAttribute("listn3");
                                for (New item : listn) {
                            %>
                            <h2><%out.println(item.getName());%></h2>
                            <p> <%out.println("Date: " + item.getDate() + " | Id: " + item.getId() + " | View: " + item.getViewtime());%></p>
                            <img src="<%out.println(item.getImage());%>" width="585" height="156" />
                            <div class="clr"></div>
                            <%
                                out.println("<p>" + item.getDescription() + "</p>");
                            %>
                            <%
                                String content = item.getDetail();
                                String[] abc = content.split("\n");
                                for (int i = 0; i < abc.length; i++) {
                                    out.print("<p>" + abc[i] + "</p>");
                                }
                            %>
                        </div>
                        <div class="item">
                            <h2>Comment</h2>
                            <form action="detail?postid=<%out.println(item.getId());%>" method="post">
                                <table>
                                    <tr>
                                        <td>
                                            Name:
                                        </td>
                                        <td>
                                            <input type="text" name="usercmt">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Comment:
                                        </td>
                                        <td>
                                            <textarea name="comment" required rows="4" cols="30"></textarea>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        </td>

                                        <td>
                                            <input type="submit" name="CMTpost" value="Comment">
                                        </td>
                                        <%
                                            }
                                        %>

                                    </tr>
                                </table> 
                            </form>
                            <hr>
                            <%
                                ArrayList<Comment> listcmt = (ArrayList<Comment>) request.getAttribute("listcmt");
                                for (Comment item : listcmt) {
                                    out.println("<table><tr><td>Name: </td><td>"+item.getName()+"</td></tr><tr><td>Comment: </td><td>"+item.getComment()+"</td></tr><tr><td>Date: </td><td>"+item.getDate()+"</td></tr></table>");
                                    out.println("<hr>");
                                }
                            %>
                        </div>
                    </div>
                    <div class="right">
                        <h2>Danh mục</h2>
                        <ul>
                            <%
                                ArrayList<Category> listc = (ArrayList<Category>) request.getAttribute("listc3");
                                for (Category item : listc) {%>
                            <li><a href="cat?cateid=<%out.println(item.getId());%>"><%out.println(item.getName());%></a></li>
                                <%
                                    }
                                %>
                        </ul>
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

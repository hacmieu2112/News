<%-- 
    Document   : editnews
    Created on : Nov 15, 2020, 4:40:11 PM
    Author     : Doktoh
--%>

<%@page import="Model.Category"%>
<%@page import="Model.New"%>
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
                            <li><a href="${pageContext.request.contextPath}/editnew"class="active"><span>Sửa tin</span></a></li>
                            <li><a href="${pageContext.request.contextPath}/checkcmt"><span>Comment</span></a></li>
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
                            <form action="editnew" method="get" enctype="multipart/form-data" id="contactform">
                                <table>
                                    <tr>
                                        <td>
                                            <label>Tên tin*</label>
                                        </td>
                                        <td>
                                            <select name="name">
                                            <%
                                                ArrayList<New> listn = (ArrayList<New>) request.getAttribute("listn");
                                                for (New item : listn) {
                                                    out.println("<option>" + item.getName() + "</option>");
                                                }
                                            %>
                                        </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Danh mục*</label>
                                        </td>
                                        <td>
                                            <select name="category">
                                            <%
                                                ArrayList<Category> listc = (ArrayList<Category>) request.getAttribute("listc");
                                                for (Category item : listc) {
                                                    out.println("<option>" + item.getName() + "</option>");
                                                }
                                            %>
                                        </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Mô tả*</label>
                                        </td>
                                        <td>
                                            <textarea name="description" required rows="6" cols="50"></textarea>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Chi tiết*</label>
                                        </td>
                                        <td>
                                            <textarea name="detail" required rows="10" cols="50"></textarea>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Hình ảnh*</label>
                                        </td>
                                        <td>
                                            <input type="file" name="image" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            
                                        </td>
                                        <td>
                                            <input type="submit" name="edit" value="Edit" class="send" />
                                        </td>
                                    </tr>
                                </table>
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

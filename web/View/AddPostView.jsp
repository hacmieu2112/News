<%-- 
    Document   : AddPost
    Created on : Nov 16, 2020, 4:42:57 AM
    Author     : Doktoh
--%>

<%@page import="Model.New"%>
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
                            <h2>Sửa tin</h2>
                            <form action="addpost" method="get" enctype="multipart/form-data" id="contactform">
                                <ol>
                                    <li>
                                        <label>Tên tin*</label>
                                        <input type="text" name="post">
                                    </li>
                                    <li>
                                        <label>Danh mục*</label>
                                        <select name="category">
                                            <%
                                                ArrayList<Category> listc = (ArrayList<Category>) request.getAttribute("listc");
                                                for (Category item : listc) {
                                                    out.println("<option>" + item.getName() + "</option>");
                                                }
                                            %>
                                        </select>
                                    </li>
                                    <li>
                                        <label>Mô tả*</label>
                                        <textarea name="description" required rows="6" cols="50"></textarea>
                                    </li>
                                    <li>
                                        <label>Chi tiết*</label>
                                        <textarea name="detail" required rows="10" cols="50"></textarea>
                                    </li>
                                    <li>
                                        <label>Hình ảnh*</label>
                                        <input type="file" name="image" />
                                    </li>
                                    <li>
                                        <label>Username*</label>
                                        <input type="text" name="username" />
                                    </li>
                                    <li class="buttons">
                                        <input type="submit" name="add" value="Add" class="send" />
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

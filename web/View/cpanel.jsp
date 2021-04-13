<%-- 
    Document   : cpanel
    Created on : Nov 15, 2020, 4:39:33 PM
    Author     : Doktoh
--%>

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
                            
                            <h2>Danh mục</h2>
                            <div>
                                <ul>
                                    <li><a href="addcat">Thêm danh mục</a></li>
                                    <li><a href="delcat">Xóa danh mục</a></li>
                                </ul>
                            </div>
                            <h2>Tin tức</h2>
                            <div>
                                <ul>
                                    <li><a href="addpost">Thêm tin tức</a></li>
                                    <li><a href="delpost">Xóa tin tức</a></li>
                                </ul>
                            </div>
                            <h2>Người dùng</h2>
                            <div>
                                <ul>
                                    <li><a href="edituserview">Sửa thông tin tài khoản</a></li>
                                </ul>
                            </div>
                            <h2>Comment</h2>
                            <div>
                                <ul>
                                    <li><a href="adckcmt">Check Comment</a></li>
                                </ul>
                            </div>

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

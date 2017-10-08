<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html removeIntertagSpaces="true">
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Yurii Salimov (yuriy.alex.salimov@gmail.com)">
        <meta name="robots" content="index,follow">
        <%--<title>${user.information.title}</title>--%>
        <%--<meta name="title" content="${user.information.title}">--%>
        <%--<meta name="description" content="${user.information.title} - ${user.information.position}">--%>
        <%--<meta name="keywords" content="${user.information.keywords}"/>--%>
        <%--<jsp:include page="/WEB-INF/views/client/home/verification.jsp"/>--%>
        <%--<link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico"/>" type="image/x-icon">--%>
        <%--<link rel="icon" href="<c:url value="/resources/img/favicon.ico"/>" type="image/x-icon">--%>
        <%--<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">--%>
        <%--<link href="<c:url value="/resources/css/style.min.css"/>" rel="stylesheet">--%>
        <%--<link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">--%>
        <%--<compress:css>
            <style type="text/css">
                <jsp:include page="/WEB-INF/views/client/home/wrap_styles.jsp"/>
            </style>
        </compress:css>--%>
    </head>
    <body>
    <%--<jsp:include page="/WEB-INF/views/client/home/home_navbar.jsp"/>--%>
    <section id="home">
        <div id="headerwrap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-lg-offset-3">
                        <h4>Hello, my name is nigga</h4>
                        <h1>${information[0].firstName}</h1>
                        <h4>${information[0].secondName}</h4>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <%--<jsp:include page="/WEB-INF/views/client/project/list.jsp"/>--%>
    <%--<jsp:include page="/WEB-INF/views/client/experience/list.jsp"/>--%>
    <%--<jsp:include page="/WEB-INF/views/client/course/list.jsp"/>--%>
    <%--<jsp:include page="/WEB-INF/views/client/education/list.jsp"/>--%>
    <%--<jsp:include page="/WEB-INF/views/client/skill/list.jsp"/>--%>
    <%--<jsp:include page="/WEB-INF/views/client/language/list.jsp"/>--%>
    <%--<jsp:include page="/WEB-INF/views/client/home/socials.jsp"/>--%>
    <%--<jsp:include page="/WEB-INF/views/client/home/footer.jsp"/>--%>
    <%--<script src="<c:url value="/resources/js/jquery.min.js"/>" type="text/javascript"></script>--%>
    <%--<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>--%>
    <%--<script src="<c:url value="/resources/js/anchor.js"/>" type="text/javascript"></script>--%>
    </body>
    </html>
</compress:html>

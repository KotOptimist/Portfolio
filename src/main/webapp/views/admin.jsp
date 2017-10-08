<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring Security Example</title>
    <%--<link href="/bootstrap.min.css" rel="stylesheet">--%>
    <%--<script src="/jquery-2.2.1.min.js"></script>--%>
    <%--<script src="/bootstrap.min.js"></script>--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>

<script>
    /**
     * Upload the file sending it via Ajax at the Spring Boot server.
     */
    $(function () {
        console.log("ready");
        $('.upload_file').on("click", function () {
            console.log("click");
            $.ajax({
                url: '/admin/uploadFile',
                type: 'POST',
                data: new FormData($("#upload-file-form")[0]),
                enctype: 'multipart/form-data',
                processData: false,
                contentType: false,
                cache: false,
                success: function () {
                    console.log('success');
                    // Handle upload success
                    // ...
                },
                error: function () {
                    console.log('error');
                    // Handle upload error
                    // ...
                }
            });
        }); // function uploadFile
    });
</script>

<div>
    <div class="container" style="margin:50px;border: 1px solid green;">
        <div>
            <form action="/logout" method="POST">
                <button type="submit" class="btn btn-danger">Log Out</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
        <form id="upload-file-form" method="post" enctype="multipart/form-data">
            <label for="upload-file-input">Upload your file:</label>
            <input id="upload-file-input" type="file" name="uploadfile" accept="*"/>
            <button class="upload_file" type="button">Загрузить</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

    </div>
</div>
</body>
</html>
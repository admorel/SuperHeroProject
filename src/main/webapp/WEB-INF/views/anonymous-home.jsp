<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <%--<script type='text/javascript' src="<c:url value="/resources/js/app.js" />"></script> --%>

</head>

<body>

<div>

    <h1>Hello in the Super Heroes Encyclopedia</h1>

    <%-- <li><a href="/api/superHero">liste de super heros</a></li> --%>


    <h1> Ajout d'un commentaire sur un Hero</h1>

    <form method="post" action="api/superHero/{nom}">

        <label for="nom"> Nom <span class="requis">*</span></label>
        <input type="text" id="nom" name="nom" value="" size="20" maxlength="60" />
        <br />

        <label for="comment">Commentaire <span class="requis">*</span></label>
        <input type="text" id="comment" name="comment" value="" size="20" maxlength="60" />
        <br />

        <input type="submit" value="postCommentaire" class="sansLabel" />
        <br />
    </form>


</div>

</body>

</html>




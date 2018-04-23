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

    <h1>Welcome <b><c:out value="${user}"/></b> (this page is protected) !!!</h1>


    <h1> Ajout d'un Super Hero</h1>

    <form method="post" action="api/superHero">
        <label for="nom"> Nom <span class="requis">*</span></label>
        <input type="text" id="nom" name="nom" value="" size="20" maxlength="60" />
        <br />

        <label for="identiteSecrete">Identité secrete <span class="requis">*</span></label>
        <input type="text" id="identiteSecrete" name="identiteSecrete" value="" size="20" maxlength="60" />
        <br />

        <label for="pouvoir">Pouvoir <span class="requis">*</span></label>
        <input type="text" id="pouvoir" name="pouvoir" value="" size="20" maxlength="60" />
        <br />

        <label for="nemesis">Nemesis <span class="requis">*</span></label>
        <input type="text" id="nemesis" name="nemesis" value="" size="20" maxlength="60" />
        <br />

        <input type="submit" value="createSuperHero" class="sansLabel" />
        <br />
    </form>


    <h1> Enlever un Super Hero</h1>

    <form method="deleteSuperHero" action="api/superHero">
        <label for="nom"> Nom <span class="requis">*</span></label>
        <input type="text" id="nom" name="nom" value="" size="20" maxlength="60" />
        <br />

        <input type="submit" value="deleteSuperHero" class="sansLabel" />
        <br />
    </form>


    <a href="<c:url value="/logout" />">Logout</a>

</div>

</body>

</html>




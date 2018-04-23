<%--
  Created by IntelliJ IDEA.
  User: adrien
  Date: 12/03/18
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html>
<head>
    <title>addSuperHero</title>


</head>
<body>
    <h1> Ajout d'un Super Hero</h1>

    <form method="post" action="api/SuperHero">
        <label for="nom"> Nom <span class="requis">*</span></label>
        <input type="text" id="nom" name="_nom" value="" size="20" maxlength="60" />
        <br />

        <label for="identiteSecrete">Identité secrete <span class="requis">*</span></label>
        <input type="text" id="identiteSecrete" name="_identiteSecrete" value="" size="20" maxlength="60" />
        <br />

        <label for="pouvoir">Pouvoir <span class="requis">*</span></label>
        <input type="text" id="pouvoir" name="_pouvoir" value="" size="20" maxlength="60" />
        <br />

        <label for="nemesis">Nemesis <span class="requis">*</span></label>
        <input type="text" id="nemesis" name="_nemesis" value="" size="20" maxlength="60" />
        <br />

        <input type="submit" value="Nouveau Hero" class="sansLabel" />
        <br />
    </form>

</body>
</html>

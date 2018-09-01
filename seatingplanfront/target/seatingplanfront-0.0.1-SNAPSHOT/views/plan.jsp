<html>
    <head>
        <title>Seating Plan</title>
        <meta charset="UTF-8">
        <link href="/seatingplanfront/css/styles.css" rel="stylesheet">
        <link href="/seatingplanfront/lib/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet">
    </head>

    <body>
        <header>
            <h1 class="text-center">Seating Plan</h1>
        </header>

        <div class="container">
            <div id="header">
                <h2>
                    <a onclick="goBack()"><span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span></a>
                    <c:out value="${plan.nom}"/>
                </h2>
                <c:choose>
                    <c:when test="${!empty sessionScope.idUtilisateur}">
                        <p>
                            <a href="/seatingplanfront/edit/plan?id=<c:out value="${plan.id}" />" class="btn btn-success" type="button" id="edit">Editer</a>
                            <a href="/seatingplanfront/deconnexion" class="btn btn-primary" type="button">D&eacute;connexion</a>
                        </p>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#connexion">Connexion</button>
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="col-md-12" id="imgPlan">
                <img id="img" src="/seatingplanfront/img/plans/<c:out value="${plan.image}" />">
            </div>

            <div class="row">
                <div class="col-md-8">
                    <h3>Personnes non plac&eacute;es :</h3>
                    <ul class="list-group">
                        <c:forEach items="${personnes}" var="p">
                            <li class="list-group-item"><c:out value="${p.nom}" /> <c:out value="${p.prenom}" /></li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="col-md-3">
                    <h3>Statistiques :</h3>
                    <ul class="list-group">
                        <li class="list-group-item">Nombre d'emplacements : <c:out value="${plan.nbEmplacements}" /></li>
                        <li class="list-group-item">Emplacements libres : <c:out value="${plan.nbEmplacementsLibres}" /></li>
                    </ul>
                </div>
            </div>
        </div>

        <c:if test="${empty sessionScope.idUtilisateur}">
            <%@ include file="../includes/modal-connexion.jsp" %>
        </c:if>

        <script src="/seatingplanfront/lib/jquery-3.2.1/jquery.js"></script>
        <script src="/seatingplanfront/lib/bootstrap-3.3.7/js/bootstrap.js"></script>
        <script src="/seatingplanfront/js/functions.js"></script>
        <script src="/seatingplanfront/js/harold.js"></script>
        <%@ include file="../js/placementEntites.jsp" %>
    </body>
</html>

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
        <h2>Plans</h2>
        <c:choose>
            <c:when test="${!empty sessionScope.idUtilisateur}">
                <p>
                    <a onclick="openModal('addPlan')" class="btn btn-success" type="button">Ajouter</a>
                    <a href="/seatingplanfront/deconnexion" class="btn btn-primary" type="button">D&eacute;connexion</a>
                </p>
            </c:when>
            <c:otherwise>
                <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#connexion">Connexion</button>
            </c:otherwise>
        </c:choose>
    </div>

    <ul class="list-group">
        <c:forEach items="${plans}" var="plan">
            <li class="list-group-item" id="<c:out value="${plan.id}" />">
                <a href="/seatingplanfront/view/plan?id=<c:out value="${plan.id}"/>">
                        <c:out value="${plan.nom}"/>
                </a>

                <c:if test="${!empty sessionScope.idUtilisateur}">
                    <span onclick="editPlan(<c:out value="${plan.id}" />, '<c:out value="${plan.nom}" />')" class="badge badgeCliquable">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </span>
                </c:if>
            </li>
        </c:forEach>
    </ul>
</div>

<c:if test="${empty sessionScope.idUtilisateur}">
    <%@ include file="../includes/modal-connexion.jsp" %>
</c:if>

<div class="modal fade" id="addPlan">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Ajouter un plan</h4>
            </div>
            <form method="post" action="/seatingplanfront/add/plan">
                <div class="modal-body">
                    <div class="form-group">
                        <label>Nom</label>
                        <input class="form-control" type="text" name="nom">
                    </div>
                    <input type="hidden" name="image" value="plan.png">
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label>Longueur Image en Px</label>
                            <input class="form-control" type="number" name="longueur">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Largeur Image en Px</label>
                            <input class="form-control" type="number" name="largeur">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label>Echelle en Px</label>
                            <input class="form-control" type="number" name="echelle_px">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Echelle en Cm</label>
                            <input class="form-control" type="number" name="echelle_cm">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Ajouter</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="/seatingplanfront/lib/jquery-3.2.1/jquery.js"></script>
<script src="/seatingplanfront/lib/bootstrap-3.3.7/js/bootstrap.js"></script>
<script src="/seatingplanfront/js/functions.js"></script>
</body>
</html>

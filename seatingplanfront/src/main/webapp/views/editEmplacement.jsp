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

    <form id="formEmplacement" method="get" action="/seatingplanfront/add/emplacement">
    <div id="header">
        <h2>
            <a onclick="goBack()"><span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span></a>
            Emplacement ~ Edition
        </h2>
        <p>
            <a class="btn btn-success" onclick="document.getElementById('formEmplacement').submit();">Sauvegarder</a>
            <a id="deleteBtn" class="btn btn-danger" type="button">Supprimer</a>
            <a href="/seatingplanfront/deconnexion" class="btn btn-primary" type="button">D&eacute;connexion</a>
        </p>
    </div>

        <div class="col-md-8">
            <h3>
                <a onclick="openModal('addPersonnes')" ><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
                Occupant :
            </h3>
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <c:forEach items="${emplacement.personnes}" var="pers">
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="heading<c:out value="${pers.id}" />">
                            <a href="/seatingplanfront/delete/emplacement?personne=<c:out value="${pers.id}"/>" type="button" class="close"><span aria-hidden="true">&times;</span></a>
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse<c:out value="${pers.id}" />" aria-expanded="true" aria-controls="collapse<c:out value="${pers.id}" />">
                                    <c:out value="${pers.nom}" /> <c:out value="${pers.prenom}" />
                                </a>
                            </h4>
                        </div>
                        <div id="collapse<c:out value="${pers.id}" />" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading<c:out value="${pers.id}" />">
                            <div class="panel-body">
                                <div class="col-md-6">
                                    <dl class="dl-horizontal">
                                        <dt>T&eacute;l&eacute;phone</dt>
                                        <dd><c:out value="${pers.telephone}" /></dd>
                                        <dt>Date Arriv&eacute;e</dt>
                                        <dd><c:out value="${pers.date_arrivee_jolify}" /></dd>
                                        <dt>Poste Interne</dt>
                                        <dd><c:out value="${pers.poste_interne}" /></dd>
                                    </dl>
                                </div>
                                <div class="col-md-6">
                                    <dl class="dl-horizontal">
                                        <dt>Email</dt>
                                        <dd><c:out value="${pers.email}" /></dd>
                                        <dt>Date Sortie</dt>
                                        <dd><c:out value="${pers.date_sortie_jolify}" /></dd>
                                    </dl>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <input type="hidden" name="id" value="${emplacement.id}">
    </form>

</div>

<div class="modal fade" id="addPersonnes" tabindex="-1" role="dialog" aria-labelledby="modalAddPersonnes">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="/seatingplanfront/edit/emplacement" method="post">
                <input type="hidden" name="id" value="<c:out value="${emplacement.id}" />">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="modalAddPersonnes">Ajout d'occupant</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>S&eacute;lectionner l'occupant du bureau</label>
                        <select class="form-control choicePersonnes" name="personnes[]">
                            <option value=""></option>
                            <c:forEach items="${personnes}" var="pers" >
                                <option value="<c:out value="${pers.id}" />"><c:out value="${pers.nom}" /> <c:out value="${pers.prenom}" /></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Ajouter</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                </div>
            </form>
        </div>
    </div>
</div>

<c:if test="${empty sessionScope.idUtilisateur}">
    <%@ include file="../includes/modal-connexion.jsp" %>
</c:if>

<script src="/seatingplanfront/lib/jquery-3.2.1/jquery.js"></script>
<script src="/seatingplanfront/lib/bootstrap-3.3.7/js/bootstrap.js"></script>
<script src="/seatingplanfront/js/functions.js"></script>
<script>
    var url = new URL(window.location.href);
    var plan = url.searchParams.get("plan");
    $('#deleteBtn').attr("href", "/seatingplanfront/delete/emplacement?id=<c:out value="${emplacement.id}"/>&plan="+plan);
</script>
</body>
</html>

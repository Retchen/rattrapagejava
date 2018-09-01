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
        </h2>
        <p>
            <a class="btn btn-success" href="/seatingplanfront/view/plan?id=<c:out value="${plan.id}" />">Sauvegarder</a>
            <a href="/seatingplanfront/deconnexion" class="btn btn-primary" type="button" id="edit">D&eacute;connexion</a>
        </p>
    </div>

    <div class="col-md-10" id="imgPlan">
        <img id="img" src="/seatingplanfront/img/plans/<c:out value="${plan.image}" />">
    </div>
    <div class="col-md-2">
        <ul class="list-group" id="panelOutils">
           <c:forEach items="${entites}" var="ent">
                <li class="list-group-item" id="<c:out value="${ent.id}"/>"><c:out value="${ent.nom}" /></li>
            </c:forEach> 
        </ul>
    </div>

    <div class="row">
        <div class="col-md-12">
            <h3>
                <a onclick="openModal('addPersonnes')"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
                Personnes non plac&eacute;es :
            </h3>
            <ul class="list-group">
                <c:forEach items="${personnes}" var="p">
                    <li class="list-group-item"><c:out value="${p.nom}" /> <c:out value="${p.prenom}" /></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<div class="modal fade" id="editPlanModal" tabindex="-1" role="dialog" aria-labelledby="EditPlan">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="EditPlan"></h4>
            </div>
            <form method="post" action="/seatingplanfront/add/emplacement">
                <input type="hidden" name="pos_x" id="valuePosX">
                <input type="hidden" name="pos_y" id="valuePosY">
                <input type="hidden" name="entite" id="valueEntite">
                <input type="hidden" name="plan" value="<c:out value="${plan.id}" />">
                <div class="modal-body">
                    <div class="form-group">
                        <label>Orientation</label>
                        <select class="form-control" name="orientation">
                            <option value="horizontal">Horizontal</option>
                            <option value="vertical">Vertical</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Occupant</label>
                        <select class="form-control choicePersonnes" name="personnes[]">
                            <option value=""></option>
                            <c:forEach items="${personnes}" var="pers" >
                                <option value="<c:out value="${pers.id}" />"><c:out value="${pers.nom}" /> <c:out value="${pers.prenom}" /></option>
                            </c:forEach>
                        </select>
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

<div class="modal fade" id="addPersonnes">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Ajouter une personne</h4>
            </div>
            <form method="post" action="/seatingplanfront/add/personne">
                <div class="modal-body">
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label>Nom</label>
                            <input class="form-control" type="text" name="nom">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Pr&eacute;nom</label>
                            <input class="form-control" type="text" name="prenom">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input class="form-control" type="email" name="email">
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label>Telephone</label>
                            <input class="form-control" type="tel" name="tel">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Poste Interne</label>
                            <input class="form-control" type="tel" name="poste">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label>Date Arriv&eacute;e</label>
                            <input class="form-control" type="date" name="arrivee">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Date Sortie</label>
                            <input class="form-control" type="date" name="sortie">
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


<c:if test="${empty sessionScope.idUtilisateur}">
    <%@ include file="../includes/modal-connexion.jsp" %>
</c:if>

<script src="/seatingplanfront/lib/jquery-3.2.1/jquery.js"></script>
<script src="/seatingplanfront/lib/bootstrap-3.3.7/js/bootstrap.js"></script>
<script src="/seatingplanfront/js/functions.js"></script>
<%@ include file="../js/placementEntites.jsp" %>
<script>
    $('#panelOutils li').click(function () {
        $('#panelOutils li').each(function () {
            $(this).removeClass("active")
        });
        $(this).addClass("active");
    });

    $('#imgPlan').click(function (e) {
        var outils = $('#panelOutils li.active');
        var outil = outils.get(0);
        outils.removeClass("active");

        var entLongueur = getEchelle(
                <c:out value="${plan.image_longueur}" /> / $("#imgPlan").width(),
                e.pageX - $('#imgPlan').offset().left
        );
        var entLargeur = getEchelle(
                <c:out value="${plan.image_largeur}" /> / $("#imgPlan").height(),
                e.pageY - $('#imgPlan').offset().top
        );

        $('#valuePosX').val(entLongueur);
        $('#valuePosY').val(entLargeur);
        $('#valueEntite').val(outil.id);

        var modal = $('#editPlanModal');
        modal.find('.modal-title').text('Configuration : ' + outil.innerHTML);
        modal.modal('show');
    });
</script>
</body>
</html>

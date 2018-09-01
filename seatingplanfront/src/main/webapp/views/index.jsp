<html>
<head>
    <title>Seating Plan Basique</title>
    <meta charset="UTF-8">
    <link href="/seatingplanfront/css/styles.css" rel="stylesheet">
    <link href="/seatingplanfront/lib/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet">
</head>

<body>
<header>
    <h1 class="text-center">Seating Plan simple</h1>
</header>

<div class="container">
    <div id="header">
        <c:choose>
        
        <%-- ======================================================= --%>
        <%-- PERMET D'AJOUTER UN PLAN SI UN UTILISATEUR EST CONNECTÉ --%>
      	<%-- ======================================================= --%>

            <c:when test="${!empty sessionScope.idUtilisateur}">
                <p>  
                    <a href="/seatingplanfront/deconnexion" class="btn btn-primary" type="button">D&eacute;connexion</a>
                </p>
            </c:when>
            <c:otherwise>
                <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#connexion">Connexion</button>
            </c:otherwise>
        </c:choose>
    </div>


        <p class="h1" id="<c:out value="1" />">
        		<a href="/seatingplanfront/view/plan?id=<c:out value="1"/>">
                <c:out value="Plan"/>
                </a>
        </p>
        
		<%-- ====================================================== --%>
		<%-- PERMET D'EDITER UN PLAN SI UN UTILISATEUR EST CONNECTÉ --%>
		<%-- ====================================================== --%>

</div>

<%-- ===================================================================== --%>
<%-- S'IL N'Y A PAS D'UTILISATEUR CONNECTÉ, AFFICHE LE BOUTON DE CONNEXION --%>
<%-- ===================================================================== --%>
		
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

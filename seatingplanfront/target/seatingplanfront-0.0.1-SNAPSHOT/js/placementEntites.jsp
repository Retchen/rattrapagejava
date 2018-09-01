<script>
    // ----------------------------- Script de placement des entités : -------------------------------
    // Initialisation variables :
    <c:set var="echellePxCm" value="${plan.echelle_pixel / plan.echelle_cm}" />
    var echelleLongueur = $("#imgPlan").width() / <c:out value="${plan.image_longueur}" />;
    var echelleLargeur = $("#imgPlan").height() / <c:out value="${plan.image_largeur}" />;

    // Placement des entités :
    <c:forEach items="${plan.emplacements}" var="emp">
    document.getElementById('imgPlan').appendChild(
            getDiv(
                    <c:out value="${emp.id}" />, // Emplacement ID
                    // Dimensions entité mise à l'échelle:
                    getEchelle(echelleLongueur, <c:out value="${emp.entite.longueur * echellePxCm}" />),
                    getEchelle(echelleLargeur, <c:out value="${emp.entite.largeur * echellePxCm}" />),
                    // Position entité mise à l'échelle :
                    getEchelle(echelleLongueur, <c:out value="${emp.pos_x}" />),
                    getEchelle(echelleLongueur, <c:out value="${emp.pos_y}" />),
                    // Configuration entité :
                    "<c:out value="${emp.orientation}" />",
                    getColor(<c:out value="${emp.occupe}" />)
            )
    );
    </c:forEach>

    // ----------------------------- Configuration Page : -------------------------------
    $(window).resize(function(){location.reload();});

    $('.emplacement').click(function () {
        window.location.href = "emplacement?id=" + this.id + "&plan=" + <c:out value="${plan.id}" />;
    });
</script>
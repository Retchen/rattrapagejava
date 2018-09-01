function getDiv(id, width, height, pos_x, pos_y, orientation, color) {
    if(orientation == "vertical") height = [width, width = height][0];

    var obj = document.createElement('div');
    obj.style.position = 'absolute';
    obj.style.width = width + "px";
    obj.style.height = height + "px";
    obj.style.left = pos_x;
    obj.style.top = pos_y;
    obj.style.backgroundColor = color;
    obj.style.borderRadius = "5px";
    obj.style.cursor = "pointer";
    obj.id = id;
    obj.className = "emplacement";
    return obj;
}

function getEchelle(echelle, value) {
    return Math.round(echelle * value);
}

function getColor(occupe) {
    return occupe ? "red" : "black";
}

function goBack() {
    var url = new URL(window.location.href);
    var plan = url.searchParams.get("plan");
    if(plan !== null) {
        window.location.href = "/seatingplanfront/" + url.pathname.split("/")[2] + "/plan?id="+plan;
    } else {
        window.location.href = "/seatingplanfront/index";
    }
}

function addSelectPersonnes(e) {
    if($(e).is(':last-child')) {
        if($(e).find(":selected").val() != "") {
            $('.choicePersonnes:last-child').clone().insertAfter($('.choicePersonnes:last-child'));
        }
    } else {
        if($(e).find(":selected").val() == "") {
            $(e).remove();
        }
    }
}

function openModal(modal) {
    $('#'+modal).modal('show');
}

function editPlan(id, nom) {
    $('li#'+id).html('<form method="post" class="form-inline" style="margin-bottom: 0" action="/seatingplanfront/edit/plan?id=' + id + '">' +
    '<input type="text" class="form-control" name="nom" value="'+ nom +'" style="width: 85%;">' +
    '<button class="btn btn-danger pull-right" type="submit" name="delete" value="1"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>' +
    '<button class="btn btn-default pull-right" type="button" onclick="location.reload();"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>' +
    '<button class="btn btn-primary pull-right" type="submit" name="update" value="1"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button>' +
    '</form>');
}
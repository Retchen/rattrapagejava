<div class="modal fade" id="connexion" tabindex="-1" role="dialog" aria-labelledby="Connexion">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="Connexion">Connexion</h4>
            </div>
            <form method="post" action="/seatingplanfront/connexion">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="identifiant">Identifiant</label>
                        <input type="text" class="form-control" id="identifiant" name="identifiant" maxlength="100"
                               value="admin">
                    </div>
                    <div class="form-group">
                        <label for="mdp">Mot de passe</label>
                        <input type="password" class="form-control" id="mdp" name="mdp" value="admin">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Connexion</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                </div>
            </form>
        </div>
    </div>
</div>

package donnees;

public class ComparateurAlbum implements ComparateurCD {
    public boolean etreAvant(CD a, CD b) {
        return a.compareTitre(b) < 0;
    }
}

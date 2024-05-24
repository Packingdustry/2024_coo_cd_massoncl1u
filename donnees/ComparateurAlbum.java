package donnees;

public class ComparateurAlbum implements ComparateurCD {
    public boolean etreAvant(CD a, CD b) {
        return (a.getNomCD().compareTo(b.getNomCD())) < 0;
    }
}

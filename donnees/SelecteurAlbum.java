package donnees;

public class SelecteurAlbum implements SelecteurCD {
    @Override
    public boolean etreEgal(CD cd, String motCle) {
        return cd.getNomCD().equals(motCle);
    }
}

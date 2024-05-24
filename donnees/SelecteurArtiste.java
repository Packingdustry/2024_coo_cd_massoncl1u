package donnees;

public class SelecteurArtiste implements SelecteurCD {
    @Override
    public boolean etreEgal(CD cd, String motCle) {
        return cd.getNomArtiste().equals(motCle);
    }
}

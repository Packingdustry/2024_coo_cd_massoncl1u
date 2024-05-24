package donnees;

public class ComparateurArtiste implements ComparateurCD {
    public boolean etreAvant(CD a, CD b) {
        return (a.getNomArtiste().compareTo(b.getNomArtiste())) < 0;
    }
}

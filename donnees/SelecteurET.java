package donnees;

public class SelecteurET implements SelecteurMulti {
    @Override
    public boolean etreEgal(CD cd, SelecteurCD s1, String motCle1, SelecteurCD s2, String motCle2) {
        return s1.etreEgal(cd, motCle1) && s2.etreEgal(cd, motCle2);
    }
}

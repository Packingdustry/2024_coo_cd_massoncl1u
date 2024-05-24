package test;

import XML.ChargeurMagasin;
import donnees.CD;
import donnees.Magasin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class MagasinTest {

    @Test
    void trierTitre() throws FileNotFoundException {
        ChargeurMagasin cm = new ChargeurMagasin("fichiers");
        Magasin m = cm.chargerMagasin();
        m.trierTitre();
        assertTrue(m.getCd(0).compare(m.getCd(11), CD.TITRE) < 0, "le 1er cd devrait être avant le dernier");
    }

    @Test
    void trierArtiste() throws FileNotFoundException {
        ChargeurMagasin cm = new ChargeurMagasin("fichiers");
        Magasin m = cm.chargerMagasin();
        m.trierArtiste();
        assertTrue(m.getCd(0).compare(m.getCd(11), CD.ARTISTE) < 0, "le 1er cd devrait être avant le dernier");
    }
}
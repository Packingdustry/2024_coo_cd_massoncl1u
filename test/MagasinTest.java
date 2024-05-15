package test;

import XML.ChargeurMagasin;
import donnees.Magasin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MagasinTest {

    @Test
    void trier() throws FileNotFoundException {
        ChargeurMagasin cm = new ChargeurMagasin("fichiers");
        Magasin m = cm.chargerMagasin();
        m.trier();
        assertTrue(m.getCd(0).compareTo(m.getCd(11)) < 0, "le 1er cd devrait être avant le dernier");
    }
}
package test;

import XML.ChargeurMagasin;
import donnees.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class MagasinTest {

    @Test
    void trierTitre() throws FileNotFoundException {
        ChargeurMagasin cm = new ChargeurMagasin("fichiers");
        Magasin m = cm.chargerMagasin();
        System.out.println(m);
        m.trierTitre();
        System.out.println(m);
        ComparateurAlbum comp = new ComparateurAlbum();
        assertTrue(comp.etreAvant(m.getCd(0), m.getCd(11)), "Le 1er CD devrait être avant le dernier. ");
    }

    @Test
    void trierArtiste() throws FileNotFoundException {
        ChargeurMagasin cm = new ChargeurMagasin("fichiers");
        Magasin m = cm.chargerMagasin();
        m.trierArtiste();
        ComparateurArtiste comp = new ComparateurArtiste();
        assertTrue(comp.etreAvant(m.getCd(0), m.getCd(11)), "Le 1er CD devrait être avant le dernier. ");
    }
}
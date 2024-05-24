package test;

import XML.ChargeurMagasin;
import donnees.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MagasinTest {

    @Test
    void trierTitre() throws FileNotFoundException {
        ChargeurMagasin cm = new ChargeurMagasin("fichiers");
        Magasin m = cm.chargerMagasin();
        m.trierTitre();
        ComparateurAlbum comp = new ComparateurAlbum();
        assertTrue(comp.etreAvant(m.getCd(0), m.getCd(11)), "Le 1er CD devrait être avant le dernier. ");
    }

    @Test
    void trierArtiste() throws FileNotFoundException {
        ChargeurMagasin cm = new ChargeurMagasin("fichiers");
        Magasin m = cm.chargerMagasin();
        m.trierArtiste();
        System.out.println(m);
        ComparateurArtiste comp = new ComparateurArtiste();
        assertTrue(comp.etreAvant(m.getCd(0), m.getCd(11)), "Le 1er CD devrait être avant le dernier. ");
    }

    @Test
    void chercherArtiste() throws FileNotFoundException {
        ChargeurMagasin cm = new ChargeurMagasin("fichiers");
        Magasin m = cm.chargerMagasin();
        ArrayList<CD> cdZebda = m.chercherArtiste("Zebda");
        assertEquals(1, cdZebda.size(), "La liste devrait contenir 1 CD. ");
        assertEquals("Zebda", cdZebda.get(0).getNomArtiste(), "L'artiste devrait être \"Céline Dion\". ");
        assertEquals("Essence ordinaire", cdZebda.get(0).getNomCD(), "Le titre devrait être \"Essence ordinaire\". ");
    }

    @Test
    void chercherTitre() throws FileNotFoundException {
        ChargeurMagasin cm = new ChargeurMagasin("fichiers");
        Magasin m = cm.chargerMagasin();
        ArrayList<CD> cdZebda = m.chercherTitre("Essence ordinaire");
        assertEquals(1, cdZebda.size(), "La liste devrait contenir 1 CD. ");
        assertEquals("Zebda", cdZebda.get(0).getNomArtiste(), "L'artiste devrait être \"Céline Dion\". ");
        assertEquals("Essence ordinaire", cdZebda.get(0).getNomCD(), "Le titre devrait être \"Essence ordinaire\". ");
    }
}
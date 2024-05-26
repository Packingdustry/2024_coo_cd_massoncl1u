package donnees;

import XML.ChargeurMagasin;
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
        ComparateurArtiste comp = new ComparateurArtiste();
        assertTrue(comp.etreAvant(m.getCd(0), m.getCd(11)), "Le 1er CD devrait être avant le dernier. ");
    }

    @Test
    void chercherArtiste() throws FileNotFoundException {
        ChargeurMagasin cm = new ChargeurMagasin("fichiers");
        Magasin m = cm.chargerMagasin();
        ArrayList<CD> cdZebda = m.chercherArtiste("Zebda");
        assertEquals(1, cdZebda.size(), "La liste devrait contenir 1 CD. ");
        assertEquals("Zebda", cdZebda.getFirst().getNomArtiste(), "L'artiste devrait être \"Céline Dion\". ");
        assertEquals("Essence ordinaire", cdZebda.getFirst().getNomCD(), "Le titre devrait être \"Essence ordinaire\". ");
    }

    @Test
    void chercherTitre() throws FileNotFoundException {
        ChargeurMagasin cm = new ChargeurMagasin("fichiers");
        Magasin m = cm.chargerMagasin();
        ArrayList<CD> cdZebda = m.chercherTitre("Essence ordinaire");
        assertEquals(1, cdZebda.size(), "La liste devrait contenir 1 CD. ");
        assertEquals("Zebda", cdZebda.getFirst().getNomArtiste(), "L'artiste devrait être \"Céline Dion\". ");
        assertEquals("Essence ordinaire", cdZebda.getFirst().getNomCD(), "Le titre devrait être \"Essence ordinaire\". ");
    }

    @Test
    void chercherMulti() throws FileNotFoundException {
        ChargeurMagasin cm = new ChargeurMagasin("fichiers");
        Magasin m = cm.chargerMagasin();
        ArrayList<CD> cdSelecTeT1 = m.chercherTitreEtTitre("Bénabar", "Bénabar");
        ArrayList<CD> cdSelecTeT2 = m.chercherTitreEtTitre("Bénabar", "Céline Dion");

        assertEquals(1, cdSelecTeT1.size(), "La liste devrait contenir 1 CD. ");
        assertEquals("Bénabar", cdSelecTeT1.getFirst().getNomArtiste(), "L'artiste devrait être \"Bénabar\". ");
        assertEquals("Bénabar", cdSelecTeT1.getFirst().getNomCD(), "Le titre devrait être \"Bénabar\". ");

        assertEquals(0, cdSelecTeT2.size(), "La liste ne devrait pas contenir de CD. ");

        ArrayList<CD> cdSelecAeA1 = m.chercherArtisteEtArtiste("Bénabar", "Bénabar");
        ArrayList<CD> cdSelecAeA2 = m.chercherArtisteEtArtiste("Bénabar", "Les Risques du métier");

        assertEquals(2, cdSelecAeA1.size(), "La liste devrait contenir 2 CD. ");
        assertEquals("Bénabar", cdSelecAeA1.getFirst().getNomArtiste(), "L'artiste devrait être \"Bénabar\". ");
        assertEquals("Bénabar", cdSelecAeA1.getFirst().getNomCD(), "Le titre devrait être \"Bénabar\". ");

        assertEquals(0, cdSelecAeA2.size(), "La liste ne devrait pas contenir de CD. ");

        ArrayList<CD> cdSelecTeA1 = m.chercherTitreEtArtiste("Bénabar", "Bénabar");
        ArrayList<CD> cdSelecTeA2 = m.chercherTitreEtArtiste("Let's Talk About Love", "Bénabar");

        assertEquals(1, cdSelecTeA1.size(), "La liste devrait contenir 1 CD. ");
        assertEquals("Bénabar", cdSelecTeA1.getFirst().getNomArtiste(), "L'artiste devrait être \"Bénabar\". ");
        assertEquals("Bénabar", cdSelecTeA1.getFirst().getNomCD(), "Le titre devrait être \"Bénabar\". ");

        assertEquals(0, cdSelecTeA2.size(), "La liste ne devrait pas contenir de CD. ");

        ArrayList<CD> cdSelecToT = m.chercherTitreOuTitre("Bénabar", "Les Risques du métier");
        ArrayList<CD> cdSelecAoA = m.chercherArtisteOuArtiste("Bénabar", "Céline Dion");
        ArrayList<CD> cdSelecToA = m.chercherTitreOuArtiste("Let's Talk About Love", "Bénabar");

        assertEquals(2, cdSelecToT.size(), "La liste devrait contenir 2 CDs. ");
        assertEquals("Bénabar", cdSelecToT.getFirst().getNomArtiste(), "L'artiste devrait être \"Bénabar\". ");
        assertEquals("Bénabar", cdSelecToT.getFirst().getNomCD(), "Le titre devrait être \"Bénabar\". ");
        assertEquals("Bénabar", cdSelecToT.getLast().getNomArtiste(), "L'artiste devrait être \"Bénabar\". ");
        assertEquals("Les Risques du métier", cdSelecToT.getLast().getNomCD(), "Le titre devrait être \"Les Risques du métier\". ");

        assertEquals(3, cdSelecAoA.size(), "La liste devrait contenir 3 CDs. ");

        assertEquals(3, cdSelecToA.size(), "La liste devrait contenir 3 CDs. ");

        ArrayList<CD> cdSelecNt = m.chercherNonTitre("Bénabar");
        ArrayList<CD> cdSelecNa = m.chercherNonArtiste("Bénabar");

        assertEquals(11, cdSelecNt.size(), "La liste devrait contenir 10 CDs");
        assertEquals(10, cdSelecNa.size(), "La liste devrait contenir 11 CDs");
    }
}
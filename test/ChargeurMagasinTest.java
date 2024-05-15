package test;

import XML.ChargeurMagasin;
import donnees.Magasin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ChargeurMagasinTest {

    @Test
    void chargerMagasin() throws FileNotFoundException {
        ChargeurMagasin cm = new ChargeurMagasin("fichiers");
        Magasin m = cm.chargerMagasin();
        assertEquals(m.getNombreCds(), 12, "Il devrait y avoir 12 CDs. ");
    }

    @Test
    void chargerMagasinException() {
        ChargeurMagasin cm = new ChargeurMagasin("abc");

        FileNotFoundException exception = assertThrows (
                FileNotFoundException.class,
                () -> {Magasin m = cm.chargerMagasin();}
        );
    }
}

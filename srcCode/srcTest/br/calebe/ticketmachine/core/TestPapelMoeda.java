package br.calebe.ticketmachine.core;

/**
 *
 * @author João Victor Canella
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPapelMoeda {

    @Test
    public void testValorPapelMoedaNoConstrutorComValorDiferente() {
        PapelMoeda papelMoeda = new PapelMoeda(20, 5);
        assertEquals(20, papelMoeda.getValor());
    }

    @Test
    public void testQuantidadePapelMoedaNoConstrutorComQuantidadeDiferente() {
        PapelMoeda papelMoeda = new PapelMoeda(5, 10);
        assertEquals(10, papelMoeda.getQuantidade());
    }
}

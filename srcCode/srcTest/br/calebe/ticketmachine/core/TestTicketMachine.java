package br.calebe.ticketmachine.core;

/**
 *
 * @author Murilo Gomez Munhoz
 */

import org.junit.Before;
import org.junit.Test;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;

import static org.junit.Assert.*;

public class TestTicketMachine{

    private TicketMachine ticketMachine;

    @Before
    public void setUp() {
        ticketMachine = new TicketMachine(15);
    }

    @Test
    public void testSaldoAposInsercaoCorreta() {
        try {
            ticketMachine.inserir(30);
            assertEquals(45, ticketMachine.getSaldo());
        } catch (PapelMoedaInvalidaException e) {
            //
        }
    }

    @Test
    public void testImprimirBilheteComSaldoSuficiente() {
        try {
            ticketMachine.inserir(25);
            try {
                String bilhete = ticketMachine.imprimir();
                assertTrue(bilhete.contains("R$ 25,00"));
            } catch (SaldoInsuficienteException e) {
                //
            }
        } catch (PapelMoedaInvalidaException e) {
            //
        }
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void testNaoDeveImprimirBilheteComSaldoInsuficiente() throws SaldoInsuficienteException {
        try {
            ticketMachine.inserir(10);
            ticketMachine.imprimir();
        } catch (PapelMoedaInvalidaException e) {
            //
        }
    }
}

package hotel.pessoas;

import hotel.excecoes.CpfException;
import hotel.pessoas.Cargo;
import hotel.infraestrutura.Sala;
import hotel.infraestrutura.Quarto;
import hotel.infraestrutura.TipoQuarto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ClienteTest {

    @Test
    void alugarQuartoTest() throws CpfException {
        var cliente = new Cliente("andre", "13029806022", 0);
        var quarto = new Quarto(0, TipoQuarto.SIMPLES);
        cliente.alugarQuarto(quarto);
        Assertions.assertFalse(quarto.estaVago());
    }
}

package hotel.gerencia;

import java.util.ArrayList;

import hotel.gerencia.RecepcaoHotel;
import hotel.pessoas.Cliente;
import hotel.pessoas.Pessoa;
import hotel.infraestrutura.Andar;
import hotel.infraestrutura.Quarto;
import hotel.infraestrutura.TipoQuarto;
import hotel.excecoes.CpfException;
import hotel.excecoes.ClienteException;
import hotel.excecoes.RecepcaoException;
import hotel.excecoes.ReservaException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RecepcaoHotelTest {
    @Test
    void getClienteTest() throws CpfException, RecepcaoException {
        var recepcao = new RecepcaoHotel<Cliente, Andar>();
        Assertions.assertThrows(ClienteException.class, () -> recepcao.getCliente(0));

        recepcao.cadastrarCliente(new Pessoa("andre", "13029806022"));
        var cliente = recepcao.getCliente(0);
        Assertions.assertEquals(cliente.getNome(), "andre");
        Assertions.assertEquals(cliente.getCpf(), "13029806022");
    }

    @Test
    void alugarQuartoInexistenteTest() throws CpfException, RecepcaoException {
        var recepcao = new RecepcaoHotel<Cliente, Andar>();
        recepcao.cadastrarCliente(new Pessoa("andre", "13029806022"));
        var cliente = recepcao.getCliente(0);
        Assertions.assertThrows(ReservaException.class, () -> recepcao.alugarQuarto(cliente, TipoQuarto.SIMPLES));
    }

    @Test
    void alugarQuartoTipoInexistenteTest() throws CpfException, RecepcaoException {
        var recepcao = new RecepcaoHotel<Cliente, Andar>();
        recepcao.cadastrarCliente(new Pessoa("andre", "13029806022"));
        var cliente = recepcao.getCliente(0);

        var quartos = new ArrayList<Quarto>();
        var quarto = new Quarto(0, TipoQuarto.SIMPLES);
        quartos.add(quarto);

        var andar = new Andar(0, quartos);
        recepcao.adicionarAndar(andar);

        Assertions.assertThrows(ReservaException.class, () -> recepcao.alugarQuarto(cliente, TipoQuarto.CASAL));
    }

    @Test
    void alugarQuartoIndisponivelTest() throws CpfException, RecepcaoException {
        var recepcao = new RecepcaoHotel<Cliente, Andar>();
        recepcao.cadastrarCliente(new Pessoa("andre", "13029806022"));
        var cliente1 = recepcao.getCliente(0);

        var quartos = new ArrayList<Quarto>();
        var quarto = new Quarto(0, TipoQuarto.SIMPLES);
        quartos.add(quarto);

        var andar = new Andar(0, quartos);
        recepcao.adicionarAndar(andar);
        recepcao.alugarQuarto(cliente1, TipoQuarto.SIMPLES);

        recepcao.cadastrarCliente(new Pessoa("davi", "11849793085"));
        var cliente2 = recepcao.getCliente(1);

        Assertions.assertThrows(ReservaException.class, () -> recepcao.alugarQuarto(cliente2, TipoQuarto.SIMPLES));
    }

    @Test
    void darBaixaTest() throws CpfException, RecepcaoException {
        var recepcao = new RecepcaoHotel<Cliente, Andar>();
        recepcao.cadastrarCliente(new Pessoa("andre", "13029806022"));
        var cliente = recepcao.getCliente(0);
        var quartos = new ArrayList<Quarto>();
        for (var tipo : TipoQuarto.values()) {
            var quarto = new Quarto(0, tipo);
            quartos.add(quarto);
        }

        var andar = new Andar(0, quartos);
        recepcao.adicionarAndar(andar);

        recepcao.alugarQuarto(cliente, TipoQuarto.SIMPLES);
        var diariaEsperada = TipoQuarto.SIMPLES.getDiaria() * cliente.getDiasHospedado();
        Assertions.assertEquals(recepcao.darBaixa(cliente), diariaEsperada);
    }
}

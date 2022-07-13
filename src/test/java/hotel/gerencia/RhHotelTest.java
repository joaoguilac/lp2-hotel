package hotel.gerencia;

import hotel.pessoas.Funcionario;
import hotel.pessoas.Pessoa;
import hotel.pessoas.Cargo;
import hotel.excecoes.CpfException;
import hotel.excecoes.FuncionarioException;
import hotel.excecoes.RhException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RhHotelTest {
    @Test
    void getFuncionarioTest() throws CpfException, RhException {
        var rh = new RhHotel<Pessoa, Funcionario>();
        Assertions.assertThrows(FuncionarioException.class, () -> rh.getFuncionario(0));

        rh.contratar(new Pessoa("andre", "13029806022"), Cargo.RECEPCIONISTA);
        var funcionario = rh.getFuncionario(0);
        Assertions.assertEquals(funcionario.getNome(), "andre");
        Assertions.assertEquals(funcionario.getCpf(), "13029806022");
    }

    @Test
    void demitirTest() throws CpfException, RhException {
        var rh = new RhHotel<Pessoa, Funcionario>();
        rh.contratar(new Pessoa("andre", "13029806022"), Cargo.RECEPCIONISTA);
        var funcionario = rh.getFuncionario(0);
        rh.demitir(funcionario);
        Assertions.assertThrows(FuncionarioException.class, () -> rh.getFuncionario(0));
    }
}

package hotel.pessoas;

import hotel.excecoes.CpfException;
import hotel.pessoas.Cargo;
import hotel.infraestrutura.Sala;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FuncionarioTest {

    @Test
    void darAumentoTest() throws CpfException {
        for (var cargo : Cargo.values()) {
            var funcionario = new Funcionario("andre", "13029806022", 0, cargo);
            funcionario.darAumento();
            Assertions.assertEquals(funcionario.getSalario(), cargo.getSalario() * 1.1, 0.000000000001);
            funcionario.darAumento();
            Assertions.assertEquals(funcionario.getSalario(), cargo.getSalario() * 1.21, 0.000000000001);
        }
    }

    @Test
    void salaTest() throws CpfException {
        for (var cargo : Cargo.values()) {
            var funcionario = new Funcionario("andre", "13029806022", 0, cargo);
            switch (cargo) {
                case RECEPCIONISTA -> Assertions.assertEquals(funcionario.getSala(), Sala.RECEPCAO);
                case COZINHEIRO -> Assertions.assertEquals(funcionario.getSala(), Sala.COZINHA);
                case CONTADOR -> Assertions.assertEquals(funcionario.getSala(), Sala.ALMOXARIFADO);
                case ADMINISTRADOR -> Assertions.assertEquals(funcionario.getSala(), Sala.ADMINISTRACAO);
            }
        }
    }
}

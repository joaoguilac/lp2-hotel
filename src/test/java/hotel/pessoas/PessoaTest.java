package hotel.pessoas;

import hotel.excecoes.CpfException;
import hotel.pessoas.Pessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class PessoaTest {

    @Test
    void cpfValidos() {
        String[] cpfs = {"12345678909", "13029806022", "11849793085", "02471517005", "13901619003"};
        for (var cpf : cpfs) {
            Assertions.assertAll(() -> {
                var pessoa = new Pessoa("andre", cpf);
            });
        }
    }

    @Test
    void cpfInvalidos() {
        String[] cpfs = {"12345678908", "1302s8a6-21", "11849793", "0247151701555", "11111111111"};
        for (var cpf : cpfs) {
            Assertions.assertThrows(CpfException.class, () -> {
                var pessoa = new Pessoa("andre", cpf);
            });
        }
    }
}

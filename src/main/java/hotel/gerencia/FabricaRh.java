package hotel.gerencia;

import hotel.pessoas.Pessoa;
import hotel.pessoas.Funcionario;

/**
 * Fábrica responsável por construir instância válida da interface de RecursosHumanos.
 * @see RecursosHumanos
 */
public class FabricaRh {

    /**
     * Cria instância da interface de RecursosHumanos.
     * @param <T> Tipo genérico para representar uma pessoa.
     * @param <F> Tipo genérico para representar um funcionário.
     * @return Instância de uma classe que implementa a interface RecursosHumanos.
     */
    public static <T extends Pessoa, F extends Funcionario> RecursosHumanos<T, F> criarRH() {
        return new RhHotel<T, F>();
    }
}

package hotel.excecoes;

/**
 * Exceção lançada quando um funcionário com o id não é encontrado na lista de funcionários.
 */
public class FuncionarioException extends RhException {
    /**
     * Constrói a exceção para ser lançada.
     * @param id O id do funcionário que não foi encontrado na lista de funcionários.
     */
    public FuncionarioException(int id) {
        super("Funcionário com id " + id + " não foi encontrado");
    }
}


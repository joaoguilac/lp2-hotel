package hotel.excecoes;

/**
 * Exceção lançada quando um cliente com o id não é encontrado na lista de clientes.
 */
public class ClienteException extends RecepcaoException {
    /**
     * Constrói a exceção para ser lançada.
     * @param id O id do cliente que não foi encontrado na lista de clientes.
     */
    public ClienteException(int id) {
        super("Cliente com id " + id + " não foi encontrado");
    }
}


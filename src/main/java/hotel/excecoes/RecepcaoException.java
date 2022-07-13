package hotel.excecoes;

/**
 * Representa exceções lançadas na interface Recepcao.
 * @see hotel.gerencia.Recepcao
 */
public class RecepcaoException extends Exception {
    /**
     * Constrói a exceção para ser lançada.
     * @param message A mensagem a ser impressa quando a exceção é lançada.
     */
    public RecepcaoException(String message) {
        super(message);
    }
}

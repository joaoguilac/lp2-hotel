package hotel.excecoes;

/**
 * Representa exceções lançadas na interface RecursosHumanos.

 * @see hotel.gerencia.RhHotel
 */
public class RhException extends Exception {
    /**
     * Constrói a exceção para ser lançada.
     * @param message A mensagem a ser impressa quando a exceção é lançada.
     */
    public RhException(String message) {
        super(message);
    }
}

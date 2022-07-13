package hotel.excecoes;

/**
 * Exceção lançada quando o cpf da pessoa é inválido.
 */
public class CpfException extends Exception {
    /**
     * Constrói a exceção para ser lançada.
     * @param cpf O cpf inválido da pessoa.
     */
    public CpfException(String cpf) {
        super("O CPF: " + cpf + " é inválido. Insira um CPF válido");
    }
}

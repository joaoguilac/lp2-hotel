package hotel.excecoes;

import hotel.infraestrutura.TipoQuarto;

import java.util.Locale;

/**
 * Exceção lançada quando nenhum quarto de um certo tipo está disponível para aluguel.
 */
public class ReservaException extends RecepcaoException {
    /**
     * Constrói a exceção para ser lançada.
     * @param tipoQuarto O tipo do quarto que não possui vagas.
     */
    public ReservaException(TipoQuarto tipoQuarto) {
        super("Nenhum quarto do tipo " + tipoQuarto.name().toLowerCase(Locale.ROOT) + " está disponível");
    }
}

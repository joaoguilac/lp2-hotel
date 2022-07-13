package hotel.gerencia;

import hotel.excecoes.*;
import hotel.infraestrutura.Andar;
import hotel.infraestrutura.TipoQuarto;
import hotel.pessoas.Cliente;
import hotel.pessoas.Pessoa;

/**
 * Interface responsável por definir o modo de atuação do setor de recursos humanos.
 * @param <C> Tipo genérico para representar um cliente.
 * @param <A> Tipo genérico para representar um andar.
 */
public interface Recepcao <C extends Cliente, A extends Andar> {
    /**
     * Adiciona um andar na lista de andares
     * @param andar O andar a ser adicionado
     */
    public void adicionarAndar(Andar andar);

    /**
     * Cadastra um cliente.
     * @param pessoa A pessoa a ser cadastrada como cliente.
     * @throws CpfException é lançado quando o cpf é inválido.
     */
    void cadastrarCliente(Pessoa pessoa) throws CpfException;

    /**
     * Recupera um cliente através de seu id.
     * @param id O id do cliente.
     * @return O cliente que possuir o id especificado.
     * @throws RecepcaoException é lançado caso não exista um cliente com o id especificado.
     */
    Cliente getCliente(int id) throws RecepcaoException;

    /**
     * Reserva um quarto do tipo requisitado para um cliente por um determinado número de dias.
     * @param cliente O cliente para o qual será feito a reserva.
     * @param tipoQuarto O tipo do quarto a ser reservado.
     * @param diasHospedado O número de dias da reserva do quarto.
     * @return O preço total do aluguel do quarto.
     * @throws RecepcaoException é lançado caso seja um cliente inválido.
     * Ou caso nenhum quarto do tipo especificado esteja vago.
     */
    double alugarQuarto(C cliente, TipoQuarto tipoQuarto, int diasHospedado) throws RecepcaoException;

    /**
     * Reserva um quarto do tipo requisitado para um cliente.
     * O valor da estadia só será calculado quando o cliente der baixa.
     * @param cliente O cliente para o qual será feito a reserva.
     * @param tipoQuarto O tipo do quarto a ser reservado.
     * @throws RecepcaoException é lançado caso seja um cliente inválido.
     * Ou caso nenhum quarto do tipo especificado esteja vago.
     */
    void alugarQuarto(C cliente, TipoQuarto tipoQuarto) throws RecepcaoException;

    /**
     * Dá baixa nos quartos alugados pelo cliente.
     * @param cliente O cliente que dará baixa nos quartos alugados.
     * @return O valor do aluguel pago pelo cliente.
     * @throws RecepcaoException é lançado caso seja um cliente inválido.
     */
    double darBaixa(C cliente) throws RecepcaoException;
}

package hotel.gerencia;

import hotel.excecoes.*;
import hotel.infraestrutura.Andar;
import hotel.infraestrutura.Quarto;
import hotel.infraestrutura.TipoQuarto;
import hotel.pessoas.Cliente;
import hotel.pessoas.Funcionario;
import hotel.pessoas.Pessoa;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a recepção do hotel.
 * @param <C> Tipo genérico para representar um cliente.
 * @param <A> Tipo genérico para representar um andar.
 */
public class RecepcaoHotel<C extends Cliente, A extends Andar> implements Recepcao<C,A> {
    private List<Cliente> clientes;
    private List<Andar> andares;

    /**
     * Cria uma instância da classe RecepcaoHotel.
     */
    public RecepcaoHotel() {
        this.clientes = new ArrayList<>();
        this.andares = new ArrayList<>();
    }

    /**
     * Adiciona um andar na lista de andares
     * @param andar O andar a ser adicionado
     */
    @Override
    public void adicionarAndar(Andar andar) {
        this.andares.add(andar);
    }

    /**
     * Cadastra um cliente na lista de clientes.
     * @param pessoa A pessoa a ser cadastrada como cliente.
     * @throws CpfException é lançado quando o cpf é inválido.
     */
    @Override
    public void cadastrarCliente(Pessoa pessoa) throws CpfException {
        var id = clientes.size();
        var cliente = new Cliente(pessoa.getNome(), pessoa.getCpf(), id);
        clientes.add(cliente);
    }

    /**
     * Recupera um cliente da lista através de seu id.
     * @param id O id do cliente baseado no seu índice na lista.
     * @return O cliente que possuir o id especificado.
     * @throws RecepcaoException é lançado caso não exista um cliente com o id na lista.
     */
    @Override
    public Cliente getCliente(int id) throws RecepcaoException {
        try {
            return clientes.get(id);
        }
        catch(IndexOutOfBoundsException e) {
            throw new ClienteException(id);
        }
    }

    /**
     * Reserva um quarto do tipo requisitado para um cliente por um determinado número de dias.
     * @param cliente O cliente para o qual será feito a reserva.
     * @param tipoQuarto O tipo do quarto a ser reservado.
     * @param diasHospedado O número de dias da reserva do quarto.
     * @return O preço total do aluguel do quarto.
     * @throws RecepcaoException é lançado caso o cliente não esteja na lista de clientes.
     */
    @Override
    public double alugarQuarto(C cliente, TipoQuarto tipoQuarto, int diasHospedado) throws RecepcaoException {
        this.alugarQuarto(cliente, tipoQuarto);
        return diasHospedado * tipoQuarto.getDiaria();
    }

    /**
     * Reserva um quarto do tipo requisitado para um cliente.
     * O valor da estadia só será calculado quando o cliente der baixa.
     * @param cliente O cliente para o qual será feito a reserva.
     * @param tipoQuarto O tipo do quarto a ser reservado.
     * @throws RecepcaoException é lançado caso o cliente não esteja na lista de clientes.
     * Ou caso nenhum quarto do tipo especificado esteja vago.
     */
    @Override
    public void alugarQuarto(C cliente, TipoQuarto tipoQuarto) throws RecepcaoException {
        Quarto quartoVago = andares.stream()
                .flatMap(andar -> andar.getQuartos().stream())
                .filter(quarto -> quarto.getTipo().equals(tipoQuarto))
                .filter(Quarto::estaVago)
                .findAny()
                .orElseThrow(() -> new ReservaException(tipoQuarto));
        cliente.alugarQuarto(quartoVago);
    }

    /**
     * Dá baixa nos quartos alugados pelo cliente com o id especificado.
     * @param cliente O cliente que dará baixa nos quartos alugados.
     * @return O valor do aluguel pago pelo cliente. O pagamento é a diaria em função dos dias hospedados.
     * @throws RecepcaoException é lançado caso o cliente não esteja na lista de clientes.
     */
    @Override
    public double darBaixa(C cliente) throws RecepcaoException {
        var quartos = cliente.getQuartosAlugados();
        var diaria = quartos.stream()
                .mapToDouble(quarto -> {
                    quarto.atualizarVaga(true);
                    return quarto.getDiaria();
                })
                .sum();

        quartos.clear();

        return diaria * cliente.getDiasHospedado();
    }
}

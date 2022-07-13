package hotel.infraestrutura;

import hotel.gerencia.*;
import hotel.excecoes.*;
import hotel.pessoas.*;

/**
 * Representa um hotel que possui nome, saldo, recepção e recursos humanos.
 */
public class Hotel {
    private String nome;
    private double saldo;
    private Recepcao<Cliente, Andar> recepcao;
    private RecursosHumanos<Pessoa, Funcionario> recursosHumanos;

    /**
     * Constrói um hotel com nome especificado.
     * @param nome O nome do hotel.
     */
    public Hotel(String nome) {
        this.nome = nome;
        this.saldo = 0;
        this.recepcao = FabricaRecepcao.criarRecepcao();
        this.recursosHumanos = FabricaRh.criarRH();
    }

    /**
     * Contrata um funcionário para o hotel.
     * @param nome O nome do funcionário.
     * @param cpf O cpf do funcionário.
     * @param cargo O cargo do funcionário.
     * @throws CpfException é lançado quando o cpf da pessoa é inválido.

     */
    public void contratar(String nome, String cpf, Cargo cargo) throws CpfException {

        recursosHumanos.contratar(new Pessoa(nome, cpf), cargo);
    }

    /**
     * Recupera um funcionário do hotel através de seu id.
     * @param id O id do funcionário.
     * @return O funcionário do hotel que possuir o id especificado.
     * @throws RhException é lançado caso não exista um funcionário no hotel com o id especificado.
     */
    public Funcionario getFuncionario(int id) throws RhException {
        return recursosHumanos.getFuncionario(id);
    }

    /**
     * Aumenta em 10% o salário de um funcionário do hotel.
     * @param funcionario O funcionário do hotel que receberá aumento.
     * @throws RhException é lançado caso o funcionário especificado não seja um funcionário do hotel.
     */
    public void darAumentoPara(Funcionario funcionario) throws RhException {
        recursosHumanos.darAumentoPara(funcionario);
    }

    /**
     * Demite um funcionário do hotel.
     * @param funcionario O funcionário do hotel que será demitido.
     * @throws RhException é lançado caso o funcionário especificado não seja um funcionário do hotel.
     */
    public void demitir(Funcionario funcionario) throws RhException {
        recursosHumanos.demitir(funcionario);
    }

    /**
     * Cadastra um cliente do hotel.
     * @param nome O nome do cliente.
     * @param cpf O cpf do cliente.
     * @throws CpfException é lançado quando o cpf é inválido.
     */
    public void cadastrarCliente(String nome, String cpf) throws CpfException {
        recepcao.cadastrarCliente(new Pessoa(nome, cpf));
    }

    /**
     * Recupera um cliente do hotel através de seu id.
     * @param id O id do cliente.
     * @return O cliente do hotel que possuir o id especificado.
     * @throws RecepcaoException é lançado caso não exista um cliente do hotel com o id especificado.
     */
    public Cliente getCliente(int id) throws RecepcaoException {
        return recepcao.getCliente(id);
    }

    /**
     * Reserva um quarto do tipo requisitado para um cliente do hotel por um determinado número de dias.
     * @param cliente O cliente para o qual será feito a reserva.
     * @param tipoQuarto O tipo do quarto a ser reservado.
     * @param diasHospedado O número de dias da reserva do quarto.
     * @return O preço total do aluguel do quarto.
     * @throws RecepcaoException é lançado caso o cliente especificado não seja um cliente do hotel.
     * Ou caso nenhum quarto do tipo especificado esteja vago.
     */
    public double alugarQuarto(Cliente cliente, TipoQuarto tipoQuarto, int diasHospedado) throws RecepcaoException {
        return recepcao.alugarQuarto(cliente, tipoQuarto, diasHospedado);
    }

    /**
     * Reserva um quarto do tipo requisitado para um cliente do hotel.
     * O valor da estadia só será calculado quando o cliente der baixa.
     * @param cliente O cliente para o qual será feito a reserva.
     * @param tipoQuarto O tipo do quarto a ser reservado.
     * @throws RecepcaoException é lançado caso o cliente especificado não seja um cliente do hotel.
     * Ou caso nenhum quarto do tipo especificado esteja vago.
     */
    public void alugarQuarto(Cliente cliente, TipoQuarto tipoQuarto) throws RecepcaoException {
        recepcao.alugarQuarto(cliente, tipoQuarto);
    }

    /**
     * Dá baixa nos quartos alugados pelo cliente do hotel com o id especificado.
     * @param cliente O cliente que dará baixa nos quartos alugados.
     * @throws RecepcaoException é lançado caso o cliente especificado não seja um cliente do hotel.
     */
    public void darBaixa(Cliente cliente) throws RecepcaoException {
        saldo += recepcao.darBaixa(cliente);
    }
}

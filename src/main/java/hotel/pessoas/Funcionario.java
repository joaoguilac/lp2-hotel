package hotel.pessoas;

import hotel.infraestrutura.Sala;
import hotel.excecoes.CpfException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Representa um funcionário de um hotel.
 */
public class Funcionario extends Pessoa {
    private int id;
    private Cargo cargo;
    private double salario;
    private final LocalDate dataContratacao;
    private Sala sala;

    /**
     * Constrói um funcionário com o nome, cpf, id e cargo especificados.
     * @param nome O nome do funcionário.
     * @param cpf O cpf do funcionário.
     * @param id O id do funcionário.
     * @param cargo O cargo do funcionário.
     * @throws CpfException é lançado caso o cpf passado seja inválido.
     */
    public Funcionario(String nome, String cpf, int id, Cargo cargo) throws CpfException {
        super(nome, cpf);
        this.id = id;
        this.cargo = cargo;
        this.salario = cargo.getSalario();
        this.dataContratacao = LocalDate.now();
        switch (cargo) {
            case RECEPCIONISTA -> this.sala = Sala.RECEPCAO;
            case COZINHEIRO -> this.sala = Sala.COZINHA;
            case CONTADOR -> this.sala = Sala.ALMOXARIFADO;
            case ADMINISTRADOR -> this.sala = Sala.ADMINISTRACAO;
        }
    }

    public int getId(){
        return this.id;
    }

    public Cargo getCargo(){
        return this.cargo;
    }

    public double getSalario(){
        return this.salario;
    }

    public LocalDate getDataContratacao(){
        return this.dataContratacao;
    }

    public Sala getSala(){
        return this.sala;
    }

    /**
     * Calcula o tempo em que o funcionário esteve trabalhando
     * no hotel com base na data de contratação.
     * @return A quantidade de dias que o funcionário ficou empregado no hotel.
     */
    public Long getTempoDeServico(){
        return ChronoUnit.DAYS.between(this.dataContratacao, LocalDate.now());
    }

    /**
     * Aumenta em 10% o salário do funcionário.
     */
    public void darAumento(){
         salario += (salario * 0.10);
    }
}

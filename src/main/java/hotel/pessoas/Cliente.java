package hotel.pessoas;

import hotel.infraestrutura.Quarto;
import hotel.excecoes.CpfException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um cliente de um hotel.
 */
public class Cliente extends Pessoa {
    private int id;
    private List<Quarto> quartosAlugados;
    private LocalDate dataHospedagem;

    /**
     * Constrói um cliente com o nome, cpf e id especificados.
     * @param nome O nome do cliente.
     * @param cpf O cpf do cliente.
     * @param id O id do cliente.
     * @throws CpfException é lançado caso o cpf passado seja inválido.
     */
    public Cliente(String nome, String cpf, int id) throws CpfException {
        super(nome, cpf);
        this.id = id;
        this.quartosAlugados = new ArrayList<>();
        this.dataHospedagem = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public List<Quarto> getQuartosAlugados() {
        return this.quartosAlugados;
    }

    public LocalDate getDataHospedagem() {
        return dataHospedagem;
    }

    /**
     * Calcula o tempo em que o cliente esteve hospedado com base na data de hospedagem.
     * @return A quantidade de dias que o cliente ficou hospedado no hotel.
     */
    public Long getDiasHospedado() {
        return ChronoUnit.DAYS.between(this.dataHospedagem, LocalDate.now());
    }

    /**
     * Aluga um quarto para o cliente.
     * OBS: Presume que o quarto esteja vago.
     * @param quarto O quarto que o cliente irá alugar.
     */
    public void alugarQuarto(Quarto quarto) {
        quarto.atualizarVaga(false);
        quartosAlugados.add(quarto);
        this.dataHospedagem = LocalDate.now();
    }
}

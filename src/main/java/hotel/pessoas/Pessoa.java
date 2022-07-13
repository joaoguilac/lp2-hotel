package hotel.pessoas;

import hotel.excecoes.CpfException;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Representa uma pessoa através do nome e cpf.
 */
public class Pessoa {
    private String nome;
    private String cpf;

    /**
     * Constrói uma pessoa através do nome e cpf especificados.
     * @param nome O nome da pessoa.
     * @param cpf O cpf da pessoa.
     * @throws CpfException é lançado caso o cpf passado seja inválido
     */
    public Pessoa(String nome, String cpf) throws CpfException {
        this.nome = nome;
        this.cpf = cpf;
        validarCPF();
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    /**
     * Checa se o cpf da pessoa é válido.
     * @throws CpfException é lançado caso o cpf seja inválido
     */
    private void validarCPF() throws CpfException {
        if (this.cpf.length() != 11) {
            throw new CpfException(this.cpf);
        }

        // Checa se todos os carcteres de cpf são iguais
        var primeiro = cpf.charAt(0);
        if (this.cpf.chars().allMatch(c -> c == primeiro)) {
            throw new CpfException(this.cpf);
        }

        var cpf = this.cpf.codePoints()
                          .mapToObj(Character::getNumericValue)
                          .collect(Collectors.toList());

        // O método getNumericValue retorna um número negativo caso
        // o caractere não seja um número
        if (cpf.stream().anyMatch(i -> i < 0)) {
            throw new CpfException(this.cpf);
        }

        int verificador1 = cpf.get(9);
        int verificador2 = cpf.get(10);
        int soma = IntStream.rangeClosed(1, 9)
                            .map(i -> cpf.get(i - 1) * i)
                            .sum();
        int div = soma % 11;
        if (div != verificador1 && !(div == 10 && verificador1 == 0)) {
            throw new CpfException(this.cpf);
        }

        soma = IntStream.rangeClosed(1, 9)
                        .map(i -> cpf.get(i) * i)
                        .sum();
        div = soma % 11;

        if (div != verificador2 && !(div == 10 && verificador2 == 0)) {
            throw new CpfException(this.cpf);
        }
    }
}

package hotel.gerencia;

import hotel.excecoes.CpfException;
import hotel.excecoes.RhException;
import hotel.pessoas.Cargo;
import hotel.pessoas.Funcionario;
import hotel.pessoas.Pessoa;

/**
 * Interface responsável por definir o modo de atuação do setor de recursos humanos.
 * @param <T> Tipo genérico para representar uma pessoa.
 * @param <F> Tipo genérico para representar um funcionário.
 */
public interface RecursosHumanos<T extends Pessoa, F extends Funcionario> {
    /**
     * Contrata um funcionário.
     * @param pessoa A pessoa a ser contratada.
     * @param cargo O cargo da pessoa a ser contratada.
     * @throws CpfException é lançado quando o cpf da pessoa é inválido.
     */
    void contratar(T pessoa, Cargo cargo) throws CpfException;


    /**
     * Recupera um funcionário através de seu id.
     * @param id O id do funcionário.
     * @return O funcionário que possuir o id especificado.
     * @throws RhException é lançado caso não exista um funcionário com o id especificado.
     */
    Funcionario getFuncionario(int id) throws RhException;

    /**
     * Aumenta em 10% o salário de um funcionário.
     * @param funcionario O funcionário que receberá aumento.
     * @throws RhException é lançado caso seja um funcionário inválido.
     */
    void darAumentoPara(F funcionario) throws RhException;

    /**
     * Demite um funcionário.
     * @param funcionario O funcionário que será demitido.
     * @throws RhException é lançado caso seja um funcionário inválido.
     */
    void demitir(F funcionario) throws RhException;
}

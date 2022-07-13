package hotel.gerencia;

import hotel.excecoes.CpfException;
import hotel.excecoes.FuncionarioException;
import hotel.excecoes.RhException;
import hotel.pessoas.Cargo;
import hotel.pessoas.Funcionario;
import hotel.pessoas.Pessoa;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa os recursos humanos do hotel.
 * @param <T> Tipo genérico para representar uma pessoa.
 * @param <F> Tipo genérico para representar um funcionário.
 */
public class RhHotel<T extends Pessoa, F extends Funcionario> implements RecursosHumanos<T, F> {
    private List<Funcionario> funcionarios;

    /**
     * Cria uma instância da classe RhHotel.
     */
    public RhHotel() {
        this.funcionarios = new ArrayList<>();
    }

    /**
     * Contrata um funcionário e cadastra na lista de funcionários.
     * @param pessoa A pessoa a ser contratada.
     * @param cargo O cargo da pessoa a ser contratada.
     * @throws CpfException é lançado quando o cpf da pessoa é inválido.

     */
    @Override
    public void contratar(T pessoa, Cargo cargo) throws CpfException {

        var id = funcionarios.size();
        var funcionario = new Funcionario(pessoa.getNome(), pessoa.getCpf(), id, cargo);
        funcionarios.add(funcionario);
    }

    /**
     * Recupera um funcionário da lista através de seu id.
     * @param id O id do funcionário baseado no seu índice na lista.
     * @return O funcionário que possuir o id especificado.
     * @throws RhException é lançado caso não exista um funcionário com o id especificado na lista.
     */
    @Override
    public Funcionario getFuncionario(int id) throws RhException {
        try {
            return funcionarios.get(id);
        }
        catch(IndexOutOfBoundsException e) {
            throw new FuncionarioException(id);
        }
    }

    /**
     * Aumenta em 10% o salário de um funcionário.
     * @param funcionario O funcionário que receberá aumento.
     * @throws RhException é lançado caso o funcionário não esteja na lista de funcionários.
     */
    @Override
    public void darAumentoPara(F funcionario) throws RhException {
        Funcionario funcionarioLista = getFuncionario(funcionario.getId());
        funcionarioLista.darAumento();
    }

    /**
     * Demite um funcionário, removendo-o da lista de funcionários.
     * @param funcionario O funcionário que será demitido.
     * @throws RhException é lançado caso o funcionário não esteja na lista de funcionários.
     */
    @Override
    public void demitir(F funcionario) throws RhException {
        var id = funcionario.getId();
        try {
            funcionarios.remove(id);
        }
        catch (IndexOutOfBoundsException e) {
            throw new FuncionarioException(id);
        }
    }
}

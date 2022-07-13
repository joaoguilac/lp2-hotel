package hotel.gerencia;

import hotel.infraestrutura.Andar;
import hotel.pessoas.Cliente;

/**
 * Fábrica responsável por construir instância válida da interface de Recepcao.
 * @see Recepcao
 */
public class FabricaRecepcao {

    /**
     * Cria instância da interface de Recepcao.
     * @param <C> Tipo genérico para representar um cliente.
     * @param <A> Tipo genérico para representar um andar.
     * @return Instância de uma classe que implementa a interface Recepcao.
     */
    public static <C extends Cliente, A extends Andar> Recepcao<C, A> criarRecepcao() {
        return new RecepcaoHotel<C, A>();
    }
}

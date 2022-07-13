package hotel.infraestrutura;

/**
 * Representa um quarto de um hotel.
 */
public class Quarto {
    private int numero;
    private TipoQuarto tipo;
    private boolean vago;

    /**
     * Constrói um quarto com o número e o tipo especificados.
     * @param numero O número do quarto no andar.
     * @param tipo O tipo de quarto a ser construído.
     */
    public Quarto(int numero, TipoQuarto tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.vago = true;
    }

    public int getNumero() {
        return numero;
    }

    public TipoQuarto getTipo() {
        return tipo;
    }

    /**
     * Retorna se o quarto está vago ou não.
     * @return O valor do atributo vago.
     */
    public boolean estaVago(){
        return vago;
    }

    /**
     * Altera o valor do atributo vago.
     * @param vago O novo valor para o atributo vago.
     */
    public void atualizarVaga(boolean vago) {
        this.vago = vago;
    }

    /**
     * Retorna a diaria do quarto.
     * @return A diaria do hotel baseada no tipo.
     */
    public double getDiaria() {
        return tipo.getDiaria();
    }
}


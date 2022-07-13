package hotel.infraestrutura;

import java.util.List;

/**
 * Representa um andar de um hotel.
 */
public class Andar {
    private int numero;
    private List<Quarto> quartos;

    /**
     * Constrói um andar com o número e quartos especificados.
     * @param numero O número do andar no hotel.
     * @param quartos A lista de quartos do andar.
     */
    public Andar(int numero, List<Quarto> quartos) {
        this.numero = numero;
        this.quartos = quartos;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public int getNum() {
        return numero;
    }
}


package hotel.infraestrutura;

/**
 * Representa os tipos de quarto de um hotel.
 */
public enum TipoQuarto {
    SIMPLES(100), CASAL(150), LUXUOSO(300), PRESIDENCIAL(500);

    private double diaria;

    /**
     * Constrói um tipo de quarto com base no valor da diária.
     * @param diaria A diaria referente ao tipo de quarto.
     */
    TipoQuarto(double diaria) {
        this.diaria = diaria;
    }

    public double getDiaria() {
        return diaria;
    }
}

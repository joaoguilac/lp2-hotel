package hotel.pessoas;

/**
 * Representa os possíveis cargos do funcionário de um hotel.
 */
public enum Cargo {
    RECEPCIONISTA(1200.0),
    COZINHEIRO(1500.0),
    CONTADOR(1700.0),
    ADMINISTRADOR(2000.0);

    private double salario;

    /**
     * Constrói um cargo baseado no valor do salário.
     * @param salario O salário referente ao cargo.
     */
    Cargo(Double salario) {
        this.salario = salario;
    }

    double getSalario() {
        return this.salario;
    }
}
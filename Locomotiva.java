import java.io.Serializable;

public class Locomotiva extends Vagao implements Serializable {
    private double potencia;

    public Locomotiva(double comprimento, double peso, double potencia) {
        super(comprimento, peso);
        this.potencia = potencia;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    @Override
    public String imprime() {
        return "Locomotiva: comprimento = " + getComprimento() + ", peso = " + getPeso() + ", potência = " + potencia;
    }
    
}

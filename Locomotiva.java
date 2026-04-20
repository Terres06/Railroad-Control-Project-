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
    public void imprime() {
        super.imprime(); 
        System.out.println("Tipo: Locomotiva. Potência: " + potencia + " HP.");
    }

    @Override
    public void setComprimento(double comprimento){
        if (comprimento <= 23 && comprimento >= 18){
            super.setComprimento(comprimento);
        } else {
            System.out.println("Comprimento inválido para locomotiva. Deve ser entre 18 e 23 metros.");
        }
    }

    @Override 
    public void setPeso(double peso){
        if (peso <= 200 && peso >= 100){
            super.setPeso(peso);
        } else {
            System.out.println("Peso inválido para locomotiva. Deve ser entre 100 e 200 toneladas.");
        }
    }
}

import java.io.Serializable;

public class Carga extends Vagao implements Serializable {
    private double capacidadeCarga;

    public Carga(double comprimento, double peso, double capacidadeCarga) {
        super(comprimento, peso);
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public void imprime() {
        super.imprime();
        System.out.println("Tipo: Carga. Capacidade de carga = " + capacidadeCarga);
    }

    @Override 
    public void setComprimento(double comprimento){
        if (comprimento >= 12 && comprimento <= 19){
            super.setComprimento(comprimento);
        } else {
            System.out.println("Comprimento inválido para vagão de carga. Deve ser entre 12 e 19 metros.");
        }
    }

    @Override
    public void setPeso(double peso){
        if (peso <= 30 && peso >= 15){
            super.setPeso(peso);
        } else {
            System.out.println("Peso inválido para vagão de carga. Deve ser entre 15 e 30 toneladas.");
        }
    }
    
}

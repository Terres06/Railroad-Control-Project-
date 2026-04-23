import java.io.Serializable;

public class Carga extends Vagao implements Serializable {
    public Carga(double comprimento, double peso) {
        super(0, 0);
        setComprimento(comprimento);
        setPeso(peso);
    }

    public double getCarga() {
        return getPeso() * 0.75;
    }

    @Override
    public void imprime() {
        System.out.println("Tipo: Carga. Carga = " + getCarga());
        super.imprime();
    }

    @Override 
    public void setComprimento(double comprimento){
        if (comprimento >= 12 && comprimento <= 19){
            super.setComprimento(comprimento);
        } else {
            throw new IllegalArgumentException("Comprimento inválido para vagão de carga. Deve ser entre 12 e 19 metros.");
        }
    }

    @Override
    public void setPeso(double peso){
        if (peso <= 30 && peso >= 15){
            super.setPeso(peso);
        } else {
            throw new IllegalArgumentException("Peso inválido para vagão de carga. Deve ser entre 15 e 30 toneladas.");
        }
    }
    
}

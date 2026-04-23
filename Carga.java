import java.io.Serializable;

public class Carga extends Vagao implements Serializable {
    private double capacidadeCarga;

    public Carga(double comprimento, double peso, double capacidadeCarga) {
        super(0, 0);
        setComprimento(comprimento);
        setPeso(peso);
        setCapacidadeCarga(capacidadeCarga);
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) 
    {
        if(capacidadeCarga >= 11.25 && capacidadeCarga <= 22.5) 
        {
            this.capacidadeCarga = capacidadeCarga;
        } 
        else
        {
            throw new IllegalArgumentException("Capacidade de carga inválida. Deve ser entre 11.25 e 22.5 toneladas");
        }
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

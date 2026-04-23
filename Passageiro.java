import java.io.Serializable;

public class Passageiro extends Vagao implements Serializable {
    private int numeroPassageiros;

    public Passageiro(double comprimento, double peso, int numeroPassageiros) {
        super(0, 0);
        setComprimento(comprimento);
        setPeso(peso);
        setNumeroPassageiros(numeroPassageiros);
    }

    public int getNumeroPassageiros() {
        return numeroPassageiros;
    }

    public void setNumeroPassageiros(int numeroPassageiros) 
    {
        if(numeroPassageiros >= 0 && numeroPassageiros <= 50)
        {
            this.numeroPassageiros = numeroPassageiros;
        } 
        else 
        {
            throw new IllegalArgumentException("Número de passageiros inválido. Deve ser entre 0 e 50");
        }
    }

    @Override
    public void imprime() {
        System.out.println("Número de passageiros = " + numeroPassageiros);
        super.imprime();
    }    

    @Override
    public void setComprimento(double comprimento){
        if (comprimento <= 26 && comprimento >= 22){
            super.setComprimento(comprimento);
        } else {
            throw new IllegalArgumentException("Comprimento inválido para vagão de passageiros. Deve ser entre 22 e 26 metros.");
        }
    }

    @Override 
    public void setPeso(double peso){
        if (peso <= 50 && peso >= 30){
            super.setPeso(peso);
        } else {
            throw new IllegalArgumentException("Peso inválido para vagão de passageiros. Deve ser entre 30 e 50 toneladas.");
        }
    }
}

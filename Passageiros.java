import java.io.Serializable;

public class Passageiros extends Vagao implements Serializable {
    private int numeroPassageiros;

    public Passageiros(double comprimento, double peso, int numeroPassageiros) {
        super(comprimento, peso);
        this.numeroPassageiros = numeroPassageiros;
    }

    public int getNumeroPassageiros() {
        return numeroPassageiros;
    }

    public void setNumeroPassageiros(int numeroPassageiros) {
        this.numeroPassageiros = numeroPassageiros;
    }

    @Override
    public String imprime() {
        return "Vagão de Passageiros: comprimento = " + getComprimento() + ", peso = " + getPeso() + ", número de passageiros = " + numeroPassageiros;
    }    

    @Override
    public void setComprimento(double comprimento){
        if (comprimento <= 26 && comprimento >= 22){
            super.setComprimento(comprimento);
        } else {
            System.out.println("Comprimento inválido para vagão de passageiros. Deve ser entre 22 e 26 metros.");
        }
    }

    @Override 
    public void setPeso(double peso){
        if (peso <= 50 && peso >= 30){
            super.setPeso(peso);
        } else {
            System.out.println("Peso inválido para vagão de passageiros. Deve ser entre 30 e 50 toneladas.");
        }
    }
}

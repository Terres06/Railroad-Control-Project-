public class Passageiros extends Vagao {
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
}

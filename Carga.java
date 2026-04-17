public class Carga extends Vagao {
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
    public String imprime() {
        return "Vagão de Carga: comprimento = " + getComprimento() + ", peso = " + getPeso() + ", capacidade de carga = " + capacidadeCarga;
    }
    
}

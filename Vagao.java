public class Vagao {
    private double comprimento;
    private double peso;

    public Vagao(double comprimento, double peso){
        this.comprimento = comprimento;
        this.peso = peso;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public String imprime(){
        return "Vagão: comprimento = " + comprimento + ", peso = " + peso;
    }

}

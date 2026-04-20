
import java.io.Serializable;
public class Vagao implements Serializable {
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
    
    public void imprime(){
        System.out.println("Vagão: comprimento = " + comprimento + ", peso = " + peso);
    }

    @Override
    public String toString() {
        return "Vagão: comprimento = " + comprimento + ", peso = " + peso;
    }

}

import java.io.Serializable;

public class Locomotiva extends Vagao implements Serializable {
    private double potencia;

    public Locomotiva(double comprimento, double peso, double potencia) {
        super(0, 0);
        setComprimento(comprimento);
        setPeso(peso);
        setPotencia(potencia);
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        if(potencia >= 2000 && potencia <= 6000)
        {
            this.potencia = potencia;
        }
        else
        {
            throw new IllegalArgumentException("Potência inválida. Deve ser entre 2000 e 6000 HP");
        }
    }


    @Override
    public void imprime() 
    {
        super.imprime();
        System.out.println("Tipo: Locomotiva. Potência: " + potencia + " HP.");
    }
}


import java.io.Serializable;

public class ComposicaoFerroviaria extends Deque implements Serializable {
    private ObjetoPersistente arq;

    public ComposicaoFerroviaria(int N, String nomeArquivo) {
        super(N);
        arq = new ObjetoPersistente(nomeArquivo);
        carregar();
    }

    private void salvar() {
        arq.salvar(this);
    }

    private void carregar() {
        ComposicaoFerroviaria cf = (ComposicaoFerroviaria) arq.carregar();
        if (cf != null) {
            this.front = cf.front;
            this.rear = cf.rear;
            this.ptr = cf.ptr;
            this.size = cf.size;
            this.N = cf.N;
            this.data = cf.data;
        }
    }

    public void inserirInicio(Vagao v){
        addFirst(v);
        salvar();
    }

    public void inserirFim(Vagao v){
        addLast(v);
        salvar();
    }

    public void removerInicio(){
        deleteFirst();
        salvar();
    }

    public void removerFim(){
        deleteLast();
        salvar();
    }

    public double calcularPesoTotal(){
        double pesoTotal = 0;
        rewind();
        for (int i = 0; i < size; i++){
            Vagao v = (Vagao) next();
            pesoTotal += v.getPeso();
        }
        return pesoTotal;
    }

    public double calcularCargaTotal(){
        double cargaTotal = 0;
        rewind();
        for (int i = 0; i < size; i++){
            Object obj = next();
            if (obj instanceof Carga){
                Carga c = (Carga) obj;
                cargaTotal += c.getCarga();
            }
        }
        return cargaTotal;
    }

    public int contarVagoesLocomotivas()
    {
        int qnt = 0;
        rewind();
        for (int i = 0; i < size; i++) 
        {
            Object obj = next();
            if (obj instanceof Locomotiva)
            {
                qnt++;
            }
        }
        return qnt;
    }

    public int contarVagoesPassageiros()
    {
        int qnt = 0;
        rewind();
        for (int i = 0; i < size; i++) {
            Object obj = next();
            if (obj instanceof Passageiro) 
            {
                qnt++;
            }
        }
        return qnt;
    }

    public int contarVagoesCarga()
    {
        int qnt = 0;
        rewind();
        for (int i = 0; i < size; i++) 
        {
            Object obj = next();
            if (obj instanceof Carga) 
            {
                qnt++;
            }
        }
        return qnt;
    }

    public void criarComposicaoPadrao() {
        while (!isEmpty()) {
            deleteLast();
        }

        addLast(new Locomotiva(20, 150, 2500));

        for (int i = 0; i < 50; i++) {
            addLast(new Passageiro(24, 40, 30));
        }

        for (int i = 0; i < 30; i++) {
            addLast(new Carga(17, 20));
        }

        salvar();
    }
    public double comprimentoTotal()
    {
        double comprimentoTotal = 0;
        rewind();

        for(int i = 0; i < getSize(); i++)
        {
            Vagao v = (Vagao) next();
            comprimentoTotal += v.getComprimento();
        }

        if(getSize() > 1)
        {
            comprimentoTotal += (getSize() - 1)*2;
        }
        return comprimentoTotal;
    }
    public double calcularPotenciaTotal() {
        double potenciaTotal = 0;
        rewind();
        for (int i = 0; i < getSize(); i++) {
            Object obj = next();
            if (obj instanceof Locomotiva) {
                Locomotiva l = (Locomotiva) obj;
                potenciaTotal += l.getPotencia();
            }
        }
        return potenciaTotal;
    }

    public double calcularHpTon() {
        double pesoTotal = calcularPesoTotal();
        if (pesoTotal == 0)
            return 0;
        double potenciaTotal = calcularPotenciaTotal();
        return potenciaTotal / pesoTotal;
    }
    
    public void verificarPotencia() {
        double pesoTotal = calcularPesoTotal();
        double potenciaTotal = calcularPotenciaTotal();

        if (pesoTotal == 0) {
            System.out.println("Composição vazia.");
            return;
        }

        double hpt = potenciaTotal / pesoTotal;

        System.out.printf("HPT atual: %.2f HP/Ton\n", hpt);

        if (hpt >= 1.05) {
            System.out.println("Potência suficiente.");
        } else {
            System.out.println("Potência insuficiente.");

            double potenciaNecessaria = pesoTotal * 1.05;
            double falta = potenciaNecessaria - potenciaTotal;

            System.out.printf("Falta %.2f HP para atingir o mínimo.\n", falta);

            double potenciaPorLoco = getPotenciaPrimeiraLocomotiva();

            if (potenciaPorLoco == 0) {
                System.out.println("Não há locomotivas na composição para cálculo.");
                return;
            }

            int qtd = (int)(falta / potenciaPorLoco);

            if (falta > qtd * potenciaPorLoco) {
                qtd++;
            }

            System.out.println("Sugestão: adicionar " + qtd + " locomotiva(s).");
        }
    }

    private double getPotenciaPrimeiraLocomotiva() {
        rewind();

        for (int i = 0; i < getSize(); i++) {
            Object obj = next();

            if (obj instanceof Locomotiva) {
                Locomotiva l = (Locomotiva) obj;
                return l.getPotencia();
            }
        }

        return 0;
    }

    public int totalPassageiros()
    {
        int totalPassageiros = 0;

        rewind();
        for(int i = 0; i < size; i++)
        {
            Object obj = next();
            if(obj instanceof Passageiro)
            {
                Passageiro p = (Passageiro) obj;
                totalPassageiros += p.getNumeroPassageiros();
            }
        }
        return totalPassageiros;
    }

    public void diagnostico() 
    {
        System.out.println("=== DIAGNÓSTICO DA COMPOSIÇÃO ===");

        //Req 4 - quantidade por tipo
        System.out.println("\n--- Vagões ---");
        System.out.println("Total de vagões: " + getSize());
        System.out.println("Locomotivas: " + contarVagoesLocomotivas());
        System.out.println("Vagões de passageiros: " + contarVagoesPassageiros());
        System.out.println("Vagões de carga: " + contarVagoesCarga());

        //Req 5 - comprimento e peso total
        System.out.println("\n--- Comprimento e Peso ---");
        System.out.printf("Comprimento total: %.2f m%n", comprimentoTotal());
        System.out.printf("Peso total: %.2f ton%n", calcularPesoTotal());

        //Req 6 - passageiros e carga
        System.out.println("\n--- Passageiros e Carga ---");
        System.out.println("Total de passageiros: " + totalPassageiros());
        System.out.printf("Total de carga: %.2f ton%n", calcularCargaTotal());

        //Req 7 - verificação de potência
        System.out.println("\n--- Potência ---");
        verificarPotencia();

        System.out.println("=================================");
    }
}

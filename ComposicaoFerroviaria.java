
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
            if (obj instanceof Carga c){
                cargaTotal += c.getPeso() * 0.75;
            }
        }
        return cargaTotal;
    }

    public void quantidadeTipoVagao()
    {
        int qntLocomotiva = 0;
        int qntVagoesPassageiros = 0;
        int qntCarga = 0;

        rewind();
        for(int i = 0; i < size; i++)
        {
            Object obj = next();
            if(obj instanceof Locomotiva l)
            {
                qntLocomotiva++;
            }
            else if(obj instanceof Passageiros p)
            {
                qntVagoesPassageiros++;
            }
            else if(obj instanceof Carga c)
            {
                qntCarga++;
            }
        }

        System.out.println("Quantidade de locomotivas: "+qntLocomotiva);
        System.out.println("Quantidade de vagoes de passageiros: "+qntVagoesPassageiros);
        System.out.println("Quantidade de vagoes de carga: "+qntCarga);
    }

    public void criarComposicaoPadrao() {
        while (!isEmpty()) {
            deleteFirst();
        }

        addLast(new Locomotiva(20, 150, 4000));
        addLast(new Passageiros(24, 40, 80));
        addLast(new Passageiros(24, 42, 72));
        addLast(new Carga(15, 28, 21));
        addLast(new Carga(15, 30, 22.5));

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
            if (obj instanceof Locomotiva l) {
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

            // 🔥 cálculo SEM Math.ceil
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

            if (obj instanceof Locomotiva l) {
                return l.getPotencia();
            }
        }

        return 0;
    }
}


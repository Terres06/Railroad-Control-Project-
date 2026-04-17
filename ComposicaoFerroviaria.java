
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
}

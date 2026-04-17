public class Main {
    public static void main(String[] args) {

        // Cria composição
        ComposicaoFerroviaria cf = new ComposicaoFerroviaria(100, "composicao.dat");

        System.out.println("=== TESTE CASO 1: Criar composição padrão ===");

        System.out.println("Composição após criação:");
        System.out.println(cf.toString()); // usa o toString do Deque

        System.out.println("\n=== TESTE CASO 2: Inserir vagões ===");

        // Inserindo uma locomotiva no início
        Locomotiva loco = new Locomotiva(20, 150, 4000);
        cf.inserirInicio(loco);

        System.out.println("Composição após inserções:");
        System.out.println(cf.toString());

        System.out.println("\nPrimeiro vagão:");
        Vagao primeiro = (Vagao) cf.peekFront();
        if (primeiro != null) primeiro.imprime();

        System.out.println("\nÚltimo vagão:");
        Vagao ultimo = (Vagao) cf.peekRear();
        if (ultimo != null) ultimo.imprime();
    }
}
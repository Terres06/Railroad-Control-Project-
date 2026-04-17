import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComposicaoFerroviaria cf = new ComposicaoFerroviaria(100, "composicao.dat");

        char opcao = ' ';

        while (opcao != 'g') {
            System.out.println("\n=== MENU ===");
            System.out.println("a - Criar composição padrão");
            System.out.println("b - Inserir vagão");
            System.out.println("c - Remover vagão");
            System.out.println("d - Diagnóstico");
            System.out.println("e - Dados do primeiro vagão");
            System.out.println("f - Dados do último vagão");
            System.out.println("g - Sair");
            System.out.print("Opção: ");

            opcao = sc.next().charAt(0);

            switch (opcao) {
                case 'a' -> cf.criarComposicaoPadrao();

                case 'b' -> {
                    System.out.println("Posição: (i)nício ou (f)im?");
                    char pos = sc.next().charAt(0);

                    System.out.println("Tipo: (l)ocomotiva, (p)assageiros ou (c)arga?");
                    char tipo = sc.next().charAt(0);

                    System.out.print("Comprimento (m): ");
                    double comp = sc.nextDouble();
                    System.out.print("Peso (ton): ");
                    double peso = sc.nextDouble();

                    Vagao v = null;

                    switch (tipo) {
                        case 'l' -> {
                            System.out.print("Potência (HP): ");
                            double pot = sc.nextDouble();
                            v = new Locomotiva(comp, peso, pot);
                        }
                        case 'p' -> {
                            System.out.print("Número de passageiros: ");
                            int pass = sc.nextInt();
                            v = new Passageiros(comp, peso, pass);
                        }
                        case 'c' -> {
                            System.out.print("Capacidade de carga (ton): ");
                            double carga = sc.nextDouble();
                            v = new Carga(comp, peso, carga);
                        }
                        default -> System.out.println("Tipo inválido.");
                    }

                    if (v != null) {
                        if (pos == 'i') cf.inserirInicio(v);
                        else if (pos == 'f') cf.inserirFim(v);
                        else System.out.println("Posição inválida.");
                    }
                }

                case 'c' -> {
                    System.out.println("Remover do (i)nício ou (f)im?");
                    char pos = sc.next().charAt(0);
                    if (pos == 'i') cf.removerInicio();
                    else if (pos == 'f') cf.removerFim();
                    else System.out.println("Posição inválida.");
                }

                case 'd' -> cf.diagnostico();

                case 'e' -> {
                    Vagao v = (Vagao) cf.peekFront();
                    if (v != null) System.out.println(v.imprime());
                    else System.out.println("Composição vazia.");
                }

                case 'f' -> {
                    Vagao v = (Vagao) cf.peekRear();
                    if (v != null) System.out.println(v.imprime());
                    else System.out.println("Composição vazia.");
                }

                case 'g' -> System.out.println("Encerrando...");

                default -> System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
import java.util.Scanner;

public class ProgramaFerrovia {
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
                case 'a':
                    cf.criarComposicaoPadrao();
                    break;

                case 'b': {
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
                        case 'l':
                            System.out.print("Potência (HP): ");
                            double pot = sc.nextDouble();
                            v = new Locomotiva(comp, peso, pot);
                            break;
                        case 'p':
                            System.out.print("Número de passageiros: ");
                            int pass = sc.nextInt();
                            v = new Passageiro(comp, peso, pass);
                            break;
                        case 'c':
                            System.out.print("Capacidade de carga (ton): ");
                            double carga = sc.nextDouble();
                            v = new Carga(comp, peso, carga);
                            break;
                        default:
                            System.out.println("Tipo inválido.");
                            break;
                    }

                    if (v != null) {
                        if (pos == 'i') cf.inserirInicio(v);
                        else if (pos == 'f') cf.inserirFim(v);
                        else System.out.println("Posição inválida.");
                    }
                    break;
                }

                case 'c': {
                    System.out.println("Remover do (i)nício ou (f)im?");
                    char pos = sc.next().charAt(0);
                    if (pos == 'i') cf.removerInicio();
                    else if (pos == 'f') cf.removerFim();
                    else System.out.println("Posição inválida.");
                    break;
                }

                case 'd':
                    cf.diagnostico();
                    break;

                case 'e': {
                    Vagao v = (Vagao) cf.peekFront();
                    if (v != null) v.imprime();
                    else System.out.println("Composição vazia.");
                    break;
                }

                case 'f': {
                    Vagao v = (Vagao) cf.peekRear();
                    if (v != null) v.imprime();
                    else System.out.println("Composição vazia.");
                    break;
                }

                case 'g':
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        sc.close();
    }
}
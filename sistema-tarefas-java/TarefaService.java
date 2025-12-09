import java.util.Scanner;

public class TarefaService {
    private TarefaRepository repository = new TarefaRepository();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n=== Sistema de Tarefas ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Editar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> editar();
                case 4 -> excluir();
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrar() {
        System.out.print("Descrição: ");
        String desc = sc.nextLine();
        repository.salvar(desc);
        System.out.println("Tarefa cadastrada!");
    }

    private void listar() {
        System.out.println("\n--- Tarefas ---");
        for (Tarefa t : repository.listar()) {
            System.out.println(t);
        }
    }

    private void editar() {
        listar();
        System.out.print("ID para editar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Tarefa t = repository.buscarPorId(id);
        if (t == null) {
            System.out.println("ID não encontrado!");
            return;
        }

        System.out.print("Nova descrição: ");
        t.setDescricao(sc.nextLine());
        System.out.println("Tarefa atualizada!");
    }

    private void excluir() {
        listar();
        System.out.print("ID para excluir: ");
        int id = sc.nextInt();
        sc.nextLine();

        repository.remover(id);
        System.out.println("Tarefa removida!");
    }
}
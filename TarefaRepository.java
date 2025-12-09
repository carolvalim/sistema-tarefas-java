import java.util.ArrayList;
import java.util.List;

public class TarefaRepository {
    private List<Tarefa> tarefas = new ArrayList<>();
    private int contadorId = 1;

    public void salvar(String descricao) {
        tarefas.add(new Tarefa(contadorId++, descricao));
    }

    public List<Tarefa> listar() {
        return tarefas;
    }

    public Tarefa buscarPorId(int id) {
        return tarefas.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void remover(int id) {
        tarefas.removeIf(t -> t.getId() == id);
    }
}
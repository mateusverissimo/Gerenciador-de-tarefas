import javax.swing.*;
import java.util.ArrayList;


public class DesafioSemana04 {
    public static void main(String[] args) {
        String[] opcoes = {"Adicionar tarefa", "Visualizar tarefas", "Sair"};
        String[] opcoesVisualizar = {"Deletar tarefa", "Sair"};
        ArrayList<String> listaTarefas = new ArrayList<String>();
        boolean appAberto = true;
        do {
            int gerenciadorTarefas = JOptionPane.showOptionDialog(
                    null,
                    "O que você deseja fazer na sua lista de tarefas?",
                    "Gerenciador de tarefas",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    3
            );

            switch (gerenciadorTarefas) {
                case 0:
                    String novaTarefa = JOptionPane.showInputDialog("Digite uma nova tarefa: ");
                    listaTarefas.add(novaTarefa + "\n");
                    break;
                case 1:
                    int visualizarTarefas = JOptionPane.showOptionDialog(
                            null,
                            listaTarefas,
                            "Lista de tarefas",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            opcoesVisualizar,
                            2
                    );
                    switch (visualizarTarefas)  {
                        case 0:
                            String deletar = JOptionPane.showInputDialog("Escolha o índice da tarefa que você deseja deletar");
                            if (deletar == null) {
                                break;
                            }
                            int del = Integer.parseInt(deletar) - 1;
                            listaTarefas.remove(del);
                        default:
                            break;
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,"Finalizando programa!");
                    appAberto = false;
                    break;

            }
        } while (appAberto);
    }
}
import javax.swing.*;
import java.util.ArrayList;


public class DesafioSemana04 {
    public static void main(String[] args) {
        String[] opcoes = {"Adicionar tarefa", "Visualizar tarefas", "Sair"};
        String[] opcoesVisualizar = {"Deletar tarefa", "Voltar"};
        ArrayList<String> listaTarefas = new ArrayList<>();
        boolean appAberto = true;
        int listaTamanho = 0;
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
                    if (novaTarefa == null) {
                        break;
                    }
                    if (!novaTarefa.trim().isEmpty()) {
                        listaTarefas.add(novaTarefa + "\n");
                        ++listaTamanho;
                    } else {
                        JOptionPane.showMessageDialog(null,"Você não digitou nada!");
                    }
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Aqui você pode visualizar a sua lista de tarefas");
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
                    if (visualizarTarefas == 0) {
                        if (listaTamanho >= 1) {
                            String deletar = JOptionPane.showInputDialog("Escolha o índice da tarefa que você deseja deletar");
                            if (deletar == null) {
                                break;
                            } else if (deletar.trim().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Você não digitou nada!");
                                break;
                            } else {
                                int del = Integer.parseInt(deletar) - 1;
                                listaTarefas.remove(del);
                                --listaTamanho;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Não há tarefas na lista!");
                            break;
                        }
                    } else {
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
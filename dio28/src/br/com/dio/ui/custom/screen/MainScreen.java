package br.com.dio.ui.custom.screen;

import br.com.dio.service.BoardService;
import br.com.dio.ui.custom.button.ResetButton;
import br.com.dio.ui.custom.frame.MainFrame;
import br.com.dio.ui.custom.panel.MainPanel;
import br.com.dio.ui.custom.button.*;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MainScreen {
    private final static Dimension dimension = new Dimension(600, 600);

    private final BoardService boardService;

    private JButton finishGameButton;
    private JButton checkGameStatusButton;
    private JButton resetButton;

    public MainScreen(final Map<String, String> gameConfig) {
        this.boardService = new BoardService(gameConfig);
    }

    public void buildMainScreen() {
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);
        addResetButton(mainPanel);
        addCheckGameStatusButton(mainPanel);
        addFinishGameButton(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();

    }

    private void addFinishGameButton(final JPanel mainPanel) {
       finishGameButton = new FinishGameButton(e -> {
            if(boardService.gameIsFinished()) {
                JOptionPane.showMessageDialog(null, "Parabéns! Você concluiu o jogo!!!");
                resetButton.setEnabled(false);
                finishGameButton.setEnabled(false);
                checkGameStatusButton.setEnabled(false);
            }
            else {
                var message = "Seu jogo ainda não está totalmente completo!";
                JOptionPane.showMessageDialog(null, message );
            }
        });
    }

    private void addCheckGameStatusButton(final JPanel mainPanel) {
        checkGameStatusButton = new CheckGameStatusButoon(e ->{
            var hasErros = boardService.hasErrros();
            var gameStatus = boardService.getStatus();
            var message = switch (gameStatus) {
                case NON_STARTED -> "O jogo ainda não foi iniciado!";
                case IMCOMPLETE -> "O jogo está incompleto!";
                case COMPLETE -> "O jogo está completo!";
            };
            message += hasErros ? "e contém erros" : "e não contém erros";
            JOptionPane.showMessageDialog(null, message);
        });
        mainPanel.add(finishGameButton);
    }

    private void addResetButton(final JPanel mainPanel) {
      resetButton = new ResetButton(e ->{
            var dialogResult = JOptionPane.showConfirmDialog(
                    null,
                    "Tem certeza que deseja reiniciar o jogo?",
                    "Limpar o jogo",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if(dialogResult == 0) {
                boardService.reset();
            }
        });
        mainPanel.add(finishGameButton);
    }

}

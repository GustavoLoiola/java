package br.com.dio.ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CheckGameStatusButoon extends JButton {

    public CheckGameStatusButoon(final ActionListener actionListener) {
        this.setText("verificar jogo");
        this.addActionListener(actionListener);
    }
}

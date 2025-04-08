package org.example.panels;

import org.example.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner;
    JButton newGameButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Number of dots:");
        spinner = new JSpinner(new SpinnerNumberModel(7, 2, 100, 1));
        newGameButton = new JButton("New Game");

        newGameButton.addActionListener(this::startNewGame);

        add(label);
        add(spinner);
        add(newGameButton);
    }

    private void startNewGame(ActionEvent e) {
        int count = (int) spinner.getValue();
        frame.getCanvas().createDots(count);
        frame.getCanvas().repaint();
    }
}

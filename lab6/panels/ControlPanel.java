package org.example.panels;

import org.example.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    JButton exportBtn = new JButton("Export PNG");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(exportBtn);
        add(exitBtn);

        exitBtn.addActionListener(this::dispose);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        exportBtn.addActionListener(this::export);
    }

    private void save(ActionEvent e) {
        frame.getCanvas().saveGame();
    }

    private void export(ActionEvent e) {
        frame.getCanvas().exportImage();
    }

    private void dispose(ActionEvent e) {
        frame.dispose();
    }

    private void load(ActionEvent e) {
        frame.getCanvas().loadGame();
    }

}

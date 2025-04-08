package org.example;

import org.example.panels.ConfigPanel;
import org.example.panels.ControlPanel;
import org.example.panels.DrawingPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("Dot Connection Game");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }
}

package org.example.panels;

import org.example.MainFrame;
import org.example.geom.Dot;
import org.example.geom.Line;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    int canvasWidth = 600, canvasHeight = 600;
    int dotRadius = 8;

    List<Dot> dots = new ArrayList<>();
    List<Line> lines = new ArrayList<>();
    boolean playerTurn = true;
    Dot selectedDot = null;
    Graph<Dot, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        initMouse();
    }

    private void initMouse() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Dot clickedDot = findDot(e.getPoint());
                if (clickedDot == null) return;

                if (selectedDot == null) {
                    // 1st dot
                    selectedDot = clickedDot;
                } else {
                    // 2nd dot
                    if (!clickedDot.equals(selectedDot)) {
                        Line newLine = new Line(selectedDot, clickedDot, playerTurn ? Color.BLUE : Color.RED);
                        if (!lines.contains(newLine)) {
                            lines.add(newLine);
                            playerTurn = !playerTurn;
                        }
                    }
                    selectedDot = null;
                    repaint();
                }
            }
        });
    }

    public void createDots(int count) {
        Random rand = new Random();
        dots.clear();
        lines.clear();
        graph = new SimpleGraph<>(DefaultEdge.class);

        for (int i = 0; i < count; i++) {
            int x = rand.nextInt(canvasWidth - 40) + 20;
            int y = rand.nextInt(canvasHeight - 40) + 20;
            Dot dot = new Dot(x, y);
            dots.add(dot);
            graph.addVertex(dot);
        }

        for (int i = 0; i < dots.size(); i++) {
            for (int j = i + 1; j < dots.size(); j++) {
                Dot dot1 = dots.get(i);
                Dot dot2 = dots.get(j);
                graph.addEdge(dot1, dot2);
            }
        }
        repaint();
    }


    private Dot findDot(Point p) {
        for (Dot dot : dots) {
            if (dot.contains(p, dotRadius + 5)) return dot;
        }
        return null;
    }

    // repaint
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAll((Graphics2D) g);
    }

    private void drawAll(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, canvasWidth, canvasHeight);

        for (Line l : lines) {
            g2d.setColor(l.color);
            g2d.drawLine(l.d1.x, l.d1.y, l.d2.x, l.d2.y);
        }

        g2d.setColor(Color.BLACK);
        for (Dot d : dots) {
            g2d.fillOval(d.x - dotRadius, d.y - dotRadius, dotRadius * 2, dotRadius * 2);
        }

        drawScore(g2d);
    }

    private void drawScore(Graphics2D g2d) {
        double blueScore = lines.stream().filter(l -> l.color == Color.BLUE).mapToDouble(Line::length).sum();
        double redScore = lines.stream().filter(l -> l.color == Color.RED).mapToDouble(Line::length).sum();
        double bestScore = computeMinimumSpanningTree();

        g2d.setColor(Color.BLACK);
        g2d.drawString("Blue Score: " + String.format("%.2f", blueScore), 10, 20);
        g2d.drawString("Red Score: " + String.format("%.2f", redScore), 10, 35);
        g2d.drawString("Best Score (MST): " + String.format("%.2f", bestScore), 10, 50);
    }

    private double computeMinimumSpanningTree() {
        if (dots.size() <= 1) return 0;

        PrimMinimumSpanningTree<Dot, DefaultEdge> mst = new PrimMinimumSpanningTree<>(graph);
        Set<DefaultEdge> edges = mst.getSpanningTree().getEdges();

        double totalWeight = 0;
        for (DefaultEdge edge : edges) {
            Dot source = graph.getEdgeSource(edge);
            Dot target = graph.getEdgeTarget(edge);
            totalWeight += source.distanceTo(target);
        }

        return totalWeight;
    }

    public void saveGame() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("game.save"))) {
            out.writeObject(dots);
            out.writeObject(lines);
            out.writeBoolean(playerTurn);
        } catch (IOException e) {
            System.out.println("save err");
        }
    }

    @SuppressWarnings("unchecked")
    public void loadGame() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("game.save"))) {
            dots = (List<Dot>) in.readObject();
            lines = (List<Line>) in.readObject();
            playerTurn = in.readBoolean();
            repaint();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("load err");
        }
    }

    public void exportImage() {
        BufferedImage img = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        drawAll(g2d);
        try {
            ImageIO.write(img, "png", new File("game_board.png"));
        } catch (IOException e) {
            System.out.println("export err");
        }
    }
}

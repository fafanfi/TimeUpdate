package com.f3.time;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private JLabel time;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 80;

    public Window(){
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setResizable(false);
        this.setLocationRelativeTo(null); // menampilkan frame di tengah layar
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setOpaque(true); // opaque != transparent (set true agar panel tampil konsisten di semua OS)

        time = new JLabel();
        time.setSize(60, 10);
        time.setFont(new Font("Bandal", Font.PLAIN, 15));
        time.setHorizontalAlignment(0); // set rata text (0 == tengah)
        time.setLocation(14, 20);

        contentPane.add(time);
        this.setContentPane(contentPane);
    }

    public void start(){
        this.setVisible(true);

        Thread thread = new Thread(new Time(time));
        thread.start(); // jalankan thread
    }

    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true); // set default look and feel di semua OS

        SwingUtilities.invokeLater(()->{
            new Window().start();
        });
    }
}

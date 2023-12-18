package server;

import client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    public void appendLog(String s) {
        for (ClientGUI clientGUI : ClientGUI.getClientGUIList()) {
            if (clientGUI.isLoged()) clientGUI.textMessageInLog(s);
        }
        FileWorker.logWriter(s);
    }

    public void appendMessagesFromLog(ClientGUI clientGUI) {
        List<String> logOfMessages = FileWorker.logReader();
        for (String logOfMessage : logOfMessages) {
            clientGUI.textMessageInLog(logOfMessage);
        }
    }

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private boolean isServerWorking;

    public ServerWindow() {
        isServerWorking = false;
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = false;
                System.out.println("Server stopped " + isServerWorking + "\n");
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = true;
                System.out.println("Server started " + isServerWorking + "\n");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        setLayout(new GridLayout(1, 2));
        add(btnStart);
        add(btnStop);

        setVisible(true);
    }
}
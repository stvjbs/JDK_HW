package client;

import server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int WEIGHT = 300;
    private final JTextField tfLogin;

    public boolean isLoged() {
        return isLoged;
    }

    private final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JButton btnLogin = new JButton("Login");
    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private boolean isLoged = false;
    public static ArrayList<ClientGUI> clientGUIList = new ArrayList<>();

    public static ArrayList<ClientGUI> getClientGUIList() {
        return clientGUIList;
    }

    public void textMessageInLog(String s) {
        log.append(s + "\n");
    }

    private void textAndLogMessage(ServerWindow serverWindow) {
        String message = tfLogin.getText() + ": " + tfMessage.getText() + "         " + currentTimeFormatted() ;
        tfMessage.setText("");
        serverWindow.appendLog(message);
    }
    private String currentTimeFormatted(){
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return currentTime.format(formatter);
    }
    public ClientGUI(ServerWindow serverWindow, JTextField tfIPAddress, JTextField tfPort, JTextField tfLogin,
                     JPasswordField tfPassword) {
        this.tfLogin = tfLogin;
        clientGUIList.add(this);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLoged) {
                    textMessageInLog("You already loged");
                } else {
                    textMessageInLog("Login successfully");
                    serverWindow.appendMessagesFromLog(ClientGUI.this);
                    isLoged = true;
                }
            }
        });
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLoged) textAndLogMessage(serverWindow);
                else textMessageInLog("You have to login");
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, WEIGHT);
        setTitle("Chat Client");

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        setVisible(true);
    }
}

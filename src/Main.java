import client.ClientGUI;
import server.ServerWindow;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JTextField tfIPAddress1 = new JTextField("127.0.0.1");
        JTextField tfPort1 = new JTextField("8189");
        JTextField tfLogin1 = new JTextField("steve_jobs");
        JPasswordField tfPassword1 = new JPasswordField("123456");

        JTextField tfIPAddress2 = new JTextField("127.1.3.0");
        JTextField tfPort2 = new JTextField("4112");
        JTextField tfLogin2 = new JTextField("steve_wozniak");
        JPasswordField tfPassword2 = new JPasswordField("111111");

        ServerWindow serverWindow = new ServerWindow();
        ClientGUI clientGUI1 = new ClientGUI(serverWindow, tfIPAddress1, tfPort1, tfLogin1, tfPassword1);
        ClientGUI clientGUI2 = new ClientGUI(serverWindow, tfIPAddress2, tfPort2, tfLogin2, tfPassword2);
    }
}

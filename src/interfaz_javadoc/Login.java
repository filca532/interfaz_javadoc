/**
 * Interfaz de inicio de sesión.
 *
 * @author Filca
 * @version 0.1
 */
package interfaz_javadoc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {
    /**
     * Método principal que inicia la interfaz de inicio de sesión.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        User user = new User();

        JTextField textFieldUser = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        addUsers(userManager);

        JFrame window = new JFrame("Login");
        window.setSize(300, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\alexf\\1-DAM-Aleksandr-Filcakov-Sapronov\\ED\\src\\interfaz_javadoc\\monkey.png");
        window.setIconImage(icon);


        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.getContentPane().add(tittle());
        window.getContentPane().add(user(textFieldUser));
        window.getContentPane().add(password(userManager, textFieldUser, passwordField, window));
        window.getContentPane().add(loginButton(userManager, textFieldUser, passwordField, window));

        window.getContentPane().setBackground(new Color(204, 255, 204));

        window.setVisible(true);
    }

    /**
     * Añade usuarios al gestor de usuarios.
     *
     * @param userManager El gestor de usuarios.
     */
    public static void addUsers(UserManager userManager) {
        userManager.addUsers("Filca7367", "7367");
        userManager.addUsers("Castilla", "Hago_mewing24/7");
    }

    /**
     * Crea el panel del título.
     *
     * @return JPanel con el título.
     */
    public static JPanel tittle() {
        JPanel PanelTittle = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelTittle = new JLabel("WELCOME");

        labelTittle.setFont(new Font("Source Code Pro", Font.BOLD, 24));
        labelTittle.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        PanelTittle.add(labelTittle);
        PanelTittle.setBackground(new Color(204, 255, 204));
        return PanelTittle;
    }

    /**
     * Crea el panel del usuario.
     *
     * @param textFieldUser Campo de texto para el nombre de usuario.
     * @return JPanel con el campo de texto del usuario.
     */
    public static JPanel user(JTextField textFieldUser) {
        JPanel panelUser = new JPanel(null);
        JLabel labelUser = new JLabel("User");

        labelUser.setFont(new Font("Source Code Pro", Font.BOLD, 12));
        labelUser.setBounds(50, 5, 80, 20);

        textFieldUser.setBounds(130, 5, 120, 20);

        panelUser.add(labelUser);
        panelUser.add(textFieldUser);
        panelUser.setBackground(new Color(204, 255, 204));
        return panelUser;
    }

    /**
     * Crea el panel de la contraseña.
     *
     * @param userManager Gestor de usuarios.
     * @param textFieldUser Campo de texto para el nombre de usuario.
     * @param passwordField Campo de contraseña para la contraseña del usuario.
     * @param window Ventana de la interfaz de usuario.
     * @return JPanel con el campo de contraseña.
     */
    public static JPanel password(UserManager userManager, JTextField textFieldUser, JPasswordField passwordField, JFrame window) {
        JPanel panelPassword = new JPanel(null);
        JLabel labelPassword = new JLabel("Password");

        labelPassword.setFont(new Font("Source Code Pro", Font.BOLD, 12));
        labelPassword.setBounds(50, 0, 80, 20);

        passwordField.setBounds(130, 0, 120, 20);

        panelPassword.add(labelPassword);
        panelPassword.add(passwordField);
        panelPassword.setBackground(new Color(204, 255, 204));

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    User user = new User();

                    String username = textFieldUser.getText();
                    user.setUsername(username);

                    String password = new String(passwordField.getPassword());
                    user.setPassword(password);

                    if (userManager.validateUsers(username, password)) {
                        window.dispose();
                        JFrame newWindow = new JFrame("Login");
                        newWindow.setSize(700, 300);
                        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        JLabel label = new JLabel("YOU'RE LOG IN");
                        label.setBounds(250, 150, 200, 30);
                        newWindow.add(label);

                        JButton closeButton = new JButton("EXIT");
                        closeButton.setBounds(300, 200, 100, 30);
                        closeButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                newWindow.dispose();
                                System.exit(0);
                            }
                        });
                        newWindow.add(closeButton);

                        newWindow.setLayout(null);
                        newWindow.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        return panelPassword;
    }

    /**
     * Crea el botón de inicio de sesión.
     *
     * @param userManager Gestor de usuarios.
     * @param textFieldUser Campo de texto para el nombre de usuario.
     * @param passwordField Campo de contraseña para la contraseña del usuario.
     * @param window Ventana de la interfaz de usuario.
     * @return JPanel con el botón de inicio de sesión.
     */
    public static JPanel loginButton(UserManager userManager, JTextField textFieldUser, JPasswordField passwordField, JFrame window) {
        JPanel panelLogin = new JPanel(null);
        JButton buttonLogin = new JButton("LOG IN");

        buttonLogin.setBounds(130, 0, 120, 30);

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();

                String username = textFieldUser.getText();
                user.setUsername(username);

                String password = new String(passwordField.getPassword());
                user.setPassword(password);

                if (userManager.validateUsers(username, password)) {
                    window.dispose();
                    JFrame newWindow = new JFrame("Login");
                    newWindow.setSize(700, 300);
                    newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JLabel label = new JLabel("YOU'RE LOG IN");
                    label.setBounds(250, 150, 200, 30);
                    newWindow.add(label);

                    JButton closeButton = new JButton("EXIT");
                    closeButton.setBounds(300, 200, 100, 30);
                    closeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            newWindow.dispose();
                            System.exit(0);
                        }
                    });
                    newWindow.add(closeButton);

                    newWindow.setLayout(null);
                    newWindow.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panelLogin.add(buttonLogin);
        panelLogin.setBackground(new Color(204, 255, 204));

        return panelLogin;
    }
}
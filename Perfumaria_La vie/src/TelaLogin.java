import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaLogin extends JFrame implements ActionListener {
    private JTextField textFieldLogin;
    private JPasswordField passwordFieldSenha;
    private Tela_Principal telaPrincipal;

    public TelaLogin(Tela_Principal telaPrincipal) {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE); // Cor de fundo do painel interno
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // Espaçamento interno

        JLabel labelTitulo = new JLabel("Login");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(labelTitulo, constraints);

        JLabel labelLogin = new JLabel("Login:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.EAST;
        panel.add(labelLogin, constraints);

        textFieldLogin = new JTextField(20);
        textFieldLogin.setBounds(100, 100, 100, 100);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(textFieldLogin, constraints);

        JLabel labelSenha = new JLabel("Senha:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.EAST;
        panel.add(labelSenha, constraints);

        passwordFieldSenha = new JPasswordField(20);
        passwordFieldSenha.setBounds(100, 100, 100, 100);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(passwordFieldSenha, constraints);

        JButton buttonEntrar = new JButton("Entrar");
        buttonEntrar.setBackground(new Color(50, 150, 50)); // Cor de fundo verde para o botão
        buttonEntrar.setForeground(Color.WHITE); // Cor do texto branco para o botão
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(buttonEntrar, constraints);


        JButton buttonCancelar = new JButton("Cancelar");
        buttonCancelar.setBackground(new Color(150, 50, 50)); // Cor de fundo vermelha para o botão
        buttonCancelar.setForeground(Color.WHITE); // Cor do texto branco para o botão
        constraints.gridy = 4; // Próxima linha
        panel.add(buttonCancelar, constraints);

        getContentPane().add(panel, BorderLayout.CENTER); // Adiciona o painel à janela principal

        buttonEntrar.addActionListener(this); // Adiciona o ActionListener para o botão Entrar
        add(panel);
        buttonCancelar.addActionListener(e -> dispose());


        setVisible(true); // Tornar a janela vísivel
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String login = textFieldLogin.getText();
        String senha = new String(passwordFieldSenha.getPassword());

        // Simulação de validação (substitua com sua lógica real de validação)
        if (login.equals("usuario") && senha.equals("senha123")) {
            JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
            dispose(); // Fecha a tela de login após o login bem-sucedido

           // Abre a tela de produtos após o login
            SwingUtilities.invokeLater(TelaProdutos::new);

        } else {
            JOptionPane.showMessageDialog(this, "Login ou senha incorretos. Tente novamente.");
        }
    }
}





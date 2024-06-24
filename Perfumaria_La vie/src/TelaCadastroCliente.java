 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

 public class TelaCadastroCliente extends JFrame {

     private JTextField textFieldNome;
     private JTextField textFieldCPF;
     private JTextField textFieldTelefone;
     private JTextField textFieldEndereco;
     private JTextField textFieldEmail;
     private JTextField textFieldsexo;
     private JTextField textFieldsenha;

     public TelaCadastroCliente() {
         setTitle("Cadastro de Cliente La Vie un Parfum");
         setSize(500, 400);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar apenas a janela de cadastro
         setResizable(false);
         setLocationRelativeTo(null);
         setLayout(new BorderLayout());

         //Cor de fundo e estilos visuais

         JPanel contentPane = new JPanel(new GridBagLayout());
         contentPane.setBackground(new Color(240, 240, 240));
         setContentPane(contentPane);
         contentPane.setLayout(new BorderLayout());

         JPanel panel = new JPanel(new GridBagLayout());
         panel.setBackground(Color.WHITE);  // Cor de fundo do painel
         GridBagConstraints constraints = new GridBagConstraints();
         constraints.insets = new Insets(10, 10, 10, 10); //Espaço entre os componentes

         JLabel labelNome = new JLabel("Nome:");
         labelNome.setForeground(new Color(50, 50, 150));
         constraints.gridx = 0;
         constraints.gridy = 0;
         constraints.anchor = GridBagConstraints.EAST;
         panel.add(labelNome, constraints);

         textFieldNome = new JTextField(20);
         textFieldNome.setBounds(100, 100, 100, 100);
         constraints.gridx = 1;
         constraints.gridwidth = 3;
         constraints.fill = GridBagConstraints.HORIZONTAL;
         panel.add(textFieldNome, constraints);

         JLabel labelCPF = new JLabel("CPF:");
         labelCPF.setForeground(new Color(50, 50, 150));
         constraints.gridx = 0;
         constraints.gridy = 1; // Próxima linha
         constraints.gridwidth = 1;
         panel.add(labelCPF, constraints);

         textFieldCPF = new JTextField(20);
         constraints.gridx = 1;
         constraints.gridwidth = 3;
         panel.add(textFieldCPF, constraints);

         // Rótulo e campo de texto para o telefone
         JLabel labelTelefone = new JLabel("Telefone:");
         labelTelefone.setForeground(new Color(50, 50, 150));
         constraints.gridx = 0;
         constraints.gridy = 2; // Próxima linha
         panel.add(labelTelefone, constraints);

         textFieldTelefone = new JTextField(20);
         constraints.gridx = 1;
         panel.add(textFieldTelefone, constraints);

         // Rótulo e campo de texto para o endereço
         JLabel labelEndereco = new JLabel("Endereço:");
         labelEndereco.setForeground(new Color(50, 50, 150));
         constraints.gridx = 0;
         constraints.gridy = 3; // Próxima linha
         constraints.gridwidth = 1;
         panel.add(labelEndereco, constraints);

         textFieldEndereco = new JTextField(20);
         constraints.gridx = 1;
         constraints.gridy = 3;
         constraints.gridwidth = 3;
         panel.add(textFieldEndereco, constraints);

         // Rótulo e campo de texto para o email
         JLabel labelEmail = new JLabel("Email:");
         labelEmail.setForeground(new Color(50, 50, 150));
         constraints.gridx = 0;
         constraints.gridy = 4; // Próxima linha
         constraints.gridwidth = 1;
         panel.add(labelEmail, constraints);

         textFieldEmail = new JTextField(20);
         constraints.gridx = 1;
         constraints.gridy = 4;
         constraints.gridwidth = 3;
         panel.add(textFieldEmail, constraints);

         JLabel labelSexo = new JLabel("Sexo:");
         labelSexo.setForeground(new Color(50, 50, 150));
         constraints.gridx = 0;
         constraints.gridy = 5;
         constraints.gridwidth = 1;
         panel.add(labelSexo, constraints);

         textFieldsexo = new JTextField(20);
         constraints.gridx = 1;
         constraints.gridy = 5;
         constraints.gridwidth = 3;
         panel.add(textFieldsexo, constraints);

         JLabel labelSenha = new JLabel("Criar senha:");
         labelSenha.setForeground(new Color(50, 50, 150));
         constraints.gridx = 0;
         constraints.gridy = 6;
         constraints.gridwidth = 1;
         panel.add(labelSenha, constraints);

         textFieldsenha = new JTextField(20);
         constraints.gridx = 1;
         constraints.gridy = 6;
         constraints.gridwidth = 3;
         panel.add(textFieldsenha, constraints);


         add(panel, BorderLayout.CENTER);

         JButton buttonSalvar = new JButton("Salvar");
         buttonSalvar.setBackground(new Color(50, 150, 50)); // Cor de fundo verde para o botão
         buttonSalvar.setForeground(Color.WHITE); // Cor do texto branco para o botão
         constraints.gridx = 1;
         constraints.gridy = 6; // Próxima linha
         constraints.gridwidth = 1;
         constraints.anchor = GridBagConstraints.CENTER;
         panel.add(buttonSalvar, constraints);

         JButton buttonCancelar = new JButton("Cancelar");
         buttonCancelar.setBackground(new Color(150, 50, 50)); // Cor de fundo vermelha para o botão
         buttonCancelar.setForeground(Color.WHITE);
         constraints.gridx = 2;
         panel.add(buttonCancelar, constraints);


         JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
         panelButtons.setOpaque(false); // Torna o painel transparente para exibir a cor de fundo da janela
         panelButtons.add(buttonSalvar);
         panelButtons.add(buttonCancelar);
         contentPane.add(panelButtons, BorderLayout.SOUTH);

         add(panelButtons, BorderLayout.SOUTH);

         //Ação de Salvar
         buttonSalvar.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 // Criar um objeto Cliente com os dados inseridos
                 Cliente cliente = new Cliente();
                 cliente.setNome(textFieldNome.getText());
                 cliente.setCPF(textFieldCPF.getText());
                 cliente.setTelefone(textFieldTelefone.getText());
                 cliente.setEmail(textFieldEmail.getText());
                 cliente.setSexo(textFieldsexo.getText());
                 cliente.setSenha(new String(textFieldsenha.getText())); // Obter senha como String

                 // Exemplo de uso para verificar os dados salvos
                 System.out.println("Cliente cadastrado:");
                 System.out.println("Nome: " + cliente.getNome());
                 System.out.println("CPF: " + cliente.getCPF());
                 System.out.println("Telefone: " + cliente.getTelefone());
                 System.out.println("Email: " + cliente.getEmail());
                 System.out.println("Sexo: " + cliente.getSexo());
                 // Não exibir senha aqui por razões de segurança

                 // Aqui você pode salvar o cliente em algum repositório, banco de dados, etc.

                 JOptionPane.showMessageDialog(TelaCadastroCliente.this, "Cadastro realizado com sucesso!");
                 limparCampos();
             }
         });

         buttonCancelar.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 dispose();
             }
         });

         setVisible(true);
     }

     // Método para limpar os campos após salvar
     private void limparCampos() {
         textFieldNome.setText("");
         textFieldCPF.setText("");
         textFieldTelefone.setText("");
         textFieldEndereco.setText("");
         textFieldEmail.setText("");
         textFieldsexo.setText("");
         textFieldsenha.setText(""); // Limpar campo de senha
     }

     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 new TelaCadastroCliente();
             }
         });
     }
 }
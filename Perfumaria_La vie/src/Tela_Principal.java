import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Tela_Principal extends JFrame implements ActionListener {

    private JButton jCarrinho; // Botão do carrinho
    private final List<Produtos> produtosSelecionados; // Lista de produtos selecionados

    public Tela_Principal() {
        setTitle("La Vie est un Parfum");

        setSize(800, 600); // Ajustei o tamanho para 600 de altura para melhor acomodar as imagens e textos
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        produtosSelecionados = new ArrayList<>(); // Inicializa a lista de produtos selecionados

        // Imagem de sapato
        ImageIcon imagemSapato = createImageIcon("Sapato.png");
        JLabel labelImagemSapato = new JLabel(imagemSapato);
        labelImagemSapato.setBounds(100, 50, 250, 250); // Posicionamento e tamanho da imagem
        add(labelImagemSapato);

        // Mensagem de boas-vindas
        JLabel labelBoasVindas = new JLabel("Seja bem-vindo a La Vie est un Parfum!");
        labelBoasVindas.setFont(new Font("Arial", Font.BOLD, 24));
        labelBoasVindas.setForeground(Color.BLACK);
        labelBoasVindas.setHorizontalAlignment(JLabel.CENTER);
        labelBoasVindas.setBounds(0, 200, 800, 30); // Posicionamento e tamanho do texto
        add(labelBoasVindas);

        // Citação de Coco Chanel
        JLabel labelCocoChanel = new JLabel("\"Nenhuma elegância é possível sem perfume.É o acessório invisível, inesquecível e definitivo. \"");
        labelCocoChanel.setFont(new Font("Arial", Font.ITALIC, 16));
        labelCocoChanel.setForeground(Color.GRAY);
        labelCocoChanel.setHorizontalAlignment(JLabel.CENTER);
        labelCocoChanel.setBounds(0, 250, 800, 30); // Posicionamento e tamanho do texto
        add(labelCocoChanel);

        // Nome "Chanel"
        JLabel labelNomeChanel = new JLabel("Coco Chanel");
        labelNomeChanel.setFont(new Font("Arial", Font.BOLD, 16));
        labelNomeChanel.setForeground(Color.BLACK);
        labelNomeChanel.setHorizontalAlignment(JLabel.CENTER);
        labelNomeChanel.setBounds(0, 280, 800, 30); // Posicionamento e tamanho do texto
        add(labelNomeChanel);


        JButton jCadastrar = new JButton("Cadastrar");
        jCadastrar.setBounds(100, 450, 250, 70);
        jCadastrar.setFont(new Font("Arial", Font.BOLD, 24));
        jCadastrar.setForeground(new Color(10, 105, 110));
        jCadastrar.setBackground(new Color(9, 10, 9));

        JButton jEntrar = new JButton("Entrar");
        jEntrar.setBounds(400, 450, 250, 70);
        jEntrar.setFont(new Font("Arial", Font.BOLD, 24));
        jEntrar.setForeground(new Color(10, 105, 110));
        jEntrar.setBackground(new Color(9, 10, 9));

        //Botão para abrir o carrinho de compra
        jCarrinho = new JButton("Carrinho");
        jCarrinho.setBounds(250, 530, 300, 70);
        jCarrinho.setFont(new Font("Arial", Font.BOLD, 24));
        jCarrinho.setForeground(new Color(10, 105, 110));
        jCarrinho.setBackground(new Color(9, 10, 9));
        jCarrinho.setEnabled(false); // Inicialmente desabilitado até que produtos sejam selecionados

        add(jCadastrar);
        add(jEntrar);

        jCadastrar.addActionListener(e -> {
            dispose(); // Fecha a janela principal ao abrir a tela de cadastro
            new TelaCadastroCliente();
        });

        jEntrar.addActionListener(e -> {
            dispose(); // Fecha a janela principal ao abrir a tela de login
            new TelaLogin(this); // Passa a referência da tela principal para a tela de login
        });

        jCarrinho.addActionListener(e -> {
            // Abrir o carrinho de compras
            new TeladeCarrinho(null);
        });

        setVisible(true);

    }

    private ImageIcon createImageIcon(String image) {
        return null;
    }

    // Método para adicionar produto selecionado ao carrinho
    public void adicionarProdutoSelecionado(Produtos produto) {
        produtosSelecionados.add(produto);
        jCarrinho.setEnabled(true); // Habilit
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class TelaProdutos extends JFrame {

    private ArrayList<Produtos> listaProdutos;
    private CarrinhodeCompra carrinho;

    public TelaProdutos() {
        setTitle("Vitrine de Produtos - La Vie est un Parfum");
        setSize(1400, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        getContentPane().setBackground(Color.WHITE);

        listaProdutos = Produtos.createProdutos(); // Obtém a lista de produtos fictícia
        carrinho = new CarrinhodeCompra(); // Inicializa o carrinho de compras

        // JPanel principal para os produtos com layout GridLayout
        JPanel panelProdutos = new JPanel(new GridLayout(3, 2, 20, 20)); // 2 colunas, espaçamento de 20 pixels
        panelProdutos.setBackground(Color.WHITE);
        panelProdutos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margem ao redor do painel

        for (Produtos produto : listaProdutos) {
            // Painel para cada produto
            JPanel panelProduto = new JPanel(new BorderLayout());
            panelProduto.setBackground(Color.WHITE); // Cor de fundo do painel de produto
            panelProduto.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); // Borda do painel

            // Carrega a imagem e redimensiona para o tamanho desejado
            ImageIcon imagemProduto = createResizedImageIcon(produto.getCaminhoImagem(), 250, 250);
            if (imagemProduto != null) {
                JLabel labelImagem = new JLabel(imagemProduto);
                labelImagem.setHorizontalAlignment(JLabel.CENTER);
                panelProduto.add(labelImagem, BorderLayout.CENTER);
            } else {
                System.err.println("Imagem não encontrada para: " + produto.getNomePerfume());
            }

            // Painel para informações do produto à direita da imagem
            JPanel panelInfo = new JPanel(new BorderLayout());
            panelInfo.setBackground(Color.WHITE);
            panelProduto.add(panelInfo, BorderLayout.EAST);

            // Nome do produto
            JLabel labelNomePerfume = new JLabel(produto.getNomePerfume());
            labelNomePerfume.setFont(new Font("Arial", Font.BOLD, 16));
            labelNomePerfume.setBorder(new EmptyBorder(10, 10, 0, 10)); // Margem superior e inferior
            panelInfo.add(labelNomePerfume, BorderLayout.NORTH);

            // Preço do produto
            JLabel labelPreco = new JLabel("R$ " + produto.getPreco());
            labelPreco.setFont(new Font("Arial", Font.PLAIN, 14));
            labelPreco.setBorder(new EmptyBorder(0, 10, 10, 10)); // Margem inferior
            panelInfo.add(labelPreco, BorderLayout.CENTER);

            // Botão de detalhes
            JButton btnDetalhes = new JButton("Detalhes");
            btnDetalhes.setFocusPainted(false);
            btnDetalhes.setBackground(new Color(10, 105, 110)); // Cor do botão
            btnDetalhes.setForeground(Color.WHITE); // Cor do texto
            btnDetalhes.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16)); // Espaçamento interno
            btnDetalhes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Ação ao clicar no botão de detalhes
                    mostrarDetalhesProduto(produto);
                }
            });
            panelInfo.add(btnDetalhes, BorderLayout.SOUTH);

            // Adiciona o painel do produto ao painel geral
            panelProdutos.add(panelProduto);
        }

        // Botão para exibir o carrinho
        JButton btnExibirCarrinho = new JButton("Exibir Carrinho");
        btnExibirCarrinho.setFocusPainted(false);
        btnExibirCarrinho.setBackground(new Color(10, 105, 110));
        btnExibirCarrinho.setForeground(Color.WHITE);
        btnExibirCarrinho.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btnExibirCarrinho.addActionListener(e -> {
            if (!carrinho.getItens().isEmpty()) {
                exibirCarrinho();
            } else {
                JOptionPane.showMessageDialog(this, "Seu carrinho está vazio.");
            }
        });

        // Botão para comprar (será exibido ao lado do botão "Exibir Carrinho")
        JButton btnComprar = new JButton("Comprar");
        btnComprar.setFocusPainted(false);
        btnComprar.setBackground(new Color(10, 105, 110));
        btnComprar.setForeground(Color.WHITE);
        btnComprar.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btnComprar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Selecione um produto para comprar.");
            // Aqui você pode adicionar a lógica para comprar diretamente da vitrine, se desejar
        });

        // Painel que contém os botões na parte inferior da tela
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotoes.setBackground(Color.WHITE);
        panelBotoes.add(btnComprar);
        panelBotoes.add(btnExibirCarrinho);

        // Adiciona o painel de botões ao JFrame na parte inferior
        add(panelBotoes, BorderLayout.SOUTH);

        // Usar um JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(panelProdutos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Adiciona o JScrollPane ao JFrame
        add(scrollPane, BorderLayout.CENTER);

        pack(); // Ajusta o tamanho da janela automaticamente com base no conteúdo
        setVisible(true);
    }

    private void mostrarDetalhesProduto(Produtos produto) {
        // Janela de detalhes do produto
        JDialog dialogDetalhes = new JDialog(this, "Detalhes do Produto", true);
        dialogDetalhes.setLayout(new BorderLayout());

        // Painel para informações do produto
        JPanel panelDetalhes = new JPanel();
        panelDetalhes.setLayout(new BorderLayout());
        panelDetalhes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Nome, preço e descrição do produto
        JLabel labelNomePerfume = new JLabel(produto.getNomePerfume());
        labelNomePerfume.setFont(new Font("Arial", Font.BOLD, 18));
        panelDetalhes.add(labelNomePerfume, BorderLayout.NORTH);

        JLabel labelPreco = new JLabel("Preço: R$ " + produto.getPreco());
        labelPreco.setFont(new Font("Arial", Font.PLAIN, 16));
        panelDetalhes.add(labelPreco, BorderLayout.CENTER);

        JTextArea textAreaDescricao = new JTextArea(produto.getDescricao());
        textAreaDescricao.setLineWrap(true);
        textAreaDescricao.setWrapStyleWord(true);
        textAreaDescricao.setEditable(false);
        JScrollPane scrollPaneDescricao = new JScrollPane(textAreaDescricao);
        scrollPaneDescricao.setPreferredSize(new Dimension(400, 200)); // Defina o tamanho preferido do JScrollPane
        panelDetalhes.add(scrollPaneDescricao, BorderLayout.SOUTH);

        // Botão de comprar dentro da janela de detalhes
        JButton btnComprar = new JButton("Comprar");
        btnComprar.setFocusPainted(false);
        btnComprar.setBackground(new Color(10, 105, 110)); // Cor do botão
        btnComprar.setForeground(Color.WHITE); // Cor do texto
        btnComprar.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16)); // Espaçamento interno
        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantidadeSelecionada = pedirQuantidadeProduto();
                if (quantidadeSelecionada > 0) {
                    produto.setQuantidade(quantidadeSelecionada);
                    carrinho.adicionarItem(produto); // Adiciona ao carrinho
                    JOptionPane.showMessageDialog(dialogDetalhes, "Produto adicionado ao carrinho:\n" + produto.getNomePerfume() + " - Quantidade: " + quantidadeSelecionada);
                    dialogDetalhes.dispose(); // Fecha a janela de detalhes após adicionar ao carrinho
                } else {
                    JOptionPane.showMessageDialog(dialogDetalhes, "Selecione ao menos uma unidade para adicionar ao carrinho.");
                }
            }
        });
        panelDetalhes.add(btnComprar, BorderLayout.SOUTH);

        dialogDetalhes.add(panelDetalhes);
        dialogDetalhes.setSize(500, 400); // Defina o tamanho inicial da janela de detalhes
        dialogDetalhes.setLocationRelativeTo(this); // Centraliza a janela de detalhes na tela principal
        dialogDetalhes.setVisible(true);
    }

    private int pedirQuantidadeProduto() {
        String quantidadeStr = JOptionPane.showInputDialog(this, "Informe a quantidade desejada:", "Quantidade", JOptionPane.PLAIN_MESSAGE);
        try {
            int quantidade = Integer.parseInt(quantidadeStr);
            return quantidade;
        } catch (NumberFormatException e) {
            return 0; // Retorna 0 se não for um número válido
        }
    }

    private ImageIcon createResizedImageIcon(String caminhoImagem, int width, int height) {
        try {
            URL imgUrl = getClass().getResource(caminhoImagem);
            if (imgUrl != null) {
                BufferedImage img = ImageIO.read(imgUrl);
                Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                return new ImageIcon(scaledImg);
            } else {
                System.err.println("Não foi possível carregar a imagem: " + caminhoImagem);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private ImageIcon createImageIcon(String path) {
        URL imgUrl = getClass().getResource(path);
        if (imgUrl != null) {
            return new ImageIcon(imgUrl);
        } else {
            System.err.println("Não foi possível carregar o ícone: " + path);
            return null;
        }
    }

    private int pedirQuantidadeProduto(Produtos produto) {
        String quantidadeStr = JOptionPane.showInputDialog(this, "Informe a quantidade desejada para " + produto.getNomePerfume() + ":", "Quantidade", JOptionPane.PLAIN_MESSAGE);
        try {
            int quantidade = Integer.parseInt(quantidadeStr);
            return quantidade;
        } catch (NumberFormatException e) {
            return 0; // Retorna 0 se não for um número válido
        }
    }

    private void exibirCarrinho() {
        // Obter os produtos do carrinho e abrir a tela de carrinho
        List<ItemCarrinho> itensCarrinho = carrinho.getItens();
        if (itensCarrinho.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seu carrinho está vazio.");
            return;
        }

        TeladeCarrinho telaCarrinho = new TeladeCarrinho(itensCarrinho);
        telaCarrinho.setVisible(true);
    }

    public static void main(String[] args) {
        // Executar a aplicação
        SwingUtilities.invokeLater(() -> new TelaProdutos());
    }
}

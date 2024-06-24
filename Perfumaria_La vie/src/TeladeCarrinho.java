import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class TeladeCarrinho extends JFrame {

    private List<ItemCarrinho> itensCarrinho;
    private CarrinhodeCompra carrinho;

    public TeladeCarrinho(List<ItemCarrinho> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
        carrinho = new CarrinhodeCompra();

        setTitle("Carrinho de Compras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        getContentPane().setBackground(Color.WHITE);

        // JPanel principal para os itens do carrinho com layout GridLayout
        JPanel panelCarrinho = new JPanel(new GridLayout(0, 1, 10, 10)); // Layout vertical, espaçamento de 10 pixels
        panelCarrinho.setBackground(Color.WHITE);
        panelCarrinho.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margem ao redor do painel

        // Adiciona cada item do carrinho ao painel
        for (ItemCarrinho item : itensCarrinho) {
            JPanel panelItem = new JPanel(new BorderLayout());
            panelItem.setBackground(Color.WHITE);
            panelItem.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); // Borda do item do carrinho

            // Nome do produto
            JLabel labelNomeProduto = new JLabel(item.getProduto().getNomePerfume());
            labelNomeProduto.setFont(new Font("Arial", Font.BOLD, 16));
            labelNomeProduto.setBorder(new EmptyBorder(10, 10, 0, 10)); // Margem superior e inferior
            panelItem.add(labelNomeProduto, BorderLayout.NORTH);

            // Quantidade e preço subtotal
            JLabel labelDetalhes = new JLabel("Quantidade: " + item.getQuantidade() + " - Subtotal: R$ " + item.getSubtotal());
            labelDetalhes.setFont(new Font("Arial", Font.PLAIN, 14));
            labelDetalhes.setBorder(new EmptyBorder(0, 10, 10, 10)); // Margem inferior
            panelItem.add(labelDetalhes, BorderLayout.CENTER);

            // Botão para remover item do carrinho
            JButton btnRemover = new JButton("Remover");
            btnRemover.setFocusPainted(false);
            btnRemover.setBackground(new Color(10, 105, 110));
            btnRemover.setForeground(Color.WHITE);
            btnRemover.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
            btnRemover.addActionListener(e -> {
                carrinho.removerItem(item); // Remove o item do carrinho
                atualizarTela(); // Atualiza a tela após remover o item
            });
            panelItem.add(btnRemover, BorderLayout.EAST);

            // Adiciona o painel do item ao painel do carrinho
            panelCarrinho.add(panelItem);
        }

        // Botão para finalizar compra
        JButton btnFinalizarCompra = new JButton("Finalizar Compra");
        btnFinalizarCompra.setFocusPainted(false);
        btnFinalizarCompra.setBackground(new Color(10, 105, 110));
        btnFinalizarCompra.setForeground(Color.WHITE);
        btnFinalizarCompra.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btnFinalizarCompra.addActionListener(e -> {
            if (!itensCarrinho.isEmpty()) {
                finalizarCompra();
            } else {
                JOptionPane.showMessageDialog(this, "Seu carrinho está vazio.");
            }
        });

        // Painel que contém o botão "Finalizar Compra"
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotoes.setBackground(Color.WHITE);
        panelBotoes.add(btnFinalizarCompra);

        // Adiciona o painel de botões ao JFrame na parte inferior
        add(panelBotoes, BorderLayout.SOUTH);

        // Usar um JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(panelCarrinho);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Adiciona o JScrollPane ao JFrame
        add(scrollPane, BorderLayout.CENTER);

        // Atualiza a tela inicialmente
        atualizarTela();

        pack(); // Ajusta o tamanho da janela automaticamente com base no conteúdo
        setVisible(true);
    }

    private void finalizarCompra() {
        // Mostrar opções de pagamento
        Object[] options = { "Cartão de Crédito", "PIX" };
        int opcao = JOptionPane.showOptionDialog(this, "Selecione o método de pagamento:", "Pagamento",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (opcao == 0) {
            // Pagamento com Cartão de Crédito
            realizarPagamentoCartao();
        } else if (opcao == 1) {
            // Pagamento com PIX
            realizarPagamentoPIX();
        }
    }

    private void realizarPagamentoCartao() {
        String numeroCartao = JOptionPane.showInputDialog(this, "Digite o número do cartão de crédito:", "Pagamento com Cartão de Crédito", JOptionPane.PLAIN_MESSAGE);
        if (numeroCartao != null && !numeroCartao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pagamento realizado com sucesso!\nNúmero do Cartão: " + numeroCartao, "Pagamento Confirmado", JOptionPane.INFORMATION_MESSAGE);
            carrinho.limparCarrinho();
            dispose(); // Fecha a tela de carrinho após o pagamento
        } else {
            JOptionPane.showMessageDialog(this, "Número de cartão inválido.", "Erro no Pagamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void realizarPagamentoPIX() {
        String chavePIX = JOptionPane.showInputDialog(this, "Digite a chave PIX:", "Pagamento com PIX", JOptionPane.PLAIN_MESSAGE);
        if (chavePIX != null && !chavePIX.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pagamento realizado com sucesso!\nChave PIX: " + chavePIX, "Pagamento Confirmado", JOptionPane.INFORMATION_MESSAGE);
            carrinho.limparCarrinho();
            dispose(); // Fecha a tela de carrinho após o pagamento
        } else {
            JOptionPane.showMessageDialog(this, "Chave PIX inválida.", "Erro no Pagamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarTela() {
        // Limpa o conteúdo atual do painel do carrinho
        getContentPane().removeAll();

        // JPanel principal para os itens do carrinho com layout GridLayout
        JPanel panelCarrinho = new JPanel(new GridLayout(0, 1, 10, 10)); // Layout vertical, espaçamento de 10 pixels
        panelCarrinho.setBackground(Color.WHITE);
        panelCarrinho.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margem ao redor do painel

        // Adiciona cada item do carrinho ao painel
        for (ItemCarrinho item : itensCarrinho) {
            JPanel panelItem = new JPanel(new BorderLayout());
            panelItem.setBackground(Color.WHITE);
            panelItem.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); // Borda do item do carrinho

            // Nome do produto
            JLabel labelNomeProduto = new JLabel(item.getProduto().getNomePerfume());
            labelNomeProduto.setFont(new Font("Arial", Font.BOLD, 16));
            labelNomeProduto.setBorder(new EmptyBorder(10, 10, 0, 10)); // Margem superior e inferior
            panelItem.add(labelNomeProduto, BorderLayout.NORTH);

            // Quantidade e preço subtotal
            JLabel labelDetalhes = new JLabel("Quantidade: " + item.getQuantidade() + " - Subtotal: R$ " + item.getSubtotal());
            labelDetalhes.setFont(new Font("Arial", Font.PLAIN, 14));
            labelDetalhes.setBorder(new EmptyBorder(0, 10, 10, 10)); // Margem inferior
            panelItem.add(labelDetalhes, BorderLayout.CENTER);

            // Botão para remover item do carrinho
            JButton btnRemover = new JButton("Remover");
            btnRemover.setFocusPainted(false);
            btnRemover.setBackground(new Color(10, 105, 110));
            btnRemover.setForeground(Color.WHITE);
            btnRemover.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
            btnRemover.addActionListener(e -> {
                carrinho.removerItem(item); // Remove o item do carrinho
                atualizarTela(); // Atualiza a tela após remover o item
            });
            panelItem.add(btnRemover, BorderLayout.EAST);

            // Adiciona o painel do item ao painel do carrinho
            panelCarrinho.add(panelItem);
        }

        // Botão para finalizar compra
        JButton btnFinalizarCompra = new JButton("Finalizar Compra");
        btnFinalizarCompra.setFocusPainted(false);
        btnFinalizarCompra.setBackground(new Color(10, 105, 110));
        btnFinalizarCompra.setForeground(Color.WHITE);
        btnFinalizarCompra.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btnFinalizarCompra.addActionListener(e -> {
            if (!itensCarrinho.isEmpty()) {
                finalizarCompra();
            } else {
                JOptionPane.showMessageDialog(this, "Seu carrinho está vazio.");
            }
        });

        // Painel que contém o botão "Finalizar Compra"
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotoes.setBackground(Color.WHITE);
        panelBotoes.add(btnFinalizarCompra);

        // Adiciona o painel de botões ao JFrame na parte inferior
        add(panelBotoes, BorderLayout.SOUTH);

        // Usar um JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(panelCarrinho);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Adiciona o JScrollPane ao JFrame
        add(scrollPane, BorderLayout.CENTER);

        // Atualiza e redesenha a tela
        revalidate();
        repaint();
    }
}

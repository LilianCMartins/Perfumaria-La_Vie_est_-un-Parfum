import java.util.ArrayList;
import java.util.List;

public class CarrinhodeCompra {
    private String nomeCliente;
    private String CPF;
    private String endereco;
    private List<ItemCarrinho> itens;

    public CarrinhodeCompra(String nomeCliente, String CPF, String endereco) {
        this.nomeCliente = nomeCliente;
        this.CPF = CPF;
        this.endereco = endereco;
        this.itens = new ArrayList<>();
    }

    public CarrinhodeCompra() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produtos produto) {
        // Verifica se o produto já está no carrinho
        for (ItemCarrinho item : itens) {
            if (item.getProduto().equals(produto)) {
                item.incrementarQuantidade();
                return;
            }
        }
        // Se não estiver, cria um novo item no carrinho com quantidade 1
        itens.add(new ItemCarrinho(produto, 1));
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrinho item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }

    public double calcularValorTotal() {
        double total = calcularTotal();
        // Exemplo simples de adicionar um valor fixo de frete
        double frete = 10.0;
        return total + frete;
    }

    public void exibirCarrinho() {
        System.out.println("Carrinho de Compras de " + nomeCliente);
        System.out.println("Produtos:");
        for (ItemCarrinho item : itens) {
            Produtos produto = item.getProduto();
            System.out.println("- " + produto.getNomePerfume() + " | Preço: R$ " + produto.getPreco() + " | Quantidade: " + item.getQuantidade());
        }
    }

    public void limparCarrinho() {
        itens.clear();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinho> itens) {
        this.itens = itens;
    }

    public void removerItem(ItemCarrinho item) {

    }
}

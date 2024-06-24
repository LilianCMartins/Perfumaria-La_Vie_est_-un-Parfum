public class ItemCarrinho {
    private Produtos produto; // Referência para o produto associado ao item do carrinho
    private int quantidade; // Quantidade deste produto no carrinho

    // Construtor que inicializa um novo item no carrinho com um produto e quantidade específicos
    public ItemCarrinho(Produtos produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItemCarrinho() {

    }

    // Métodos Getters e Setters para acessar e modificar os atributos privados

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método para calcular o subtotal deste item no carrinho
    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public void incrementarQuantidade() {

    }
}


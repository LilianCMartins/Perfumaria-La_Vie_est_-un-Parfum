
    public class PagamentoCartão extends FormaPagamento {   // Classe específica para pagamento com cartão que herda de FormaPagamento

        private String numeroCartao;
        private String nomeTitular;
        private String validade;
        private String codigoSeguranca;

        // Construtor da classe
        public PagamentoCartão(String numeroCartao, String nomeTitular, String validade, String codigoSeguranca) {
            this.numeroCartao = numeroCartao;
            this.nomeTitular = nomeTitular;
            this.validade = validade;
            this.codigoSeguranca = codigoSeguranca;
        }

        // Implementação do método realizarPagamento específico para cartão
        @Override
        public boolean realizarPagamento(double valor) {
            // Aqui poderia ser implementada a lógica real de integração com um serviço de pagamento
            // Simula o pagamento com cartão (retorna true para simplificar o exemplo)
            return true;
        }

        // Implementação do método getNome para obter o nome da forma de pagamento (cartão)
        @Override
        public String getNome() {
            return "Cartão de Crédito";
        }

        // Métodos getters para obter os dados do cartão (encapsulamento)
        public String getNumeroCartao() {
            return numeroCartao;
        }

        public String getNomeTitular() {
            return nomeTitular;
        }

        public String getValidade() {
            return validade;
        }

        public String getCodigoSeguranca() {
            return codigoSeguranca;
        }
    }



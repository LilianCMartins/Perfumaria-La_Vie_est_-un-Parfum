
    public class PagamentoPIX extends FormaPagamento {   // Classe específica para pagamento via PIX que herda de FormaPagamento

        private String chavePIX;

        // Construtor da classe
        public PagamentoPIX(String chavePIX) {
            this.chavePIX = chavePIX;
        }

        // Implementação do método realizarPagamento específico para PIX
        @Override
        public boolean realizarPagamento(double valor) {
            // Aqui poderia ser implementada a lógica real de integração com um serviço de pagamento via PIX
            // Simula o pagamento via PIX (retorna true para simplificar o exemplo)
            return true;
        }

        // Implementação do método getNome para obter o nome da forma de pagamento (PIX)
        @Override
        public String getNome() {
            return "PIX";
        }

        // Método getter para obter a chave PIX (encapsulamento)
        public String getChavePIX() {
            return chavePIX;
        }
    }



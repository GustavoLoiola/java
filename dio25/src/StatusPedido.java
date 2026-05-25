public class StatusPedido {
    public static void main(String[] args) {
        enum Status {
            PENDENTE,
            APROVADO,
            ENVIADO,
            ENTREGUE
        }

        Status pedido = Status.APROVADO;

        System.out.println("Seu pedido está com status: " + pedido);
    }
}

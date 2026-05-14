public class WhatsApp implements MessageService{
    @Override
    public void sendMessage(String message) {
        System.out.println("WHATSAPP: " + message);
    }
}

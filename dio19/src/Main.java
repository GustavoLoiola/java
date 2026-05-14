public class Main {
    public static void main(String[] args) {
        MessageService sms = new Sms();
        MessageService email = new Email();
        MessageService socialMedia = new SocialMedia();
        MessageService whatsApp = new WhatsApp();

        sms.sendMessage("você recebeu um SMS, parabéns.");
        email.sendMessage("você recebeu um EMAIL, parabéns.");
        socialMedia.sendMessage("você recebeu uma mensagem por SOCIALMEDIA, parabéns.");
        whatsApp.sendMessage("você recebeu um ZAP, parabéns.");
    }
}
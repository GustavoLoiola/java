public class SocialMedia implements MessageService{
    @Override
    public void sendMessage(String message) {
        System.out.println("SOCIAL MEDIA: " + message);
    }
}

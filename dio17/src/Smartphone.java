public class Smartphone implements VideoPlayer, MusicPlayer {
    @Override
    public void playMusic() {
        System.out.println("Smartphone tocando música.");
    }

    @Override
    public void pauseMusic() {
        System.out.println("Smartphone pausando música.");
    }

    @Override
    public void stopMusic() {
        System.out.println("Smartphone parando música.");
    }

    @Override
    public void playVideo() {
        System.out.println("Smartphone exibindo vídeo.");
    }

    @Override
    public void pauseVideo() {
        System.out.println("Smartphone pausando vídeo.");
    }

    @Override
    public void stopVideo() {
        System.out.println("Smartphone fechando vídeo.");
    }
}
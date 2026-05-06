public class Main {
    public static void main(String[] args) {
        Animal gen = new Animal();
        gen.nome = "gen";
        gen.altura = 1.05;
        gen.dietaAlimentar = "onívoro";
        gen.fazerSom();

        Animal onca1 = new Onca();
        onca1.fazerSom();
        System.out.println(gen);
        System.out.println(onca1);
    }
}
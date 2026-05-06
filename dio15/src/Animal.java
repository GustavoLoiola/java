public class Animal {
    String nome;
    Double altura;
    String dietaAlimentar;

    public void fazerSom() {
        System.out.println("Som genérico");
    }
    }
class Onca extends Animal {
    boolean pintada;

    @Override
    public void fazerSom() {
        System.out.println("HWRAAAAAAAHW");
        ;
    }
}

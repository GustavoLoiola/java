public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private String nacionalidade;


    public Pessoa(String nome, int idade, String cpf, String nacionalidade) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.nacionalidade = nacionalidade;
    }

    void mostrarDados() {
        System.out.println("PESSOA");
        System.out.printf("Nome:  %s\n", nome);
        System.out.printf("Idade:  %d\n", idade);
        System.out.printf("CPF:  %s\n", cpf);
        System.out.printf("Nacionalidade:  %s\n", nacionalidade);
    }
}

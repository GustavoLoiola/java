//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    String frase = "Quando surge o alviverde imponente";

    String palavras [] = frase.trim().split(" ");

    int ultimaPalavra = palavras[palavras.length -1].length();

    System.out.println(ultimaPalavra);
}

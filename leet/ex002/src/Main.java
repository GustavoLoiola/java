//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner input = new Scanner(System.in);
    System.out.println("Teste de número palíndromo");
    System.out.println("Digite um número:  ");
    Integer num = input.nextInt();

    ArrayList<String> nums = new ArrayList<>();
    ArrayList<String> reverseNums = new ArrayList<>();
    String numString = num.toString();

    for (int i = 0; i < numString.length(); i++) {
        nums.add(numString.substring(i, i + 1));

        reverseNums.add(
                numString.substring(
                        numString.length() - i - 1,
                        numString.length() - i
                )
        );
    }

    boolean igual = false;

    if(nums.equals(reverseNums)) { igual = true; }

    System.out.println(igual);
    input.close();
}

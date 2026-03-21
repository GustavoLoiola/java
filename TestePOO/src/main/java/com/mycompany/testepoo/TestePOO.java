package com.mycompany.testepoo;

public class TestePOO {

    public static void main(String[] args) {
      Caneta caneta1 = new Caneta();
      caneta1.cor = "Azul";
      caneta1.ponta = 0.5f;
      caneta1.tampada = false;
      caneta1.status();
      caneta1.rabiscar();
    }
}

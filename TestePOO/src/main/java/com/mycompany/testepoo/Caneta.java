package com.mycompany.testepoo;
import java.util.Scanner;

public class Caneta {
    String modelo;
    String cor;
    float ponta;
    int carga;
    boolean tampada;
    
    Scanner entrada = new Scanner(System.in);
    
    void status() {
        System.out.println("Uma caneta da cor: " + this.cor);
        System.out.println("Está tampada: " + this.tampada);
        System.out.println("Tamanho da ponta: " + this.ponta);
    }
    
    void rabiscar() {
        if(this.tampada == true) {
            System.out.println("A Caneta está tampada então é impossível rabiscar!");
        }
        else {
            System.out.println("Digite o que você quer rabiscar: ");
            String rabisco = entrada.nextLine();
            System.out.println("Rabiscando: " + rabisco);
        }
    }
    
    void tampar(){
        this.tampada = true;
        System.out.println("Tampando a Caneta...");
    }
    
    void destampar() {
        this.tampada = false;
        System.out.println("Destampando a Caneta...");
    }   
}

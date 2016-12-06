package aps3;

import java.util.Scanner;

public class Index {

    private static Scanner sc;

    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        ListaIndexada<Integer> lista = new ListaIndexada<>();
        int opt = -1;

        for (int i = 0; i <= 2500; i++) {
            lista.append(i);
        }

        lista.criaPulos();

        while (opt != 0 || opt == -1) {
            System.out.println("Escolha uma opção da lista: \n");
            System.out.println("0 - Sair \n"
                    + "1 - Exibir\n"
                    + "2 - Buscar");
            opt = e.nextInt();

            if (opt < 0 || opt > 2) {
                System.out.println("Digite uma opção válida!");
                opt = -1;
            }

            switch (opt) {
                case 0:
                    break;
                case 1:
                    lista.mostraHeadLista();
                    break;
                case 2:
                    int num;
                    System.out.println("Digite: ");
                    num = e.nextInt();
                    lista.buscaNumeros(num);
                    break;
            }
        }
    }
}//Fecha classe principal

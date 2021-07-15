// João Victor Cunha - 2267900
package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Conta criarConta() {
        Scanner sc = new Scanner(System.in);

        String nome;
        String cpf;
        float saldo;
        System.out.println("Digite seu nome");
        nome = sc.nextLine();
        System.out.println("Digite seu CPF");
        cpf = sc.nextLine();
        System.out.println("Digite seu saldo inicial");
        saldo = sc.nextFloat();
        Conta c1 = new Conta(nome, cpf, saldo);
        return c1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Investimento> investimentos = new ArrayList<Investimento>();
        Investimento i1 = new Investimento(1000, (float) 0.15, 120);
        investimentos.add(i1);
        int flag = 1;
//        criar investimento
//        investir
//        adicionar dinheiro
//        remover dinheiro
//        liquidar(dias)
        Conta myConta = criarConta();
        System.out.println("-----------------------------------------------");
        System.out.printf("Nome %s , cpf %s, saldo %.2f R$\n", myConta.getNome(), myConta.getCpf(), myConta.getSaldo());
        System.out.println("-----------------------------------------------");
        while (true) {
            for (int i = 0; i < investimentos.size(); i++) {
                System.out.printf("Investimento Nº" + i);
                System.out.printf("valor %.2f\n", investimentos.get(i).getValor());
                System.out.printf("taxa %.2f percent\n", investimentos.get(i).getTaxa() * 100);

                System.out.print("prazo: ");
                System.out.print(investimentos.get(i).getPrazo());
                System.out.println("\n");
            }

            System.out.println("2. criar investimento");
            System.out.println("3. investir");
            System.out.println("4. adicionar dinheiro");
            System.out.println("5. remover dinheiro");
            System.out.println("6. liquidar");


            System.out.print("\n-> ");

            flag = sc.nextInt();

            if (flag == 2) {
                Investimento inv = criarInvestimento();
                investimentos.add(inv);
            } else if (flag == 3) {
                int investIdx;
                System.out.println("Digite o número do investimento");
                investIdx = sc.nextInt();
                myConta.comprar(investimentos.get(investIdx));
            } else if (flag == 4) {
                adicionarDinheiro(myConta);
            } else if (flag == 5) {
                removerDinheiro(myConta);
            } else if (flag == 6) {
                int investIdx;
                System.out.println("Digite o número do investimento");
                investIdx = sc.nextInt();
                liquidar(myConta, investimentos.get(investIdx));
            }

        }

    }


    static Investimento criarInvestimento() {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
//        String nome;
        float valor;
        float taxa;
        int prazo;

//        System.out.println("Digite o nome do investimento: ");
//        nome = sc.nextLine();
        System.out.println("Digite o valor do investimento: ");
        valor = sc.nextFloat();
        System.out.println("Digite a taxa mensal do investimento (e.g 2.5% = 0.025) ");
        taxa = sc.nextFloat();
        System.out.println("Digite o prazo (em dias) do investimento");
        prazo = sc.nextInt();

        Investimento i1 = new Investimento(valor, taxa, prazo);
        return i1;

    }

    static void adicionarDinheiro(Conta c1) {
        Scanner sc = new Scanner(System.in);

        float valor;
        System.out.println("Digite o valor a ser depositado");
        valor = sc.nextFloat();
        c1.setSaldo(c1.getSaldo() + valor);
    }

    static void removerDinheiro(Conta c1) {
        Scanner sc = new Scanner(System.in);

        float valor;
        System.out.println("Digite o valor a ser sacado");
        valor = sc.nextFloat();
        if (valor > c1.getSaldo()) {
            System.out.println("Você não pode sacar mais do que tem");
            return;
        }
        c1.setSaldo(c1.getSaldo() - valor);
    }
    static void liquidar(Conta c1, Investimento i1) {
        c1.setSaldo(i1.liquidar() + c1.getSaldo());

        System.out.println("--------------------------------------");
        System.out.println("Seu novo saldo é de: " + c1.getSaldo() + "R$");
        System.out.println("----------------------------------------");
    }


}

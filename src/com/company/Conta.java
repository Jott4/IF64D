// João Victor Cunha - 2267900
package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Conta {
    private final String nome;
    private final String cpf;
    private float saldo;
    private final ArrayList<Investimento> investimentos = new ArrayList<Investimento>();



    Conta(String nome, String cpf, float valor) {
        this.saldo = valor;
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }


    public void depositar(float valorDepositado) {
        this.saldo += valorDepositado;
    }

    public void withdraw(float valorRetirado) {
        if(valorRetirado > this.saldo) {
            System.out.println("Saldo insuficinete");
        }
        this.saldo = this.saldo - valorRetirado;
    }


    public void comprar(@NotNull Investimento i) {
        if(i.getValor() > this.saldo) {
            System.out.println("Saldo insuficinete");
            return;
        }
        this.saldo = this.saldo - i.getValor();
        this.investimentos.add(i);
    }

    public void vender(Investimento i) {
        if(!investimentos.contains(i)) {
            System.out.println("Você não pode vender uma ação que não tem");
            return;
        }

        this.saldo += i.liquidar();
    }



}



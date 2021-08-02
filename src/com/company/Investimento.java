// João Victor Cunha - 2267900
package com.company;

import java.time.LocalDate;

public class Investimento {
    public Investimento(float _valor, float _taxa, int _prazo) {
        this.valor = _valor;
        this.taxa = _taxa;
        this.prazo = _prazo;
    }

    private float valor;
    private float taxa;
    private int prazo; //prazo em dias

    public float getValor() {
        return valor;
    }
    public float getTaxa() {
        return taxa;
    }
    public float getPrazo() {
        return prazo;
    }


    public final float liquidar() {
        return (float) (valor + (valor * Math.pow((1+taxa), prazo/30)));
    }

}

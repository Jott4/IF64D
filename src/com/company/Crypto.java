// João Victor Cunha - 2267900
package com.company;

import java.time.LocalDate;

public class Crypto extends Investimento {
    String nome;
    public Crypto(float _valor, float _taxa, int _prazo) {
        super(_valor, _taxa, _prazo);
        this.nome = nome;
    }
}

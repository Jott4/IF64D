// João Victor Cunha - 2267900
package com.company;

import java.time.LocalDate;

public class CDB extends Investimento {
    String nome;


    public CDB(float _valor, float _taxa, int _prazo, String _nome) {
        super(_valor, _taxa, _prazo);
        this.nome = _nome;
    }

}

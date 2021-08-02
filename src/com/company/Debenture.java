// João Victor Cunha - 2267900
package com.company;

import java.time.LocalDate;

public class Debenture extends Investimento{
    String empresaResponsavel;

    public Debenture(float _valor, float _taxa, int _prazo, String _empresaResponsavel) {
        super(_valor, _taxa, _prazo);
        this.empresaResponsavel = _empresaResponsavel;
    }
}

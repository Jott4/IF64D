// João Victor Cunha - 2267900
package com.company;

import org.jetbrains.annotations.NotNull;

public interface ContaInterface {
    void depositar(float valorDepositado);
    void withdraw(float valorRetirado);
    void comprar(@NotNull Investimento i);
    void vender(Investimento i);
}

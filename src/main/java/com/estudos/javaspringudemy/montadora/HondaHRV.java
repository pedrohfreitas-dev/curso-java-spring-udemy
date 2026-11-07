package com.estudos.javaspringudemy.montadora;

import java.awt.*;

public class HondaHRV extends Carro  {

    public HondaHRV(Motor motor) {
        super(motor);
        setModelo("HRV0");
        setCor(Color.BLACK);
        setMontadora(Montadora.HONDA);
    }
}

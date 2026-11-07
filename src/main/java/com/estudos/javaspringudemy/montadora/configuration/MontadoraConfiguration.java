package com.estudos.javaspringudemy.montadora.configuration;

import com.estudos.javaspringudemy.montadora.Motor;
import com.estudos.javaspringudemy.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MontadoraConfiguration {

    @Bean(name = "motorAspirado")
    public Motor motorAspirado() {
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean(name = "motorEle")
    public Motor motorEletrico() {
        var motor = new Motor();
        motor.setCavalos(140);
        motor.setCilindros(10);
        motor.setModelo("XPTO-1");
        motor.setLitragem(4.0);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean(name = "motorAspirado")
    public Motor motorTurbo() {
        var motor = new Motor();
        motor.setCavalos(150);
        motor.setCilindros(7);
        motor.setModelo("XPTO-2");
        motor.setLitragem(6.0);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }
}

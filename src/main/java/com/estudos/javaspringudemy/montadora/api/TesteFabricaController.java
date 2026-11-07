package com.estudos.javaspringudemy.montadora.api;


import com.estudos.javaspringudemy.montadora.CarroStatus;
import com.estudos.javaspringudemy.montadora.Chave;
import com.estudos.javaspringudemy.montadora.HondaHRV;
import com.estudos.javaspringudemy.montadora.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired
    @Qualifier("motorEletrico")
    private Motor motor;


    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }
}

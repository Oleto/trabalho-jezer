/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.Controller;

import com.example.demo.modelo.Servico.Servico;
import com.example.demo.modelo.Servico.VagaServico;
import com.example.demo.modelo.entidades.Area;
import com.example.demo.modelo.entidades.Vaga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CHICO & ICA
 */
@RestController
@RequestMapping("/api/vagas")

public  class CRUDVAGA extends CRUD<Vaga> {

    @Autowired
    VagaServico vagaservico;

    @Override
    public Servico<Vaga> getService() {
        return vagaservico;
    }

}

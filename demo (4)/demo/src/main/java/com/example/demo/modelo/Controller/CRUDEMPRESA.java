/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.Controller;

import com.example.demo.modelo.Servico.EmpresaServico;
import com.example.demo.modelo.Servico.Servico;
import com.example.demo.modelo.entidades.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Empresas")

public class CRUDEMPRESA extends CRUD<Empresa> {
    @Autowired
    EmpresaServico empresaServico;
    @Override
    public Servico<Empresa> getService() {
        return empresaServico;
    }
    
}

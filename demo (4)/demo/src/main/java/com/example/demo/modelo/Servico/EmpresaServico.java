/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.Servico;

import com.example.demo.modelo.RN.EmpresaRN;
import com.example.demo.modelo.RN.RegraNegocio;
import com.example.demo.modelo.dao.EmpresaDAO;
import com.example.demo.modelo.entidades.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public class EmpresaServico extends Servico<Empresa> {

    @Autowired
    EmpresaDAO empresaDAO;

    @Autowired
    EmpresaRN empresaRN;

    @Override
    public CrudRepository<Empresa, Integer> getDAO() {
        return empresaDAO;
    }

    @Override
    public RegraNegocio<Empresa> getRegraNegocio() {
        return empresaRN;
    }
}

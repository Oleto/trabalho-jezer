/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.Servico;

import com.example.demo.modelo.RN.RegraNegocio;
import com.example.demo.modelo.RN.VagaRN;
import com.example.demo.modelo.dao.AreaDAO;
import com.example.demo.modelo.dao.VagaDAO;
import com.example.demo.modelo.entidades.Vaga;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author CHICO & ICA
 */
@Component
public class VagaServico extends Servico<Vaga> {

    @Autowired
    VagaDAO vagaDAO;
    @Autowired
    AreaDAO areaDAO;
    @Autowired
    VagaRN vagaRN;

    public List<Vaga> findByNomevagaStartingWith(String nome) {
        return vagaDAO.findByNomevagaStartingWith(nome);
    }

    public List<Vaga> findByNomevagaOrderBySalarioDesc(String nome) {
        return vagaDAO.findByNomevagaOrderBySalarioDesc(nome);
    }

    @Override
    public CrudRepository<Vaga, Integer> getDAO() {
        return vagaDAO;
    }

    @Override
    public RegraNegocio<Vaga> getRegraNegocio() {
        return vagaRN;
    }
}

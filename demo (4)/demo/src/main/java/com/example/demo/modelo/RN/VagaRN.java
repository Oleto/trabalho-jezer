/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.RN;

import com.example.demo.excecoes.QuebraRegraNegocio;
import com.example.demo.modelo.entidades.Vaga;
import org.springframework.stereotype.Component;

/**
 *
 * @author CHICO & ICA
 */
@Component
public class VagaRN implements RegraNegocio<Vaga> {

    @Override
    public void validarCadastrar(Vaga entidade) {
        if (entidade.getAreavaga() == null || entidade.getEmpresa() == null || entidade.getNomevaga().trim().isEmpty() || entidade.getSalario() == 0) {
            throw new QuebraRegraNegocio("Todos os campos obrigatorios");
        }
    }

    @Override
    public void validarAtualizar(Vaga entidadeAtinga, Vaga entidadeNova) {

    }

    @Override
    public void validarExcluir(Vaga entidade) {

    }

}

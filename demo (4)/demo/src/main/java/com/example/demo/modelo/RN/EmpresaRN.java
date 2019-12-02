/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.RN;

import com.example.demo.excecoes.QuebraRegraNegocio;
import com.example.demo.modelo.entidades.Empresa;
import org.springframework.stereotype.Component;

/**
 *
 * @author CHICO & ICA
 */
@Component
public class EmpresaRN implements RegraNegocio<Empresa> {

    @Override
    public void validarCadastrar(Empresa entidade) {
        if (entidade.getCnpj().trim().isEmpty()) {
            throw new QuebraRegraNegocio("Campo Obrigatorio");
        } else if (entidade.getCnpj().trim().length() != 14) {
            throw new QuebraRegraNegocio("CNPJ deve Ter exatos 14 caracteres");
        }
        if (entidade.getNomeEmpresa().trim().isEmpty()) {
            throw new QuebraRegraNegocio("Campo Obrigatorio");
        }
        if (!entidade.getVagas().isEmpty()) {
            throw new QuebraRegraNegocio("Vagas Só podem ser inseridas na atualiazção");
        }

    }

    @Override
    public void validarAtualizar(Empresa entidadeAntiga, Empresa entidadeNova) {
        if (!entidadeAntiga.getCnpj().equals(entidadeNova.getCnpj())) {
            throw new QuebraRegraNegocio("CNPJ não pode Ser Alterado");

        }
        if (!entidadeAntiga.getNomeEmpresa().equals(entidadeNova.getNomeEmpresa())) {
            throw new QuebraRegraNegocio("Nome da empresa não pode ser alterado");

        }

    }

    @Override
    public void validarExcluir(Empresa entidade) {

    }

}

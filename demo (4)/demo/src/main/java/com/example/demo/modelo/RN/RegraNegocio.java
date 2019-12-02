/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.RN;

public interface RegraNegocio<T> {
    public void validarCadastrar(T entidade);
    public void validarAtualizar(T entidadeAtinga, T entidadeNova);
    public void validarExcluir(T entidade);
}
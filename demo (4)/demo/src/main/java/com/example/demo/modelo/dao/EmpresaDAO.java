/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.dao;

import com.example.demo.modelo.entidades.Empresa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author CHICO & ICA
 */
public interface EmpresaDAO extends CrudRepository<Empresa, Integer> {
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.dao;

import com.example.demo.modelo.entidades.Area;
import org.springframework.data.repository.CrudRepository;


public interface AreaDAO extends CrudRepository<Area, Integer> {
    
}

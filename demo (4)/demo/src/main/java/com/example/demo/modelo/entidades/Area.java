/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author CHICO & ICA
 */
@Entity
public class Area implements Entidade {

    @OneToMany(mappedBy = "areavaga")
    private List<Vaga> vagas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Nomearea;
    private float SalarioMedioArea;
    private int QntCandidatosVaga;
 

    public String getNomearea() {
        return Nomearea;
    }

    public void setNomearea(String Nomearea) {
        this.Nomearea = Nomearea;
    }

    public float getSalarioMedioArea() {
        return SalarioMedioArea;
    }

    public void setSalarioMedioArea(float SalarioMedioArea) {
        this.SalarioMedioArea = SalarioMedioArea;
    }

    public int getQntCandidatosVaga() {
        return QntCandidatosVaga;
    }

    public void setQntCandidatosVaga(int QntCandidatosVaga) {
        this.QntCandidatosVaga = QntCandidatosVaga;
    }



    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}

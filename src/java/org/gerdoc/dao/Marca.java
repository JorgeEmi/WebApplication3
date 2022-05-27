/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.dao;

import java.io.Serializable;

/**
 *
 * @author jorge
 */
public class Marca implements Serializable{
    private Integer id_marca;
    private String marca;
    
    public Marca(){
    
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
}

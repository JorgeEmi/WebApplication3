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
public class Producto implements Serializable{
    
    private Integer id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private String url_producto;
    private Integer precio_producto;
    private Proveedor proveedor;
    private Marca marca;
    
    public Producto(){
        
    }
    public Producto(Proveedor proveedor, Marca marca) 
    {
        this.proveedor = proveedor;
        this.marca = marca;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getUrl_producto() {
        return url_producto;
    }

    public void setUrl_producto(String url_producto) {
        this.url_producto = url_producto;
    }

    public Integer getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(Integer precio_producto) {
        this.precio_producto = precio_producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    
}

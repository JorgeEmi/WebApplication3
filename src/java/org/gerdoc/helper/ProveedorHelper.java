/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.helper;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.gerdoc.dao.Proveedor;
import org.gerdoc.service.ProveedorService;

/**
 *
 * @author gerdoc
 */
public class ProveedorHelper implements Serializable
{
    private List<Proveedor>list;
    private Proveedor proveedor;

    public ProveedorHelper() 
    {
    }
    
    public boolean loadList( )
    {
        list = new ProveedorService().getProveedorList();
        return list != null && list.size() > 0;
    }
    
    public boolean addProveedor( HttpServletRequest request )
    {
        proveedor = new Proveedor( ); 
       
        proveedor.setNombre_proveedor( request.getParameter( "nombre_proveedor" ) );
        if( proveedor.getNombre_proveedor() == null || proveedor.getNombre_proveedor().length() == 0 )
        {
            return false;
        }
        
        return new ProveedorService().addProveedor(proveedor);
    }
    
    public Integer getInteger( String campo )
    {
        Integer val = 0;
        if( campo == null || campo.length() == 0 )
        {
            return null;
        }
        try
        {
            val = new Integer(campo);
            return val;
        }
        catch(NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Proveedor> getList()
    {
        if( list == null || list.size( )== 0 )
        {
            if( !loadList( ) )
            {
                return null;
            }
        }
        return list;
    }
    
    public boolean deleteProveedor( HttpServletRequest request )
    {
        proveedor = new Proveedor( ); 
        proveedor.setId_proveedor( getInteger( request.getParameter( "id_proveedor" )) );
        if( proveedor.getId_proveedor( ) == null )
        {
            return false;
        }
        return new ProveedorService().deleteProveedor( proveedor );
    }
    
    public boolean updateProveedor( HttpServletRequest request )
    {
        proveedor = new Proveedor( ); 
        proveedor.setId_proveedor( getInteger( request.getParameter( "id_proveedor" )) );
        if( proveedor.getId_proveedor( ) == null )
        {
            return false;
        }
      
        proveedor.setNombre_proveedor( request.getParameter( "nombre_proveedor" ) );
        if( proveedor.getNombre_proveedor() == null || proveedor.getNombre_proveedor().length() == 0 )
        {
            return false;
        }
       
        
        return new ProveedorService().updateProveedor( proveedor );
    }
    
    public Proveedor getProveedorById_proveedor( HttpServletRequest request )
    {
        Proveedor proveedor = null;
        Integer id_proveedor = null;
        id_proveedor = getInteger( request.getParameter( "id_proveedor" ) );
        if( id_proveedor == null )
        {
            return null;
        }
        return new ProveedorService().getProveedorById_proveedor( id_proveedor );
    }

    public void setList(List<Proveedor> list) 
    {
        this.list = list;
    }

    public Proveedor getProveedor() 
    {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) 
    {
        this.proveedor = proveedor;
    }
    
}

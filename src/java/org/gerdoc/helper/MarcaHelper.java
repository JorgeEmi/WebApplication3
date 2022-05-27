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
import org.gerdoc.dao.Marca;
import org.gerdoc.service.MarcaService;

/**
 *
 * @author gerdoc
 */
public class MarcaHelper implements Serializable
{
    private List<Marca>list;
    private Marca marca;

    public MarcaHelper() 
    {
    }
    
    public boolean loadList( )
    {
        list = new MarcaService().getMarcaList();
        return list != null && list.size() > 0;
    }
    
    public boolean addMarca( HttpServletRequest request )
    {
        marca = new Marca( ); 
       
        marca.setMarca( request.getParameter( "marca" ) );
        if( marca.getMarca() == null || marca.getMarca().length() == 0 )
        {
            return false;
        }
        
        return new MarcaService().addMarca(marca);
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

    public List<Marca> getList()
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
    
    public boolean deleteMarca( HttpServletRequest request )
    {
        marca = new Marca( ); 
        marca.setId_marca( getInteger( request.getParameter( "id_marca" )) );
        if( marca.getId_marca( ) == null )
        {
            return false;
        }
        return new MarcaService().deleteMarca( marca );
    }
    
    public boolean updateMarca( HttpServletRequest request )
    {
        marca = new Marca( ); 
        marca.setId_marca( getInteger( request.getParameter( "id_marca" )) );
        if( marca.getId_marca( ) == null )
        {
            return false;
        }
      
        marca.setMarca( request.getParameter( "marca" ) );
        if( marca.getMarca() == null || marca.getMarca().length() == 0 )
        {
            return false;
        }
       
        
        return new MarcaService().updateMarca( marca );
    }
    
    public Marca getMarcaById_marca( HttpServletRequest request )
    {
        Marca marca = null;
        Integer id_marca = null;
        id_marca = getInteger( request.getParameter( "id_marca" ) );
        if( id_marca == null )
        {
            return null;
        }
        return new MarcaService().getMarcaById_marca( id_marca );
    }

    public void setList(List<Marca> list) 
    {
        this.list = list;
    }

    public Marca getMarca() 
    {
        return marca;
    }

    public void setMarca(Marca marca) 
    {
        this.marca = marca;
    }
    
}

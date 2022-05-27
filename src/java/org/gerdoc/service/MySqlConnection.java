/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.gerdoc.dao.Proveedor;
import org.gerdoc.dao.Uno;

/**
 *
 * @author gerdoc
 */
public class MySqlConnection implements Serializable
{
    public static String user = "root";
    public static String password = "n0m3l0";
    public static String db = "tarea1";
    public static boolean testDriver( )
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance( );
            return true;
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static Connection getConnection( String user, String password , String db , String server )
    {
        String url = null;
        if( user == null || password == null || db == null || server == null )
        {
            return null;
        }
        if( "".equals(user) || "".equals(password) || "".equals(db) || "".equals(server) )
        {
            return null;
        }
        url = String.format( "jdbc:mysql://%s/%s?user=%s&password=%s" , server , db , user , password );
        try 
        {
            if( !testDriver() )
            {
                return null;
            }
            return DriverManager.getConnection(url);
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static Connection getConnection( )
    {
        return getConnection( user, password, db , "127.0.0.1" );
    }
    
    public static void closeConnection( Connection connection )
    {
        try 
        {
            if( connection == null )
            {
                return;
            }
            if(connection.isClosed() )
            {
                return;
            }
            connection.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    
    
    public static List<Proveedor> getProveedorList( )
    {
        List<Proveedor>proveedorList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Proveedor proveedor = null;
        
        try 
        {
            connection = getConnection( );
            if( connection == null )
            {
                return null;
            }
            statement = connection.createStatement( );
            if( statement == null )
            {
                return null;
            }
            resultSet = statement.executeQuery( "SELECT * FROM TBL_PROVEEDOR" );
            if( resultSet == null )
            {
                return null;
            }
            proveedorList = new ArrayList<>();
            while( resultSet.next() )
            {
                proveedor = new Proveedor();
                proveedor.setId_proveedor( resultSet.getInt(1) );
                proveedor.setNombre_proveedor(resultSet.getString(2) );
                proveedorList.add(proveedor);
            }
            resultSet.close();
            closeConnection(connection);
            return proveedorList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
   
}

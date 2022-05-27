/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.gerdoc.dao.Proveedor;

/**
 *
 * @author gerdoc
 */
public class ProveedorService 
{
    
    public List<Proveedor> getProveedorList( )
    {
        List<Proveedor>proveedorList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Proveedor proveedor = null;
        
        try 
        {
            connection = MySqlConnection.getConnection( );
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
            MySqlConnection.closeConnection(connection);
            return proveedorList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addProveedor( Proveedor proveedor )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO TBL_PROVEEDOR(NOMBRE_PROVEEDOR) VALUES(?)";
        int row = 0;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(1, proveedor.getNombre_proveedor());

            row = preparedStatement.executeUpdate();
            MySqlConnection.closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteProveedor( Proveedor proveedor )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM TBL_PROVEEDOR WHERE ID_PROVEEDOR = ?";
        int row = 0;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setInt(1, proveedor.getId_proveedor());
            row = preparedStatement.executeUpdate();
            MySqlConnection.closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Proveedor getProveedorById_proveedor( Integer id_proveedor )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM TBL_PROVEEDOR WHERE ID_PROVEEDOR= ?";
        Proveedor proveedor = null;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return null;
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_proveedor );
            resultSet = preparedStatement.executeQuery( );
            if( resultSet == null )
            {
                return null;
            }
            while( resultSet.next() )
            {
                proveedor = new Proveedor();
                proveedor.setId_proveedor( resultSet.getInt(1) );
                proveedor.setNombre_proveedor(resultSet.getString(2) );
            }
            resultSet.close();
            MySqlConnection.closeConnection(connection);
            return proveedor;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean updateProveedor( Proveedor proveedor )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update TBL_PROVEEDOR SET NOMBRE_PROVEEDOR=? WHERE ID_PROVEEDOR = ?";
        int row = 0;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(2, proveedor.getNombre_proveedor());
            preparedStatement.setInt(5, proveedor.getId_proveedor());
            row = preparedStatement.executeUpdate();
            MySqlConnection.closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
}

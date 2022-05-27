<%-- 
    Document   : ProveedorTable
    Created on : 13/05/2022, 01:13:16 AM
    Author     : gerdoc
--%>

<%@page import="org.gerdoc.helper.ProveedorHelper"%>
<%@page import="java.util.List"%>
<%@page import="org.gerdoc.dao.Proveedor"%>

<div class="row">
    <a href="?action=nuevo">
        <button type="button" class="btn btn-outline-primary" >Nuevo</button>
    </a>
    <br/><br/>
</div>
<%
    List<Proveedor>proveedorList = null;
    proveedorList = new ProveedorHelper( ).getList( );
    if( proveedorList == null || proveedorList.size() == 0 )
    {
%>
        <div class="row mt-4">
            <p>Lista proveedor sin datos</p>
        </div>
<%            
        return;
    }
%>
        <div class="row">
            <table class="table">
                <thead class="table-primary">
                    <tr>
                        <th>ID_PROVEEDOR</th>
                        <th>NOMBRE_PROVEEDOR</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
<%
    for( Proveedor proveedor : proveedorList)
    {
%>
                <tbody>
                    <tr>
                        <td>
                            <%=proveedor.getId_proveedor()%>
                        </td>
                       
                        <td>
                            <%=proveedor.getNombre_proveedor()%>
                        </td>
                        
                        <td>
                            <a href="?action=delete&id=<%=proveedor.getId_proveedor()%>">
                                <button type="button" class="btn btn-outline-primary ">
                                    <i class="fa fa-trash"></i>
                                </button>
                            </a>
                            <a href="?action=editar&id=<%=proveedor.getId_proveedor()%>">
                                <button type="button" class="btn btn-outline-primary ">
                                    <i class="fa fa-edit"></i>
                                </button>
                            </a>
                        </td>
                    </tr>
                </tbody>
<%
    }
%>
            </table>
        </div>
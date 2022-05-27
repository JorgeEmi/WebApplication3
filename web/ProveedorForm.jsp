<%-- 
    Document   : ProveedorForm
    Created on : 13/05/2022, 01:34:33 AM
    Author     : gerdoc
--%>
<%@page import="org.gerdoc.dao.Proveedor"%>
<%@page import="org.gerdoc.helper.ProveedorHelper"%>
<%
    Proveedor proveedor = new ProveedorHelper( ).getProveedorById_proveedor(request);
    if( proveedor == null)
    {
        proveedor = new Proveedor( );
        proveedor.setNombre_proveedor("");
    }
    
%>
<form action="ProveedorList.jsp">
    <div class="row mt-4 grey">
        
        <div class="col">
            <div class="mb-3 mt-3">
                <label for="campo2">Nombre del proveedor:</label>
                <input type="text" class="form-control" id="nombre_proveedor" placeholder="Escribe una cadena" name="nombre_proveedor" value="<%=proveedor.getNombre_proveedor()%>">
            </div>           
        </div>
    </div>
    <div class="row mt-4 grey">
        
        <%
            if(proveedor.getId_proveedor() != null && proveedor.getId_proveedor() > 0 )
            {
        %>
                <input type="hidden" id="action" name="action" value="actualizar" />
                <input type="hidden" id="id_proveedor" name="id_proveedor" value="<%=proveedor.getId_proveedor()%>" />
        <%
            }
            else
            {
        %>
                <input type="hidden" id="action" name="action" value="send" />
        <%
            }
        %>
        <div class=""input-group mb-3">
            <button type="submit" class="btn btn-primary">Enviar</button>
            <button type="reset" class="btn btn-primary">Borrar</button>
        </div>
    </div>
</form>
<br/>
<div class="row mt-6">
    <a href="?">
        <button type="button" class="btn btn-outline-primary" >Regresar</button>
    </a>
</div>

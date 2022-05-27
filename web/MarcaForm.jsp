<%-- 
    Document   : MarcaForm
    Created on : 13/05/2022, 01:34:33 AM
    Author     : gerdoc
--%>
<%@page import="org.gerdoc.dao.Marca"%>
<%@page import="org.gerdoc.helper.MarcaHelper"%>
<%
    Marca marca = new MarcaHelper( ).getMarcaById_marca(request);
    if( marca == null)
    {
        marca = new Marca( );
        marca.setMarca("");
    }
    
%>
<form action="MarcaList.jsp">
    <div class="row mt-4 grey">
        
        <div class="col">
            <div class="mb-3 mt-3">
                <label for="campo2">Nombre de la marca:</label>
                <input type="text" class="form-control" id="marca" placeholder="Escribe una cadena" name="marca" value="<%=marca.getMarca()%>">
            </div>           
        </div>
    </div>
    <div class="row mt-4 grey">
        
        <%
            if(marca.getId_marca() != null && marca.getId_marca() > 0 )
            {
        %>
                <input type="hidden" id="action" name="action" value="actualizar" />
                <input type="hidden" id="id_marca" name="id_marca" value="<%=marca.getId_marca()%>" />
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

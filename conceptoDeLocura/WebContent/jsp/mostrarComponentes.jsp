<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:hidden name="usuarioForm"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Componentes</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Lista de Componentes 2</div>
<br><br>
<table border="1" bgcolor="black" width="600px">
    <tr style="background-color: teal;color: white;text-align: center;" height="40px">
        <th><s:text name="Nombre"/></th>
        <th><s:text name="Version"/></th>
        <th><s:text name="Tipo"/></th>
        <th><s:text name="Extensión"/></th>
    </tr>
    <s:iterator value="componenteLista" status="status">
        <tr style="background-color:white;color: black;text-align: center;" height="30px" >
            <td class="nowrap"><s:property value="nombre"/></td>
            <td class="nowrap"><s:property value="version"/></td>
            <td class="nowrap"><s:property value="tipo"/></td>
            <td class="nowrap"><s:property value="extension"/></td>
        </tr>    
  </s:iterator>
</table>
<br>
<a href="volverComponenteAccion" >Agrega un nuevo componente</a>
</center>
</body>
</html>
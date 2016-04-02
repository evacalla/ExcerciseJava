<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Componentes</title>
</head>
<body>
<s:property value="usuarioForm.nombre"/>
<s:if test="hasActionMessages()">
   <div class="welcome">
      <s:actionmessage />
   </div>
</s:if>
<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
</body>
<h4>Agregar Componente</h4>
<s:form id="agregar" method="post" action="agregarComponentesAccion">
 <s:textfield  name="componenteForm.nombre" label="Nombre"/>
 <s:textfield  name="componenteForm.version" label="Version"/>
 <s:textfield  name="componenteForm.tipo" label="Tipo"/>
 <s:textfield  name="componenteForm.extension" label="Extension"/>
 <!--<s:hidden name="usuarioForm"/>-->
 <s:submit id="submit" value="Registrar" />
</s:form>
</html>
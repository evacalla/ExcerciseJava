<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proyecto Locura</title>
</head>
<body>
<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
   
<s:form id="login" method="post" action="verificarUsuarioAccion">
  <s:textfield  name="usuarioForm.nombre" label="Nombre"/>
  <s:textfield  name="usuarioForm.clave" label="Clave"/>
  <s:submit id="submit" value="Login" />
</s:form>
 
</body>
</html>
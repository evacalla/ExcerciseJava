package com.vaas.locura.action;

import java.util.List;
import java.util.Map;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vaas.locura.formulario.ComponenteForm;
import com.vaas.locura.formulario.UsuarioForm;
import com.vaas.locura.dato.ComponenteDAO;
import com.vaas.locura.dato.ComponenteDAOImpl;
 
 
 
public class ComponenteAction extends ActionSupport{
 private static final long serialVersionUID = 1L;
 private ComponenteDAO componenteDAO= new ComponenteDAOImpl();
 private ComponenteForm componenteForm;
 private List<ComponenteForm> componenteLista;
  
 String mensaje=null;
  
 @Action( value="agregarComponentesAccion", results= {
   @Result(name=SUCCESS, type="dispatcher", location="/jsp/mostrarComponentes.jsp"), 
   @Result(name=ERROR, type="dispatcher", location="/jsp/agregarComponentes.jsp") } )
 public String agregarComponentes() {
  ActionContext contexto = ActionContext.getContext();
  Map<String, Object> sesion = contexto.getSession();
  UsuarioForm usuarioForm=(UsuarioForm) sesion.get("usuarioForm");
  System.out.println("Ingreso a guardar componente");
     if("".equals(componenteForm.getNombre())||"".equals(componenteForm.getTipo())||"".equals(componenteForm.getVersion())||
       "".equals(componenteForm.getExtension())){
      System.out.println("Faltan datos al componente");
      mensaje="Faltan datos al componente";
      addActionMessage("Usuario Correcto: "+usuarioForm.getNombre());
      addActionError(mensaje);
      return ERROR;
     }
     else{
   componenteDAO.addComponente(componenteForm);
   System.out.println("Componente guardado");
   componenteLista=componenteDAO.getComponente();
   return SUCCESS;
     }
 }
  
 @Action( value="volverComponenteAccion", results= {
   @Result(name=SUCCESS, type="dispatcher", location="/jsp/agregarComponentes.jsp")})
 public String volverComponente() {
  ActionContext contexto = ActionContext.getContext();
  Map<String, Object> sesion = contexto.getSession();
  UsuarioForm usuarioForm=(UsuarioForm) sesion.get("usuarioForm");
  addActionMessage("Usuario Correcto: "+usuarioForm.getNombre());
  return SUCCESS;
 }
 
 public ComponenteForm getComponenteForm() {
  return componenteForm;
 }
 
 public List<ComponenteForm> getComponenteLista() {
  return componenteLista;
 }
 
 public void setComponenteLista(List<ComponenteForm> componenteLista) {
  this.componenteLista = componenteLista;
 }
 
 public void setComponenteForm(ComponenteForm componenteForm) {
  this.componenteForm = componenteForm;
 }
  
}

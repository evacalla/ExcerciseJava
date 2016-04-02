package com.vaas.locura.action;

import com.vaas.locura.formulario.UsuarioForm;
import org.apache.struts2.convention.annotation.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

 public class UsuarioAction extends ActionSupport implements SessionAware{
   
 private static final long serialVersionUID = 1L;
  //Con esto indicamos que nuestro Usuario y clave seran Usuario y Clave respectivamente
     private static UsuarioForm usuario = new UsuarioForm("Enzo","Vacalla");
     private UsuarioForm usuarioForm;
     private Map<String, Object> sesion;
     //private static ComponenteForm componenteForm = new ComponenteForm();     
 
      @Action( value="LOGIN", results= {
        @Result(name=SUCCESS, type="dispatcher", location="/jsp/login.jsp") } )
  public String inicializarUsuario() {
    
   //usuarioForm=new UsuarioForm();
      System.out.println("Si hemos llegado aqui quiere decir que la pagina index.jsp ha invocado a este metodo inicializarUsuario");
      addActionMessage("Ingrese Usuario");
      return SUCCESS;
     }
      @Action( value="verificarUsuarioAccion", results= {
        @Result(name=SUCCESS, type="dispatcher", location="/jsp/agregarComponentes.jsp"), 
        @Result(name=ERROR, type="dispatcher", location="/jsp/login.jsp") } )     
     public String verificarUsuario() {
         String mensaje=null;
      System.out.println("Si hemos llegado aqui quiere decir que la pagina login.jsp ha invocado a este metodo verificarUsuario");
      if("".equals(usuarioForm.getNombre())||"".equals(usuarioForm.getClave())){
        System.out.println("Se coloco el usuario y clave vacios");
        mensaje="Debe de llenar los campos de Usuario y Clave";
        addActionError(mensaje);
        return ERROR;
      }
      else if(usuario.getNombre().equals(UsuarioAction.usuario.getNombre())&&usuarioForm.getClave().equals(UsuarioAction.usuario.getClave())){
       System.out.println("Se coloco al usuario y clave correctamente y va a la pagina de agregarComponentes");
       sesion.put("usuarioForm", usuarioForm);
       addActionMessage("Usuario Correcto: "+usuarioForm.getNombre());
       return SUCCESS;
      }
      else{
       System.out.println("Se coloco al usuario y clave incorrectamente y regresamos a la pagina de login con el mensaje de Usuario Incorrecto");
       mensaje="Usuario Incorrecto";
       addActionError(mensaje);
       return ERROR;
      }
     }
 
  public Map<String, Object> getSession() {
   return sesion;
  }
 
  public void setSession(Map<String, Object> sesion) {
   this.sesion = sesion;
  }
 
     public UsuarioForm getUsuarioForm() {
   return usuarioForm;
  }
 
  public void setUsuarioForm(UsuarioForm usuarioForm) {
   this.usuarioForm = usuarioForm;
  }
 
}
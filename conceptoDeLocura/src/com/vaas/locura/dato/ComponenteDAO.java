package com.vaas.locura.dato;
import  com.vaas.locura.formulario.ComponenteForm;
import java.util.List;

public interface ComponenteDAO {
 public void addComponente(ComponenteForm componente);
 public List<ComponenteForm> getComponente();
}

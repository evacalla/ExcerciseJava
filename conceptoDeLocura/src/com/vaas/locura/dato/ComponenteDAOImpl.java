package com.vaas.locura.dato;
import java.util.ArrayList;
import java.util.List;
import com.vaas.locura.formulario.ComponenteForm;
 
public class ComponenteDAOImpl implements ComponenteDAO {
 private static List<ComponenteForm> listaComponentes=new ArrayList<ComponenteForm>();
 @Override
 public void addComponente(ComponenteForm componente) {
  listaComponentes.add(componente);
 }
 
 @Override
 public List<ComponenteForm> getComponente() {
  return listaComponentes;
 }
}
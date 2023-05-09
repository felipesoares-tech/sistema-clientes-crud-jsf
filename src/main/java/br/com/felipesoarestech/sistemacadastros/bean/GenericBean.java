package br.com.felipesoarestech.sistemacadastros.bean;

import br.com.felipesoarestech.sistemacadastros.logic.GenericLogic;
import br.com.felipesoarestech.sistemacadastros.util.BeanUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import lombok.Getter;
import java.util.logging.Logger;
import java.util.logging.Level;

public abstract class GenericBean<E, L extends GenericLogic<E>> extends BeanUtil {
    @Getter
    private E entity;
    @Getter
    private List<E> entitys;
    
    public void newInstanceOfEntity(){
        try {
            entity = (E) getClassEntity().getConstructors()[0].newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(GenericBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String novo(){
        newInstanceOfEntity();
        return "cliente";
    }
  
    public void salvar(){
        getLogic().salvar(entity);
        addInfo("Salvo com sucesso.");
        newInstanceOfEntity();
        listar();
    }
    
    
    public void listar(){
        entitys = getLogic().listar();
    }
    
    public void remover(E entity){
        getLogic().remover(entity);
        addInfo("Removido com sucesso.");
    }
    public void editar(E entity) {
        this.entity = entity;
    }
    public abstract L getLogic();
    public abstract Class<E> getClassEntity();
    
}
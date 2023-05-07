package br.com.felipesoarestech.sistemacadastros.bean;

import br.com.felipesoarestech.sistemacadastros.entity.Cliente;
import br.com.felipesoarestech.sistemacadastros.logic.ClienteLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ClienteBean extends GenericBean<Cliente, ClienteLogic>{

    @Inject
    private ClienteLogic logic;
    
    @Override
    public ClienteLogic getLogic() {
        return logic;
    }

    @Override
    public Class<Cliente> getClassEntity() {
        return Cliente.class;
    }
    
}

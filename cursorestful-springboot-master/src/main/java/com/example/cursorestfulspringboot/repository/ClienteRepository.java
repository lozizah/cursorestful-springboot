package com.example.cursorestfulspringboot.repository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import com.example.cursorestfulspringboot.model.Cliente;
import org.springframework.stereotype.Component;

//Indica que a classe é um componente da aplicação
//Spring que gerencia o objeto
@Component
public class ClienteRepository {
    
    private List<Cliente> clientes;
    private int nextCode;

    //Anotações
    @PostConstruct
    public void criarClientes(){

        //Variavel
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();

        c1.setCodigo(1);
        c1.setNome("Jose");
        c1.setEndereco("Rua X, 99");
        c1.setSaldo(190);

        c2.setCodigo(2);
        c2.setNome("Maria");
        c2.setEndereco("Rua Y, 222");
        c2.setSaldo(333);

        c3.setCodigo(3);
        c3.setNome("Fernanda");
        c3.setEndereco("Rua Z, 44");
        c3.setSaldo(666);

        clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        nextCode = 4;
    }
    
    public List<Cliente> getAllClientes(){
        return clientes;
    }

    public Cliente getClienteByCodigo(int codigo){
        for(Cliente aux : clientes){
            if(aux.getCodigo() == codigo){
                return aux;
            }   
        }
        return null;
    }

    public Cliente save(Cliente cliente){
        cliente.setCodigo(nextCode++);
        clientes.add(cliente);
        return cliente;
    }

	public void remove(Cliente cliente) {
        clientes.remove(cliente);
	}

    //Atualizar
	public Cliente update(Cliente cliente) {
        
        Cliente aux = getClienteByCodigo(cliente.getCodigo());

        if (aux !=null){
            aux.setEndereco(cliente.getEndereco());
            aux.setNome(cliente.getNome());
            aux.setSaldo(cliente.getSaldo());
        }
        return aux;
	}


}

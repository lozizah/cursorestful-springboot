package com.example.cursorestfulspringboot.controller;
import java.util.List;
import com.example.cursorestfulspringboot.model.Cliente;
import com.example.cursorestfulspringboot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    //Anotações
    //Injetar o componente
    @Autowired
    private ClienteRepository repositorio;
    
    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return repositorio.getAllClientes();
    }

    @GetMapping("/clientes/{codigo}")
    public Cliente getCliente(@PathVariable int codigo){
        return repositorio.getClienteByCodigo(codigo);
    }

    //Recurso para o /clientes
    //PostMapping - Enviar dados
    //RequestCoby - Pegar os dados e mapear
    @PostMapping("/clientes")
    public Cliente salvar(@RequestBody Cliente cliente){
        return repositorio.save(cliente);
    }
}
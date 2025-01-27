package com.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Invoice {
    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String description;
    
    @Autowired
    @Qualifier("default")
    private List<Item> items;

    @PostConstruct
    public void init() {
        System.out.println("Creando el componente de la factura");
        System.out.println("Cliente: " + client.getName());
        client.setName( client.getName().concat(" Pepe"));
        client.setLastname( "Lopez");
        description = description.concat(" del cliente: ").concat(client.getName()).concat(" ").concat(client.getLastname());
    }


    public double getTotal(){
        return items.stream()
        .map(item -> item.getImporte())
        .reduce(0.0, (sum, importe) -> sum + importe);
    }
}

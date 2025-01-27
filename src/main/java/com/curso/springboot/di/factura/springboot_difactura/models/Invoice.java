package com.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Invoice {
    @Autowired
    private Client client;
    
    @Autowired
    @Qualifier("default")
    private List<Item> items;

    @Value("${invoice.description}")
    private String description;

    public double getTotal(){
        return items.stream()
        .map(item -> item.getImporte())
        .reduce(0.0, (sum, importe) -> sum + importe);
    }
}

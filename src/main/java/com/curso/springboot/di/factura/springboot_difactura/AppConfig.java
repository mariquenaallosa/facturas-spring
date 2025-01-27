package com.curso.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    // devuelve un tipo list de Item
    @Bean
    List<Item> itemsInvoice (){
        Product p1 = new Product("Camara Sony", 800.00);
        Product p2 = new Product("Bicicleta Bianchi", 200.00);
        return Arrays.asList(new Item(p1,2), new Item(p2,4));
    }

    @Bean("default")
    List<Item> itemsInvoicOffice (){
        Product p1 = new Product("Notebook Razer", 4000.00);
        Product p2 = new Product("Monitor Asus 31", 1200.00);
        Product p3 = new Product("Monitor Acer 24", 800.00);
        Product p4 = new Product("Mouse Redragon", 50.00);
        return Arrays.asList(new Item(p1,2), new Item(p2,4), new Item(p3,2), new Item(p4,5));
    }
}

package com.curso.springboot.di.factura.springboot_difactura.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
 private Product product;
 private Integer quantity;

 public double getImporte(){
    return product.getPrice() * quantity;
 }
}



package com.javaproject.Ecommerce.Cart;

import com.javaproject.Ecommerce.Customer.Customer;
import com.javaproject.Ecommerce.Products.Product;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  int itemQuantity;
    @ManyToOne
    private Cart cartId;
    @OneToOne
    private Product product;


}

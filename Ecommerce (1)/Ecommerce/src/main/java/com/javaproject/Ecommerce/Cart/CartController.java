package com.javaproject.Ecommerce.Cart;

import com.javaproject.Ecommerce.Customer.Customer;
import com.javaproject.Ecommerce.DTO.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    //get all the carts
    @GetMapping("")
    public ResponseEntity<List<Cart>> getAllCarts(){
        return new ResponseEntity<>(cartService.getAllCarts(), HttpStatus.OK);
    }
    @PostMapping("/create-cart")
    public ResponseEntity<Object> createCart(@RequestBody CartDto cartDto){

        var cart = cartService.createCart(cartDto);
        if(Boolean.TRUE.equals(cart.get("isSuccess"))){
            return ResponseEntity.ok(cart.get("message"));
        }else
            return ResponseEntity.badRequest().body(cart.get("message"));

    }

}

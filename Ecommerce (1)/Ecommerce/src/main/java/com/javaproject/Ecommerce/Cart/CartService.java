package com.javaproject.Ecommerce.Cart;

import com.javaproject.Ecommerce.Customer.Customer;
import com.javaproject.Ecommerce.Customer.CustomerRepository;
import com.javaproject.Ecommerce.DTO.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
     private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;


    public List<Cart> getAllCarts() {
       return cartRepository.findAll();
    }

    public HashMap<String,Object> createCart(CartDto cartDto){
        HashMap<String,Object> response = new HashMap<>();
        HashMap<String,Object> response1= new HashMap<>();
        Cart cart ;
        cart=cartRepository.findById(cartDto.getCustomerId()).orElse(null);
        if(cart==null){
            Customer customer =customerRepository.findById(cartDto.getCustomerId()).orElse(null);
            if(customer==null){
                response1.put("message","incorrect customer id "+cartDto.getCustomerId());
                response.put("isSuccess",false);
                response.put("message",response1);
                return  response;
            }
            response1.put("message","customer id"+cartDto.getCustomerId()+" is already exists!");
            response.put("isSuccess",true);
            response.put("message",response1);
            cart = new Cart();
            cart.setQuantity(cartDto.getQuantity());
            cart.setCustomer(customer);
            cart= cartRepository.save(cart);
            response.put("isSuccess",true);
            response.put("message",cart);
            return  response;
        }
        response.put("isSuccess",true);
        response.put("message",cart);
        return  response;
    }


}

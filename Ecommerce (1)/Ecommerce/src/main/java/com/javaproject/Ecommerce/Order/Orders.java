package com.javaproject.Ecommerce.Order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javaproject.Ecommerce.Customer.Customer;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @CreatedDate
    private LocalDateTime date;



}

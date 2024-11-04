package br.edu.utfpr.pb.pw44s.server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne                                                      //DUVIDA
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne                                                      //DUVIDA
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private Date orderDate;

}

package br.edu.utfpr.pb.pw44s.server.dto;

import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
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

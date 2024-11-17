package br.edu.utfpr.pb.pw44s.server.dto;

import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "address_id", referencedColumnName = "id")
        private Address address;

        @NotNull
        private Date orderDate;

        @NotNull
        private String payment;

        @NotNull
        private String shipping;

        List<OrderItemsDTO> ItemsList;
}

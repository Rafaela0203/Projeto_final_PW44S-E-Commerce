package br.edu.utfpr.pb.pw44s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_orderItems")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {
    @EmbeddedId
    private OrderItemsId orderItemsId;

    @NotNull
    private BigDecimal price;

    @NotNull
    private int quantity;
}

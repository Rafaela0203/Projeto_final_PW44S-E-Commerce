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
//    @EmbeddedId
////    private OrderItemsId orderItemsId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order orderId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product productId;

    @NotNull
    private BigDecimal price;

    @NotNull
    private int quantity;
}

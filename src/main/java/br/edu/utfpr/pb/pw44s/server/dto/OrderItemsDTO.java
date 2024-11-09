package br.edu.utfpr.pb.pw44s.server.dto;

import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.OrderItemsId;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsDTO {
    @EmbeddedId
    private OrderItemsId orderItemsId;

    private BigDecimal price;

    private int quantity;
}

package br.edu.utfpr.pb.pw44s.server.dto.response;

import br.edu.utfpr.pb.pw44s.server.model.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponseOrderItemsDTO {

    private Product productId; //seria productId ou só product?

    private BigDecimal price;

    private int quantity;
}

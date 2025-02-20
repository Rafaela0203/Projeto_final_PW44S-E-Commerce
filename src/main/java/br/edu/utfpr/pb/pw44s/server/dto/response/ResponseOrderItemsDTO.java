package br.edu.utfpr.pb.pw44s.server.dto.response;

import br.edu.utfpr.pb.pw44s.server.model.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponseOrderItemsDTO {
    public Long id;

    private Long productId;

    private String productName;

    private BigDecimal price;

    private int quantity;
}

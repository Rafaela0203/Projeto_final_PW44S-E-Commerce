package br.edu.utfpr.pb.pw44s.server.dto.response;

import br.edu.utfpr.pb.pw44s.server.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponseProductDTO {
    private String name;

    private String brand;

    private String description;

    private BigDecimal price;

    private String details;

    private int quantity;

    private String ingredients;

    private String image;

    private Category category;
}

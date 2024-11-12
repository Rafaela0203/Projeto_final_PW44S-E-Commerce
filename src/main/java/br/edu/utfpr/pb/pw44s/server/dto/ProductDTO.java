package br.edu.utfpr.pb.pw44s.server.dto;

import br.edu.utfpr.pb.pw44s.server.model.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;

    @NotNull
    @Size(max = 30)
    private String name;

    @NotNull
    private String brand;

    @NotNull
    @Size(max = 80)
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    @Size(min = 100)
    private String details;

    @NotNull
    private int quantity;

    @NotNull
    private String ingredients;

    @NotNull
    @Pattern(regexp = "^(https?|ftp)://.*$", message = "A URL da imagem deve ser válida.")
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
}

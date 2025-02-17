package br.edu.utfpr.pb.pw44s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_product")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30)
    private String name;

    @NotNull
    private String brand;

    @NotNull
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    @Column(length = 1024)
    private String details;

    @NotNull
    private int quantity;

    @NotNull
    private String ingredients;

    @NotNull
    @Pattern(regexp = "^(https?|ftp)://.*$", message = "A URL da imagem deve ser válida.")
    @Column(length = 512)
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
}
package br.edu.utfpr.pb.pw44s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull( message = "O CEP é obrigatório.")
    private String zip;

    @NotNull(message = "A rua é obrigatória.")
    @Size(max = 100)
    private String street;

    @NotNull(message = "O número é obrigatório.")
    private Integer number;

    @Size(max = 50)
    private String complement;

    @NotNull(message = "O bairro é obrigatório.")
    @Size(max = 100)
    private String neighborhood;

    @NotNull(message = "A cidade é obrigatória.")
    @Size(max = 100)
    private String city;

    @NotNull
    @Size(max = 2)
    private String state;

    @NotNull(message = "O país é obrigatório.")
    @Size(max = 100)
    private String country;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}

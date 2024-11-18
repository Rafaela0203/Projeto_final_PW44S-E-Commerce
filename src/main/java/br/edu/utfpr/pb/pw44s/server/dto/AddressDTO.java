package br.edu.utfpr.pb.pw44s.server.dto;

import br.edu.utfpr.pb.pw44s.server.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long id;

    @NotNull
    private String zip;

    @NotNull
    @Size(max = 100)
    private String street;

    @NotNull
    private Integer number;

    @Size(max = 50)
    private String complement;

    @NotNull
    @Size(max = 100)
    private String neighborhood;

    @NotNull
    @Size(max = 100)
    private String city;

    @NotNull
    @Size(max = 2)
    private String state;

    @NotNull
    @Size(max = 100)
    private String country;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}

package br.edu.utfpr.pb.pw44s.server.dto;

import br.edu.utfpr.pb.pw44s.server.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Zip;
    private String Street;
    private int Number;
    private String Complement;
    private String Neighborhood;
    private String City;
    private String State;
    private String Country;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}

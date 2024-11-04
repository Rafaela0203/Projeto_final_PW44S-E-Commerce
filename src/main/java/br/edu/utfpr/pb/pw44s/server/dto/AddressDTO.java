package br.edu.utfpr.pb.pw44s.server.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}

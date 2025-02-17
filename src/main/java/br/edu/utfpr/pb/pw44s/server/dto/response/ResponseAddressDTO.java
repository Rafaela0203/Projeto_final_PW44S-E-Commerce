package br.edu.utfpr.pb.pw44s.server.dto.response;

import lombok.Data;

@Data
public class ResponseAddressDTO {
    private Long id;

    private String zip;

    private String street;

    private Integer number;

    private String complement;

    private String neighborhood;

    private String city;

    private String state;

    private String country;
}

package br.edu.utfpr.pb.pw44s.server.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseUserDTO {
    private Long id;

    private String email;

    private String name;

    private LocalDate birthDate;

    private String gender;

    private String phone;
}

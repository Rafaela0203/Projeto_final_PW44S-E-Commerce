package br.edu.utfpr.pb.pw44s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O atributo usuário não pode ser nulo.")
    @Size(min = 4, max = 50)
    private String email;

    @NotNull
    @Size(min = 4, max = 50)
    private String name;

    @NotNull
    @Size(min = 6)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;

    @NotNull
    @Size(max = 14)                                                                 //DUVIDA
    private String cpf;

    @NotNull
    private Date birthDate;

    @NotNull
    private String gender;

    @NotNull
    private String phone;

//    @OneToMany                                                                 //DUVIDA
//    @JoinColumn(name = "adress_id", referencedColumnName = "id");
//    private List<Address> addresses;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
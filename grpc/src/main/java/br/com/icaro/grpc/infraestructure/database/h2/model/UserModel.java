package br.com.icaro.grpc.infraestructure.database.h2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@Getter
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    public UserModel(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

package br.com.icaro.grpc.infraestructure.database.h2.repository;

import br.com.icaro.grpc.infraestructure.database.h2.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}

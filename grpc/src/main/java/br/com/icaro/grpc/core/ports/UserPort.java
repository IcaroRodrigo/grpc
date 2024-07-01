package br.com.icaro.grpc.core.ports;

import br.com.icaro.grpc.core.model.UserCore;
import br.com.icaro.grpc.core.model.UserCoreOut;

import java.util.List;

public interface UserPort {

    public UserCoreOut createUser(String name, String email);

    public List<UserCoreOut> getAllUsers();
}

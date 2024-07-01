package br.com.icaro.grpc.core.ports;

import br.com.icaro.grpc.core.model.UserCore;
import br.com.icaro.grpc.core.model.UserCoreOut;

import java.util.List;

public interface DataBasePort {
    public UserCoreOut save(UserCore user);

    public List<UserCoreOut> findAll();
}

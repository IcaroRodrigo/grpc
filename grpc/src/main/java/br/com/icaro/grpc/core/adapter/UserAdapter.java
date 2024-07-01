package br.com.icaro.grpc.core.adapter;

import br.com.icaro.grpc.core.model.UserCore;
import br.com.icaro.grpc.core.model.UserCoreOut;
import br.com.icaro.grpc.core.ports.DataBasePort;
import br.com.icaro.grpc.core.ports.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdapter  implements UserPort {

    DataBasePort dataBasePort;
    public UserAdapter(DataBasePort dataBasePort){
        this.dataBasePort = dataBasePort;
    }
    @Override
    public UserCoreOut createUser(String name, String email) {
        UserCoreOut userSaved = dataBasePort.save(new UserCore(name,email));
        return userSaved;
    }

    @Override
    public List<UserCoreOut> getAllUsers() {
        List<UserCoreOut> userCoreOut = dataBasePort.findAll();
        return userCoreOut;
    }
}

package br.com.icaro.grpc.infraestructure.database.h2.adapter;

import br.com.icaro.grpc.core.model.UserCore;
import br.com.icaro.grpc.core.model.UserCoreOut;
import br.com.icaro.grpc.core.ports.DataBasePort;
import br.com.icaro.grpc.infraestructure.database.h2.mapper.UserModelFactory;
import br.com.icaro.grpc.infraestructure.database.h2.model.UserModel;
import br.com.icaro.grpc.infraestructure.database.h2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class H2Adapter implements DataBasePort {
    UserRepository userRepository;
    public H2Adapter(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserCoreOut save(UserCore user) {
        UserModel userModel = UserModelFactory.convertToUserModel(user);
        UserModel usuerSaved = userRepository.save(userModel);

        return UserModelFactory.convertToUserCoreOut(usuerSaved);
    }

    @Override
    public List<UserCoreOut> findAll() {
        List<UserModel> userModels = userRepository.findAll();
        List<UserCoreOut> userCoreOuts = UserModelFactory.convertUserModelListToUserCoreOutList(userModels);

        return userCoreOuts;
    }
}

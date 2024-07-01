package br.com.icaro.grpc.infraestructure.database.h2.mapper;

import br.com.icaro.grpc.core.model.UserCore;
import br.com.icaro.grpc.core.model.UserCoreOut;
import br.com.icaro.grpc.entrypoint.dto.UserResponseDto;
import br.com.icaro.grpc.infraestructure.database.h2.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserModelFactory {
    public static UserModel convertToUserModel(UserCore userCore) {
        return new UserModel(userCore.nome(), userCore.email());
    }

    public static UserCoreOut convertToUserCoreOut(UserModel userModel) {
        return new UserCoreOut(userModel.getId(), userModel.getName(), userModel.getEmail());
    }

    public static List<UserCoreOut> convertUserModelListToUserCoreOutList(List<UserModel> userModels) {
        List<UserCoreOut> userCoreOut = null;
        if (userModels != null) {
            userCoreOut = userModels.stream()
                    .map(userModel -> convertToUserCoreOut(userModel)).
                    collect(Collectors.toList());

        }
        return userCoreOut;
    }
}

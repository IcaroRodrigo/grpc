package br.com.icaro.grpc.entrypoint.mapper;


import br.com.icaro.grpc.core.model.UserCore;
import br.com.icaro.grpc.core.model.UserCoreOut;
import br.com.icaro.grpc.entrypoint.dto.UserResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserResponseFactory {
    public static UserResponseDto convertToUserResponse(UserCoreOut userCoreOut) {
        return new UserResponseDto(userCoreOut.id(), userCoreOut.nome(), userCoreOut.email());
    }

    public static List<UserResponseDto> convertUserCoreListToUserResponseList(List<UserCoreOut> userCoreOuts) {
        List<UserResponseDto> userResponseDtos = null;
        if (userCoreOuts != null) {
            userResponseDtos = userCoreOuts.stream()
                    .map(userCoreOut -> convertToUserResponse(userCoreOut)).
                    collect(Collectors.toList());
        }
        return userResponseDtos;
    }

}

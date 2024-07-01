package br.com.icaro.grpc.entrypoint.controller;

import br.com.icaro.grpc.core.ports.UserPort;
import br.com.icaro.grpc.entrypoint.dto.UserResponseDto;
import br.com.icaro.grpc.entrypoint.mapper.UserResponseFactory;
import br.com.icaro.grpc.v1.user.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
public class UserController extends UserServiceGrpc.UserServiceImplBase {
    UserPort userPort;
    public UserController(UserPort userPort) {
        this.userPort = userPort;
    }

    public UserController() {}
    @Override
    public void createUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        UserResponseDto userResponse = UserResponseFactory.convertToUserResponse(userPort.createUser(request.getName(), request.getEmail()));
        //todo: Deixar a conversão do userResponseDto para UserResponse no UserResponseFactory
        UserResponse ueserRes = UserResponse.newBuilder().setId(userResponse.id()).setName(userResponse.name()).setEmail(userResponse.email()).build();
        responseObserver.onNext(ueserRes);
        responseObserver.onCompleted();

    }

    @Override
    public void getAllUsers(EmptyRequest request, StreamObserver<UserListResponse> responseObserver) {
        List<UserResponseDto> userResponseDtos = UserResponseFactory.convertUserCoreListToUserResponseList(userPort.getAllUsers());
        List<UserResponse> userResponseList =  userResponseDtos.stream().map(userResponse -> UserResponse.newBuilder().setId(userResponse.id()).setName(userResponse.name()).setEmail(userResponse.email()).build()).toList();
        responseObserver.onNext(UserListResponse.newBuilder().addAllUsers(userResponseList).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getAllUsersStream(EmptyRequest request, StreamObserver<UserResponse> responseObserver) {
        List<UserResponseDto> userResponseDtos = UserResponseFactory.convertUserCoreListToUserResponseList(userPort.getAllUsers());
        userResponseDtos.forEach(userResponse -> {
           UserResponse user =  UserResponse.newBuilder()
                   .setId(userResponse.id())
                   .setName(userResponse.name())
                   .setEmail(userResponse.email())
                   .build();

           responseObserver.onNext(user);

       });
        responseObserver.onCompleted();
    }
}

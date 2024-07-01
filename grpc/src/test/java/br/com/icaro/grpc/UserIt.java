package br.com.icaro.grpc;


import br.com.icaro.grpc.core.ports.UserPort;
import br.com.icaro.grpc.entrypoint.controller.UserController;
import br.com.icaro.grpc.v1.user.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class UserIt {

    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();

    @Autowired
    private UserPort userPort;
    private Server server;
    private ManagedChannel channel;

    @BeforeEach
    void setUp() throws IOException {
        // Cria um servidor gRPC em memória
        String serverName = InProcessServerBuilder.generateName();
        server = InProcessServerBuilder.forName(serverName)
                .directExecutor()
                .addService(new UserController(userPort))
                .build()
                .start();

        // Registra o servidor para limpeza
        grpcCleanup.register(server);

        // Cria um canal gRPC em memória
        channel = InProcessChannelBuilder.forName(serverName)
                .directExecutor()
                .build();

        // Registra o canal para limpeza
        grpcCleanup.register(channel);
    }

    @AfterEach
    void tearDown() {
        if (server != null) {
            server.shutdownNow();
        }
        if (channel != null) {
            channel.shutdownNow();
        }
    }

    @Test
    @Order(1)
    void createUser_shouldReturnUserResponse() {
        UserServiceGrpc.UserServiceBlockingStub blockingStub = UserServiceGrpc.newBlockingStub(channel);

        UserRequest request = UserRequest.newBuilder()
                .setName("João da silva")
                .setEmail("joao.silva@gmail.com")
                .build();

        UserResponse response = blockingStub.createUser(request);
        System.out.println(response);
        assertEquals(1, response.getId());
        assertEquals("João da silva", response.getName());
        assertEquals("joao.silva@gmail.com", response.getEmail());
    }

    @Test
    @Order(2)
    void getUser_shouldReturnListOfUserResponse() {

        UserServiceGrpc.UserServiceBlockingStub blockingStub = UserServiceGrpc.newBlockingStub(channel);

        UserRequest request = UserRequest.newBuilder()
                .setName("Ícaro")
                .setEmail("icaro.rori@gmail.com")
                .build();

        blockingStub.createUser(request);
        blockingStub.createUser(request);
        blockingStub.createUser(request);

        UserListResponse userListResponse = blockingStub.getAllUsers(EmptyRequest.newBuilder().build());
        assertEquals(4, userListResponse.getUsersList().size());
        assertNotNull(userListResponse.getUsersList());
        assertEquals("João da silva", userListResponse.getUsersList().get(0).getName());


    }
}

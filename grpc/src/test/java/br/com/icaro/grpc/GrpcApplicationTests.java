package br.com.icaro.grpc;

import br.com.icaro.grpc.core.adapter.UserAdapter;
import br.com.icaro.grpc.core.model.UserCore;
import br.com.icaro.grpc.core.model.UserCoreOut;
import br.com.icaro.grpc.core.ports.DataBasePort;
import br.com.icaro.grpc.core.ports.UserPort;
import br.com.icaro.grpc.entrypoint.dto.UserResponseDto;
import br.com.icaro.grpc.entrypoint.mapper.UserResponseFactory;
import br.com.icaro.grpc.v1.user.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GrpcApplicationTests {

	@MockBean
	UserPort userPort;

	@MockBean
	DataBasePort dataBasePort;

	@Test
	void createUser_shouldReturnUserResponseDto() {
		UserCoreOut mockUser = new UserCoreOut(1l,"Ícaro","icaro.rori@gmail.com");
		when(userPort.createUser("Ícaro", "icaro.rori@gmail.com")).thenReturn(mockUser);
		UserResponseDto userResponse = UserResponseFactory.convertToUserResponse(userPort.createUser("Ícaro", "icaro.rori@gmail.com"));
		assertEquals(1,userResponse.id());
		assertEquals("Ícaro",userResponse.name());
		assertEquals("icaro.rori@gmail.com",userResponse.email());
	}

	@Test
	void createUser_shouldReturnUserResponse() {
		UserCoreOut mockUser = new UserCoreOut(1l,"Ícaro","icaro.rori@gmail.com");
		when(userPort.createUser("Ícaro", "icaro.rori@gmail.com")).thenReturn(mockUser);
		UserResponseDto userResponse = UserResponseFactory.convertToUserResponse(userPort.createUser("Ícaro", "icaro.rori@gmail.com"));
		UserResponse ueserRes = UserResponse.newBuilder().setId(userResponse.id()).setName(userResponse.name()).setEmail(userResponse.email()).build();
		assertEquals(1,ueserRes.getId());
		assertEquals("Ícaro",ueserRes.getName());
		assertEquals("icaro.rori@gmail.com",ueserRes.getEmail());
		assertNotNull(ueserRes);
	}

	@Test
	void createUserAdapter_shouldReturnUserCoreOut() {
		String nome = "Ícaro";
		String email = "icaro.rori@gmail.com";
		UserCore userCore = new UserCore(nome,email);
		UserCoreOut mockUser = new UserCoreOut(1l,"Ícaro","icaro.rori@gmail.com");
		when(dataBasePort.save(userCore)).thenReturn(mockUser);

		UserAdapter userAdapter = new UserAdapter(dataBasePort);
		UserCoreOut userCoreOut =  userAdapter.createUser(nome, email);

		assertEquals(1,userCoreOut.id());
		assertEquals("Ícaro",userCoreOut.nome());
		assertEquals("icaro.rori@gmail.com",userCoreOut.email());
		assertNotNull(userCoreOut);
	}


	@Test
	void getAllUserAdapter_shouldReturnListOfUserCoreOut() {

		List<UserCoreOut> listMockUser = new ArrayList<>();
		listMockUser.add(new UserCoreOut(1l,"Ícaro","icaro.rori@gmail.com"));
		listMockUser.add(new UserCoreOut(2l,"Jurema","jurema@gmail.com"));
		listMockUser.add(new UserCoreOut(3l,"Vera","vera@gmail.com"));

		when(dataBasePort.findAll()).thenReturn(listMockUser);

		UserAdapter userAdapter = new UserAdapter(dataBasePort);
		List<UserCoreOut> userCoreOutList =  userAdapter.getAllUsers();

		assertEquals(3,userCoreOutList.size());
		assertEquals("Jurema",userCoreOutList.get(1).nome());
		assertNotNull(userCoreOutList);
	}





}

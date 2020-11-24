package at.uibk.dps.socketutils.resourcemanager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import at.uibk.dps.socketutils.entity.FunctionDetails;
import at.uibk.dps.socketutils.resourcemanager.RequestResourceManager.RequestType;

public class UtilsSocketResourceManagerTest {

	@Test
	public void testReqAll() {
		String myFunc = "myFunc";
		RequestResourceManagerAll result = UtilsSocketResourceManager.generateRequestAll(myFunc);
		assertEquals(myFunc, result.getFunctionType());
		assertEquals(RequestType.GET_ALL_RESOURCES, result.getRequestType());
	}

	@Test
	public void testReqFree() {
		String myFunc = "myFunc";
		RequestResourceManagerFree result = UtilsSocketResourceManager.generateRequestFree(myFunc);
		assertEquals(myFunc, result.getFunctionType());
		assertEquals(RequestType.GET_FREE_RESOURCES, result.getRequestType());
	}

	@Test
	public void testResp() {
		FunctionDetails funcDetMock1 = mock(FunctionDetails.class);
		FunctionDetails funcDetMock2 = mock(FunctionDetails.class);
		List<FunctionDetails> funcDetList = new ArrayList<>(Arrays.asList(funcDetMock1, funcDetMock2));
		ResponseResourceManager result = UtilsSocketResourceManager.generateResponse(funcDetList);
		assertEquals(funcDetList, result.getFilteredImplementations());
	}
}

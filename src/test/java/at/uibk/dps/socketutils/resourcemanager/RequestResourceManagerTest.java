package at.uibk.dps.socketutils.resourcemanager;

import static org.junit.Assert.*;

import org.junit.Test;

import at.uibk.dps.socketutils.resourcemanager.RequestResourceManager.RequestType;

import static org.mockito.Mockito.mock;

public class RequestResourceManagerTest {

	@Test
	public void test() {
		String funcType = "myFunctionType";
		RequestType reqMock = mock(RequestType.class);
		RequestResourceManager tested = new  RequestResourceManager(funcType, reqMock);
		assertEquals(funcType, tested.getFunctionType());
		assertEquals(reqMock, tested.getRequestType());
	}
}

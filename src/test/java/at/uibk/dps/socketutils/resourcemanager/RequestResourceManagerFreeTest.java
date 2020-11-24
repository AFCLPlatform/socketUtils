package at.uibk.dps.socketutils.resourcemanager;

import static org.junit.Assert.*;

import org.junit.Test;

import at.uibk.dps.socketutils.resourcemanager.RequestResourceManager.RequestType;

public class RequestResourceManagerFreeTest {

	@Test
	public void test() {
		String functionType = "myFuncType";
		RequestResourceManagerFree tested = new RequestResourceManagerFree(functionType);
		assertEquals(functionType, tested.getFunctionType());
		assertEquals(RequestType.GET_FREE_RESOURCES, tested.getRequestType());
	}
}
